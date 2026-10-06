package com.rinaboard.controller.data

import android.Manifest
import android.annotation.SuppressLint
import android.bluetooth.BluetoothGatt
import android.bluetooth.BluetoothGattCallback
import android.bluetooth.BluetoothGattCharacteristic
import android.bluetooth.BluetoothGattDescriptor
import android.bluetooth.BluetoothManager
import android.bluetooth.BluetoothProfile
import android.bluetooth.le.ScanCallback
import android.bluetooth.le.ScanFilter
import android.bluetooth.le.ScanResult
import android.bluetooth.le.ScanSettings
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.os.ParcelUuid
import androidx.core.content.ContextCompat
import com.rinaboard.controller.model.ConnectionState
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.coroutines.withContext
import kotlinx.coroutines.withTimeout
import java.util.UUID

/**
 * 璃奈板 BLE 传输层。
 *
 * 手机与 ESP32-S3 之间使用一个类似 Nordic-UART 的自定义 GATT 服务：
 * - RX：APP -> ESP32，Write
 * - TX：ESP32 -> APP，Notify
 *
 * 应用层使用 FC/BT/BR/DR 等字符串协议；临时绘画仅发送点亮灯珠编号，不再发送 RGB。
 * 为了不受 ATT MTU 限制，每条命令末尾追加 '\n'，然后按当前 MTU 自动拆包；
 * ESP32 端收到 '\n' 后再执行整条命令，并用 Notify 返回一行以 '\n' 结束的结果。
 */
class BoardBleManager private constructor(context: Context) {
    private val appContext = context.applicationContext
    private val bluetoothManager = appContext.getSystemService(Context.BLUETOOTH_SERVICE) as BluetoothManager
    private val adapter get() = bluetoothManager.adapter

    private val _connectionState = MutableStateFlow(ConnectionState.OFFLINE)
    val connectionState: StateFlow<ConnectionState> = _connectionState.asStateFlow()

    private val connectMutex = Mutex()
    private val commandMutex = Mutex()

    @Volatile private var gatt: BluetoothGatt? = null
    @Volatile private var rxCharacteristic: BluetoothGattCharacteristic? = null
    @Volatile private var txCharacteristic: BluetoothGattCharacteristic? = null
    @Volatile private var mtu: Int = 23
    @Volatile private var scanning = false

    private var readyDeferred: CompletableDeferred<Unit>? = null
    private var writeDeferred: CompletableDeferred<Int>? = null
    private var responseDeferred: CompletableDeferred<String>? = null
    private val responseBuffer = StringBuilder()

