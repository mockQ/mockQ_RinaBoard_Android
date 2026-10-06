package com.rinaboard.controller.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.rinaboard.controller.data.BoardClient
import com.rinaboard.controller.data.BoardProtocol
import com.rinaboard.controller.data.BoardSettings
import com.rinaboard.controller.model.BatteryState
import com.rinaboard.controller.model.ConnectionState
import com.rinaboard.controller.model.SequenceStep
import com.rinaboard.controller.model.Su03tUpdateState
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch

class AppViewModel(app: Application) : AndroidViewModel(app) {
    private val settings = BoardSettings(app)
    private val client = BoardClient(app)

    private val _connection = MutableStateFlow(ConnectionState.CHECKING)
    val connection: StateFlow<ConnectionState> = _connection.asStateFlow()

    private val _battery = MutableStateFlow(BatteryState())
    val battery: StateFlow<BatteryState> = _battery.asStateFlow()

    private val _message = MutableStateFlow("等待蓝牙连接璃奈板")
    val message: StateFlow<String> = _message.asStateFlow()

    private val _busy = MutableStateFlow(false)
    val busy: StateFlow<Boolean> = _busy.asStateFlow()

    private val _update = MutableStateFlow(Su03tUpdateState())
    val update: StateFlow<Su03tUpdateState> = _update.asStateFlow()

    private val _suPowerOn = MutableStateFlow(true)
    val suPowerOn: StateFlow<Boolean> = _suPowerOn.asStateFlow()

    private val initialBrightnessMin = settings.brightnessMin.coerceIn(0, 199)
    private val initialBrightnessMax = settings.brightnessMax.coerceIn(initialBrightnessMin + 1, 200)

    private val _brightnessMin = MutableStateFlow(initialBrightnessMin)
    val brightnessMin: StateFlow<Int> = _brightnessMin.asStateFlow()

    private val _brightnessMax = MutableStateFlow(initialBrightnessMax)
    val brightnessMax: StateFlow<Int> = _brightnessMax.asStateFlow()

    private val _brightness = MutableStateFlow(
        settings.brightnessValue.coerceIn(initialBrightnessMin, initialBrightnessMax)
    )
    val brightness: StateFlow<Int> = _brightness.asStateFlow()

    private var updatePollJob: Job? = null
    private var brightnessSendJob: Job? = null
    private var pendingBrightness: Int? = null
    private var brightnessSynced = false

    init {
        // BLE 底层连接状态直接同步到界面。
        viewModelScope.launch {
            client.connectionState.collectLatest { state ->
                _connection.value = state
                if (state == ConnectionState.ONLINE) {
                    _message.value = "蓝牙已连接璃奈板"
                    if (!brightnessSynced) refreshBrightness(silent = true)
                }
            }
        }

        // 电量不再依赖 Wi-Fi UDP，BLE 在线时每 8 秒主动读取一次 BT。
        viewModelScope.launch {
            while (isActive) {
                if (_connection.value == ConnectionState.ONLINE) {
                    refreshBattery(silent = true)
                }
                delay(8000)
            }
        }
    }

    fun testConnection() {
        viewModelScope.launch {
            _connection.value = ConnectionState.CHECKING
            _message.value = "正在扫描 RinaBoard…"
            client.connect()
                .onSuccess {
                    _connection.value = ConnectionState.ONLINE
                    _message.value = "蓝牙已连接璃奈板"
                    refreshBattery(silent = true)
                    refreshBrightness(silent = true)
                }
                .onFailure {
                    _connection.value = ConnectionState.OFFLINE
                    _message.value = "蓝牙连接失败：${friendlyBleError(it)}"
                }
        }
    }

    fun disconnectBluetooth() {
        client.disconnect()
        brightnessSynced = false
        _connection.value = ConnectionState.OFFLINE
        _message.value = "蓝牙已断开"
    }

    fun refreshBattery(silent: Boolean = false) {
        viewModelScope.launch {
            client.battery()
                .onSuccess {
                    _battery.value = it
                    _connection.value = ConnectionState.ONLINE
                    if (!brightnessSynced) refreshBrightness(silent = true)
                    if (!silent) _message.value = "电量已刷新"
                }
                .onFailure {
                    _connection.value = ConnectionState.OFFLINE
                    if (!silent) _message.value = "读取电量失败：${friendlyBleError(it)}"
                }
        }
    }

    fun showFace(face: Int) = send(BoardProtocol.face(face), "已切换到表情 $face")
    fun previousFace() = send(BoardProtocol.PREVIOUS_FACE, "上一个表情")
    fun nextFace() = send(BoardProtocol.NEXT_FACE, "下一个表情")
    fun startLoop() = send(BoardProtocol.FACE_LOOP, "已开始表情轮播")
    fun stopAndBlink() = send(BoardProtocol.STOP_AND_BLINK, "已返回眨眼模式")
    fun blinkOn() = send(BoardProtocol.BLINK_ON, "眨眼模式已开启")
    fun blinkOff() = send(BoardProtocol.BLINK_OFF, "眨眼模式已暂停")
    fun screenOff() = send(BoardProtocol.SCREEN_OFF, "灯板已熄灭")

    /** 设备页拉条实时亮度。UI 立即更新，BLE 后台始终只发送最新值。 */
    fun setBrightness(value: Int) {
        val target = value.coerceIn(_brightnessMin.value, _brightnessMax.value)
        _brightness.value = target
        settings.brightnessValue = target
        pendingBrightness = target
        startBrightnessSender()
    }

