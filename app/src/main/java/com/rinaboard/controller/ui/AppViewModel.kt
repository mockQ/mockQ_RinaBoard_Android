// 中文注释：下一行声明当前 Kotlin 文件所属的软件包。
package com.rinaboard.controller.ui

// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import android.app.Application
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.lifecycle.AndroidViewModel
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.lifecycle.viewModelScope
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import com.rinaboard.controller.data.BatteryTelemetryReceiver
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import com.rinaboard.controller.data.BoardClient
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import com.rinaboard.controller.data.BoardProtocol
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import com.rinaboard.controller.data.BoardSettings
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import com.rinaboard.controller.model.BatteryState
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import com.rinaboard.controller.model.ConnectionState
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import com.rinaboard.controller.model.SequenceStep
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import com.rinaboard.controller.model.Su03tUpdateState
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import kotlinx.coroutines.Job
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import kotlinx.coroutines.delay
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import kotlinx.coroutines.flow.MutableStateFlow
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import kotlinx.coroutines.flow.StateFlow
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import kotlinx.coroutines.flow.asStateFlow
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import kotlinx.coroutines.isActive
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import kotlinx.coroutines.launch

// 中文注释：下一行定义当前模块使用的类型或单例对象。
class AppViewModel(app: Application) : AndroidViewModel(app) {
    // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
    private val settings = BoardSettings(app)
    // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
    private val client = BoardClient(settings)
    // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
    private val telemetry = BatteryTelemetryReceiver { state ->
        // 中文注释：下一行处理璃奈板电池电量或充电状态数据。
        _battery.value = state
        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
        _connection.value = ConnectionState.ONLINE
    // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
    }

    // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
    private val _connection = MutableStateFlow(ConnectionState.CHECKING)
    // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
    val connection: StateFlow<ConnectionState> = _connection.asStateFlow()

    // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
    private val _battery = MutableStateFlow(BatteryState())
    // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
    val battery: StateFlow<BatteryState> = _battery.asStateFlow()

    // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
    private val _message = MutableStateFlow("等待连接璃奈板")
    // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
    val message: StateFlow<String> = _message.asStateFlow()

    // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
    private val _busy = MutableStateFlow(false)
    // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
    val busy: StateFlow<Boolean> = _busy.asStateFlow()

    // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
    private val _update = MutableStateFlow(Su03tUpdateState())
    // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
    val update: StateFlow<Su03tUpdateState> = _update.asStateFlow()

    // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
    private val _suPowerOn = MutableStateFlow(true)
    // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
    val suPowerOn: StateFlow<Boolean> = _suPowerOn.asStateFlow()

    // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
    private val _host = MutableStateFlow(settings.host)
    // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
    val host: StateFlow<String> = _host.asStateFlow()

    // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
    private var updatePollJob: Job? = null

    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
    init {
        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
        telemetry.start(viewModelScope)
        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
        viewModelScope.launch {
            // 中文注释：下一行在条件成立期间持续循环处理数据。
            while (isActive) {
                // 中文注释：下一行处理璃奈板电池电量或充电状态数据。
                refreshBattery(silent = true)
                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                delay(8000)
            // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
            }
        // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
        }
    // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
    }

    // 中文注释：下一行定义函数，负责完成对应的业务或界面逻辑。
    fun setHost(value: String) {
        // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
        val clean = value.trim()
        // 中文注释：下一行根据条件决定是否执行对应分支。
        if (!isValidIpv4(clean)) {
            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
            _message.value = "IP 地址格式不正确"
            // 中文注释：下一行结束当前函数并返回计算结果。
            return
        // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
        }
        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
        settings.host = clean
        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
        _host.value = clean
        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
        _message.value = "设备地址已保存：$clean"
        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
        testConnection()
    // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
    }

    // 中文注释：下一行定义函数，负责完成对应的业务或界面逻辑。
    fun resetHost() = setHost(BoardSettings.DEFAULT_HOST)