    private fun hasScanPermission(): Boolean = when {
        Build.VERSION.SDK_INT >= Build.VERSION_CODES.S ->
            ContextCompat.checkSelfPermission(appContext, Manifest.permission.BLUETOOTH_SCAN) == PackageManager.PERMISSION_GRANTED
        else ->
            ContextCompat.checkSelfPermission(appContext, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
    }

    private fun hasConnectPermission(): Boolean =
        Build.VERSION.SDK_INT < Build.VERSION_CODES.S ||
                ContextCompat.checkSelfPermission(appContext, Manifest.permission.BLUETOOTH_CONNECT) == PackageManager.PERMISSION_GRANTED

    private fun requirePermissions() {
        check(hasScanPermission()) { "缺少蓝牙扫描权限，请先允许附近设备/位置信息权限" }
        check(hasConnectPermission()) { "缺少蓝牙连接权限，请先允许附近设备权限" }
    }

    @SuppressLint("MissingPermission")
    suspend fun connect(timeoutMs: Long = 12_000): Result<Unit> = withContext(Dispatchers.IO) {
        runCatching {
            connectMutex.withLock {
                if (isReady()) return@withLock
                requirePermissions()
                check(adapter != null) { "此手机不支持蓝牙" }
                check(adapter.isEnabled) { "蓝牙未开启" }

                closeCurrentGatt()
                _connectionState.value = ConnectionState.CHECKING
                val waiter = CompletableDeferred<Unit>()
                readyDeferred = waiter
                startScan()

                try {
                    withTimeout(timeoutMs) { waiter.await() }
                } catch (t: Throwable) {
                    stopScan()
                    closeCurrentGatt()
                    _connectionState.value = ConnectionState.OFFLINE
                    throw t
                }
            }
        }
    }

    @SuppressLint("MissingPermission")
    fun disconnect() {
        stopScan()
        runCatching { gatt?.disconnect() }
        closeCurrentGatt()
        _connectionState.value = ConnectionState.OFFLINE
    }

    /** 发送一条旧协议命令，并等待 ESP32 返回一行文本。 */
    suspend fun command(command: String, timeoutMs: Long = 3_500): String = commandMutex.withLock {
        require(command.isNotBlank()) { "命令不能为空" }
        require(!command.contains('\n') && !command.contains('\r')) { "命令包含非法换行" }

        if (!isReady()) {
            connect().getOrThrow()
        }

        val response = CompletableDeferred<String>()
        synchronized(responseBuffer) { responseBuffer.clear() }
        responseDeferred = response

        try {
            writeLine("$command\n")
            withTimeout(timeoutMs) { response.await() }
        } finally {
            if (responseDeferred === response) responseDeferred = null
        }
    }

    private fun isReady(): Boolean =
        _connectionState.value == ConnectionState.ONLINE &&
                gatt != null && rxCharacteristic != null && txCharacteristic != null

    @SuppressLint("MissingPermission")
    private fun startScan() {
        if (scanning) return
        val scanner = adapter.bluetoothLeScanner ?: error("无法启动 BLE 扫描")
        val filter = ScanFilter.Builder()
            .setServiceUuid(ParcelUuid(SERVICE_UUID))
            .build()
        val settings = ScanSettings.Builder()
            .setScanMode(ScanSettings.SCAN_MODE_LOW_LATENCY)
            .build()
        scanning = true
        scanner.startScan(listOf(filter), settings, scanCallback)
    }

    @SuppressLint("MissingPermission")
    private fun stopScan() {
        if (!scanning || adapter == null || !hasScanPermission()) return
        runCatching { adapter.bluetoothLeScanner?.stopScan(scanCallback) }
        scanning = false
    }

    private val scanCallback = object : ScanCallback() {
        @SuppressLint("MissingPermission")
        override fun onScanResult(callbackType: Int, result: ScanResult) {
            if (!scanning) return
            stopScan()
            val device = result.device
            val newGatt = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                device.connectGatt(appContext, false, gattCallback, android.bluetooth.BluetoothDevice.TRANSPORT_LE)
            } else {
                device.connectGatt(appContext, false, gattCallback)
            }
            gatt = newGatt
        }

        override fun onScanFailed(errorCode: Int) {
            scanning = false
            failConnection(IllegalStateException("BLE 扫描失败：$errorCode"))
        }
    }

    private val gattCallback = object : BluetoothGattCallback() {
        @SuppressLint("MissingPermission")
        override fun onConnectionStateChange(g: BluetoothGatt, status: Int, newState: Int) {
            if (status != BluetoothGatt.GATT_SUCCESS || newState != BluetoothProfile.STATE_CONNECTED) {
                if (newState == BluetoothProfile.STATE_DISCONNECTED || status != BluetoothGatt.GATT_SUCCESS) {
                    if (gatt === g) closeCurrentGatt()
                    _connectionState.value = ConnectionState.OFFLINE
                    readyDeferred?.let { if (!it.isCompleted) it.completeExceptionally(IllegalStateException("BLE 连接断开：$status")) }
                    responseDeferred?.let { if (!it.isCompleted) it.completeExceptionally(IllegalStateException("BLE 连接已断开")) }
                }
                return
            }
            gatt = g
            g.discoverServices()
        }

        @SuppressLint("MissingPermission")
        override fun onServicesDiscovered(g: BluetoothGatt, status: Int) {
            if (status != BluetoothGatt.GATT_SUCCESS) {
                failConnection(IllegalStateException("BLE 服务发现失败：$status"))
                return
            }
            val service = g.getService(SERVICE_UUID)
            val rx = service?.getCharacteristic(RX_UUID)
            val tx = service?.getCharacteristic(TX_UUID)
            if (service == null || rx == null || tx == null) {
                failConnection(IllegalStateException("未找到璃奈板 BLE 控制服务"))
                return
            }
            rxCharacteristic = rx
            txCharacteristic = tx
            runCatching { g.requestMtu(247) }

            if (!g.setCharacteristicNotification(tx, true)) {
                failConnection(IllegalStateException("无法启用 BLE 通知"))
                return
            }
            val cccd = tx.getDescriptor(CCCD_UUID)
            if (cccd == null) {
                failConnection(IllegalStateException("BLE 通知描述符不存在"))
                return
            }
            val started = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                g.writeDescriptor(cccd, BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE) == android.bluetooth.BluetoothStatusCodes.SUCCESS
            } else {
                @Suppress("DEPRECATION")
                cccd.value = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE
                @Suppress("DEPRECATION")
                g.writeDescriptor(cccd)
            }
            if (!started) failConnection(IllegalStateException("无法写入 BLE 通知配置"))
        }