    fun commitBrightness() {
        pendingBrightness = _brightness.value
        startBrightnessSender()
    }

    fun setBrightnessLimits(minValue: Int, maxValue: Int) {
        var low = minValue.coerceIn(0, 199)
        var high = maxValue.coerceIn(1, 200)
        if (low >= high) {
            if (high < 200) high = low + 1 else low = high - 1
        }

        _brightnessMin.value = low
        _brightnessMax.value = high
        settings.brightnessMin = low
        settings.brightnessMax = high

        val clamped = _brightness.value.coerceIn(low, high)
        _message.value = "亮度范围已保存：$low% ~ $high%"
        if (clamped != _brightness.value) setBrightness(clamped)
    }

    fun resetBrightnessLimits() {
        setBrightnessLimits(BoardSettings.DEFAULT_BRIGHTNESS_MIN, BoardSettings.DEFAULT_BRIGHTNESS_MAX)
    }

    fun refreshBrightness(silent: Boolean = false) {
        viewModelScope.launch {
            client.brightness()
                .onSuccess { boardValue ->
                    brightnessSynced = true
                    _connection.value = ConnectionState.ONLINE
                    val clamped = boardValue.coerceIn(_brightnessMin.value, _brightnessMax.value)
                    _brightness.value = clamped
                    settings.brightnessValue = clamped
                    if (clamped != boardValue) {
                        pendingBrightness = clamped
                        startBrightnessSender()
                    }
                    if (!silent) _message.value = "当前亮度：$clamped%"
                }
                .onFailure {
                    if (!silent) _message.value = "读取亮度失败：${friendlyBleError(it)}"
                }
        }
    }

    private fun startBrightnessSender() {
        if (brightnessSendJob?.isActive == true) return
        brightnessSendJob = viewModelScope.launch {
            try {
                while (isActive) {
                    val target = pendingBrightness ?: break
                    pendingBrightness = null

                    client.command(BoardProtocol.brightness(target))
                        .onSuccess { _connection.value = ConnectionState.ONLINE }
                        .onFailure {
                            _connection.value = ConnectionState.OFFLINE
                            _message.value = "亮度发送失败：${friendlyBleError(it)}"
                        }

                    if (pendingBrightness == null) break
                    delay(60)
                }
            } finally {
                brightnessSendJob = null
                if (pendingBrightness != null) startBrightnessSender()
            }
        }
    }

    fun playSequence(steps: List<SequenceStep>) {
        if (steps.isEmpty()) {
            _message.value = "请先添加表情序列"
            return
        }
        send(BoardProtocol.sequence(steps), "表情序列已发送")
    }

    fun setSu03tPower(on: Boolean) {
        send(
            if (on) BoardProtocol.SU03T_POWER_ON else BoardProtocol.SU03T_POWER_OFF,
            if (on) "SU-03T 已上电" else "SU-03T 已断电"
        ) {
            _suPowerOn.value = on
        }
    }

    fun startSu03tUpdate() {
        viewModelScope.launch {
            _busy.value = true
            client.command(BoardProtocol.SU03T_UPDATE)
                .onSuccess {
                    _message.value = it.ifBlank { "SU-03T 固件更新已启动" }
                    pollUpdateStatus()
                }
                .onFailure {
                    _message.value = "启动升级失败：${friendlyBleError(it)}"
                    _connection.value = ConnectionState.OFFLINE
                }
            _busy.value = false
        }
    }

    fun refreshUpdateStatus() {
        viewModelScope.launch {
            client.updateStatus()
                .onSuccess { _update.value = it }
                .onFailure { _message.value = "读取升级状态失败：${friendlyBleError(it)}" }
        }
    }

    private fun pollUpdateStatus() {
        updatePollJob?.cancel()
        updatePollJob = viewModelScope.launch {
            repeat(180) {
                delay(1000)
                val result = client.updateStatus()
                if (result.isSuccess) {
                    val status = result.getOrThrow()
                    _update.value = status
                    if (!status.running && status.state != "idle") {
                        _message.value = when (status.state) {
                            "success" -> "SU-03T 固件更新完成"
                            "failed" -> "SU-03T 固件更新失败"
                            else -> "SU-03T 状态：${status.state}"
                        }
                        return@launch
                    }
                }
            }
        }
    }

    private fun send(path: String, successMessage: String, afterSuccess: (() -> Unit)? = null) {
        viewModelScope.launch {
            _busy.value = true
            client.command(path)
                .onSuccess {
                    _connection.value = ConnectionState.ONLINE
                    _message.value = successMessage
                    afterSuccess?.invoke()
                }
                .onFailure {
                    _connection.value = ConnectionState.OFFLINE
                    _message.value = "发送失败：${friendlyBleError(it)}"
                }
            _busy.value = false
        }
    }

    private fun friendlyBleError(t: Throwable): String {
        val raw = t.message ?: "未知错误"
        return when {
            raw.contains("permission", ignoreCase = true) || raw.contains("权限") -> "请允许附近设备/蓝牙权限"
            raw.contains("timeout", ignoreCase = true) -> "未找到 RinaBoard，请确认板子已开机并在附近"
            raw.contains("蓝牙未开启") -> "请先打开手机蓝牙"
            else -> raw
        }
    }
}