    // 中文注释：下一行定义函数，负责完成对应的业务或界面逻辑。
    fun testConnection() {
        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
        viewModelScope.launch {
            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
            _connection.value = ConnectionState.CHECKING
            // 中文注释：下一行处理璃奈板电池电量或充电状态数据。
            refreshBattery(silent = false)
        // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
        }
    // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
    }

    // 中文注释：下一行定义函数，负责完成对应的业务或界面逻辑。
    fun refreshBattery(silent: Boolean = false) {
        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
        viewModelScope.launch {
            // 中文注释：下一行处理璃奈板电池电量或充电状态数据。
            client.battery()
                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                .onSuccess {
                    // 中文注释：下一行处理璃奈板电池电量或充电状态数据。
                    _battery.value = it
                    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                    _connection.value = ConnectionState.ONLINE
                    // 中文注释：下一行根据条件决定是否执行对应分支。
                    if (!silent) _message.value = "已连接璃奈板"
                // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                }
                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                .onFailure {
                    // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
                    val recentUdp = System.currentTimeMillis() - _battery.value.updatedAtMs < 15000
                    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                    _connection.value = if (recentUdp) ConnectionState.ONLINE else ConnectionState.OFFLINE
                    // 中文注释：下一行根据条件决定是否执行对应分支。
                    if (!silent) _message.value = "连接失败：${it.message ?: "请确认手机已连接 RinaCyanBoard"}"
                // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                }
        // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
        }
    // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
    }

    // 中文注释：下一行定义函数，负责完成对应的业务或界面逻辑。
    fun showFace(face: Int) = send(BoardProtocol.face(face), "已切换到表情 $face")
    // 中文注释：下一行定义函数，负责完成对应的业务或界面逻辑。
    fun previousFace() = send(BoardProtocol.PREVIOUS_FACE, "上一个表情")
    // 中文注释：下一行定义函数，负责完成对应的业务或界面逻辑。
    fun nextFace() = send(BoardProtocol.NEXT_FACE, "下一个表情")
    // 中文注释：下一行定义函数，负责完成对应的业务或界面逻辑。
    fun startLoop() = send(BoardProtocol.FACE_LOOP, "已开始表情轮播")
    // 中文注释：下一行定义函数，负责完成对应的业务或界面逻辑。
    fun stopAndBlink() = send(BoardProtocol.STOP_AND_BLINK, "已返回眨眼模式")
    // 中文注释：下一行定义函数，负责完成对应的业务或界面逻辑。
    fun blinkOn() = send(BoardProtocol.BLINK_ON, "眨眼模式已开启")
    // 中文注释：下一行定义函数，负责完成对应的业务或界面逻辑。
    fun blinkOff() = send(BoardProtocol.BLINK_OFF, "眨眼模式已暂停")
    // 中文注释：下一行定义函数，负责完成对应的业务或界面逻辑。
    fun screenOff() = send(BoardProtocol.SCREEN_OFF, "灯板已熄灭")

    // 中文注释：下一行定义函数，负责完成对应的业务或界面逻辑。
    fun playSequence(steps: List<SequenceStep>) {
        // 中文注释：下一行根据条件决定是否执行对应分支。
        if (steps.isEmpty()) {
            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
            _message.value = "请先添加表情序列"
            // 中文注释：下一行结束当前函数并返回计算结果。
            return
        // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
        }
        // 中文注释：下一行构造或发送与 ESP32-S3 通信的控制协议。
        send(BoardProtocol.sequence(steps), "表情序列已发送")
    // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
    }

    // 中文注释：下一行定义函数，负责完成对应的业务或界面逻辑。
    fun setSu03tPower(on: Boolean) {
        // 中文注释：下一行构造或发送与 ESP32-S3 通信的控制协议。
        send(if (on) BoardProtocol.SU03T_POWER_ON else BoardProtocol.SU03T_POWER_OFF,
            // 中文注释：下一行根据条件决定是否执行对应分支。
            if (on) "SU-03T 已上电" else "SU-03T 已断电") {
            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
            _suPowerOn.value = on
        // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
        }
    // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
    }

    // 中文注释：下一行定义函数，负责完成对应的业务或界面逻辑。
    fun startSu03tUpdate() {
        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
        viewModelScope.launch {
            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
            _busy.value = true
            // 中文注释：下一行构造或发送与 ESP32-S3 通信的控制协议。
            client.command(BoardProtocol.SU03T_UPDATE)
                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                .onSuccess {
                    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                    _message.value = it.ifBlank { "SU-03T 固件更新已启动" }
                    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                    pollUpdateStatus()
                // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                }
                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                .onFailure {
                    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                    _message.value = "启动升级失败：${it.message}"
                    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                    _connection.value = ConnectionState.OFFLINE
                // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                }
            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
            _busy.value = false
        // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
        }
    // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
    }

    // 中文注释：下一行定义函数，负责完成对应的业务或界面逻辑。
    fun refreshUpdateStatus() {
        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
        viewModelScope.launch {
            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
            client.updateStatus()
                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                .onSuccess { _update.value = it }
                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                .onFailure { _message.value = "读取升级状态失败：${it.message}" }
        // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
        }
    // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
    }

    // 中文注释：下一行定义函数，负责完成对应的业务或界面逻辑。
    private fun pollUpdateStatus() {
        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
        updatePollJob?.cancel()
        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
        updatePollJob = viewModelScope.launch {
            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
            repeat(180) {
                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                delay(1000)
                // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
                val result = client.updateStatus()
                // 中文注释：下一行根据条件决定是否执行对应分支。
                if (result.isSuccess) {
                    // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
                    val status = result.getOrThrow()
                    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                    _update.value = status
                    // 中文注释：下一行根据条件决定是否执行对应分支。
                    if (!status.running && status.state != "idle") {
                        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                        _message.value = when (status.state) {
                            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                            "success" -> "SU-03T 固件更新完成"
                            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                            "failed" -> "SU-03T 固件更新失败"
                            // 中文注释：下一行进入上一条件不成立时的处理分支。
                            else -> "SU-03T 状态：${status.state}"
                        // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                        }
                        // 中文注释：下一行结束当前函数并返回计算结果。
                        return@launch
                    // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                    }
                // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                }
            // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
            }
        // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
        }
    // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
    }

    // 中文注释：下一行定义函数，负责完成对应的业务或界面逻辑。
    private fun send(path: String, successMessage: String, afterSuccess: (() -> Unit)? = null) {
        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
        viewModelScope.launch {
            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
            _busy.value = true
            // 中文注释：下一行构造或发送与 ESP32-S3 通信的控制协议。
            client.command(path)
                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                .onSuccess {
                    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                    _connection.value = ConnectionState.ONLINE
                    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                    _message.value = successMessage
                    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                    afterSuccess?.invoke()
                // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                }
                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                .onFailure {
                    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                    _connection.value = ConnectionState.OFFLINE
                    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                    _message.value = "发送失败：${it.message ?: "网络不可达"}"
                // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                }
            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
            _busy.value = false
        // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
        }
    // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
    }

    // 中文注释：下一行定义函数，负责完成对应的业务或界面逻辑。
    private fun isValidIpv4(value: String): Boolean {
        // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
        val parts = value.split('.')
        // 中文注释：下一行根据条件决定是否执行对应分支。
        if (parts.size != 4) return false
        // 中文注释：下一行结束当前函数并返回计算结果。
        return parts.all { it.toIntOrNull()?.let { n -> n in 0..255 } == true }
    // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
    }

    // 中文注释：下一行定义函数，负责完成对应的业务或界面逻辑。
    override fun onCleared() {
        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
        telemetry.stop()
        // 中文注释：下一行处理灯珠颜色、画笔 RGB 或界面颜色。
        super.onCleared()
    // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
    }
// 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
}