        override fun onMtuChanged(gatt: BluetoothGatt, mtuValue: Int, status: Int) {
            if (status == BluetoothGatt.GATT_SUCCESS) mtu = mtuValue.coerceAtLeast(23)
        }

        override fun onDescriptorWrite(gatt: BluetoothGatt, descriptor: BluetoothGattDescriptor, status: Int) {
            if (descriptor.uuid != CCCD_UUID) return
            if (status == BluetoothGatt.GATT_SUCCESS) {
                _connectionState.value = ConnectionState.ONLINE
                readyDeferred?.let { if (!it.isCompleted) it.complete(Unit) }
            } else {
                failConnection(IllegalStateException("BLE 通知启用失败：$status"))
            }
        }

        override fun onCharacteristicWrite(gatt: BluetoothGatt, characteristic: BluetoothGattCharacteristic, status: Int) {
            writeDeferred?.let { if (!it.isCompleted) it.complete(status) }
        }

        @Deprecated("Deprecated in Android 13")
        override fun onCharacteristicChanged(gatt: BluetoothGatt, characteristic: BluetoothGattCharacteristic) {
            @Suppress("DEPRECATION")
            handleNotification(characteristic.value ?: return)
        }

        override fun onCharacteristicChanged(gatt: BluetoothGatt, characteristic: BluetoothGattCharacteristic, value: ByteArray) {
            handleNotification(value)
        }
    }

    private fun handleNotification(value: ByteArray) {
        val incoming = value.toString(Charsets.UTF_8)
        synchronized(responseBuffer) {
            responseBuffer.append(incoming)
            while (true) {
                val end = responseBuffer.indexOf("\n")
                if (end < 0) break
                val line = responseBuffer.substring(0, end).trimEnd('\r')
                responseBuffer.delete(0, end + 1)
                val waiter = responseDeferred
                if (waiter != null && !waiter.isCompleted) {
                    waiter.complete(line)
                    break
                }
            }
        }
    }

    @SuppressLint("MissingPermission")
    private suspend fun writeLine(line: String) {
        val g = gatt ?: error("BLE 未连接")
        val rx = rxCharacteristic ?: error("BLE RX 特征未就绪")
        val bytes = line.toByteArray(Charsets.UTF_8)
        val payload = (mtu - 3).coerceAtLeast(20)

        var offset = 0
        while (offset < bytes.size) {
            val end = minOf(bytes.size, offset + payload)
            val chunk = bytes.copyOfRange(offset, end)
            val waiter = CompletableDeferred<Int>()
            writeDeferred = waiter

            val started = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                g.writeCharacteristic(rx, chunk, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT) == android.bluetooth.BluetoothStatusCodes.SUCCESS
            } else {
                @Suppress("DEPRECATION")
                rx.writeType = BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT
                @Suppress("DEPRECATION")
                rx.value = chunk
                @Suppress("DEPRECATION")
                g.writeCharacteristic(rx)
            }
            check(started) { "BLE 写入启动失败" }

            val status = withTimeout(2_500) { waiter.await() }
            check(status == BluetoothGatt.GATT_SUCCESS) { "BLE 写入失败：$status" }
            if (writeDeferred === waiter) writeDeferred = null
            offset = end
        }
    }

    @SuppressLint("MissingPermission")
    private fun closeCurrentGatt() {
        val old = gatt
        gatt = null
        rxCharacteristic = null
        txCharacteristic = null
        mtu = 23
        runCatching { old?.close() }
    }

    private fun failConnection(error: Throwable) {
        stopScan()
        _connectionState.value = ConnectionState.OFFLINE
        readyDeferred?.let { if (!it.isCompleted) it.completeExceptionally(error) }
        responseDeferred?.let { if (!it.isCompleted) it.completeExceptionally(error) }
    }

    companion object {
        val SERVICE_UUID: UUID = UUID.fromString("6e400001-b5a3-f393-e0a9-e50e24dcca9e")
        val RX_UUID: UUID = UUID.fromString("6e400002-b5a3-f393-e0a9-e50e24dcca9e")
        val TX_UUID: UUID = UUID.fromString("6e400003-b5a3-f393-e0a9-e50e24dcca9e")
        private val CCCD_UUID: UUID = UUID.fromString("00002902-0000-1000-8000-00805f9b34fb")

        @Volatile private var instance: BoardBleManager? = null
        fun get(context: Context): BoardBleManager = instance ?: synchronized(this) {
            instance ?: BoardBleManager(context).also { instance = it }
        }
    }
}
