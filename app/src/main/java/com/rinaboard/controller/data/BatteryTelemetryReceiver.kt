// 中文注释：下一行声明当前 Kotlin 文件所属的软件包。
package com.rinaboard.controller.data

// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import com.rinaboard.controller.model.BatteryState
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import kotlinx.coroutines.CoroutineScope
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import kotlinx.coroutines.Dispatchers
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import kotlinx.coroutines.Job
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import kotlinx.coroutines.isActive
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import kotlinx.coroutines.launch
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import java.net.DatagramPacket
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import java.net.DatagramSocket
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import java.net.InetSocketAddress
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import java.net.SocketTimeoutException

// 中文注释：下一行定义当前模块使用的类型或单例对象。
class BatteryTelemetryReceiver(
    // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
    private val port: Int = BoardSettings.BATTERY_UDP_PORT,
    // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
    private val onBattery: (BatteryState) -> Unit
// 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
) {
    // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
    private var job: Job? = null
    // 中文注释：下一行使用 Kotlin/Android 注解配置对应声明。
    @Volatile private var socket: DatagramSocket? = null

    // 中文注释：下一行定义函数，负责完成对应的业务或界面逻辑。
    fun start(scope: CoroutineScope) {
        // 中文注释：下一行根据条件决定是否执行对应分支。
        if (job?.isActive == true) return
        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
        job = scope.launch(Dispatchers.IO) {
            // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
            val s = DatagramSocket(null)
            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
            socket = s
            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
            try {
                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                s.reuseAddress = true
                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                s.broadcast = true
                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                s.soTimeout = 1000
                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                s.bind(InetSocketAddress(port))
                // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
                val buf = ByteArray(512)
                // 中文注释：下一行在条件成立期间持续循环处理数据。
                while (isActive) {
                    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                    try {
                        // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
                        val packet = DatagramPacket(buf, buf.size)
                        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                        s.receive(packet)
                        // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
                        val text = String(packet.data, packet.offset, packet.length, Charsets.UTF_8)
                        // 中文注释：下一行根据条件决定是否执行对应分支。
                        if (text.contains("\"type\":\"battery\"")) {
                            // 中文注释：下一行处理璃奈板电池电量或充电状态数据。
                            runCatching { BatteryState.fromJson(text, "UDP") }
                                // 中文注释：下一行处理璃奈板电池电量或充电状态数据。
                                .onSuccess(onBattery)
                        // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                        }
                    // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                    } catch (_: SocketTimeoutException) {
                        // 中文注释：下面原有注释用于说明相邻代码的设计目的。
                        // 用超时让协程有机会检查取消状态。
                    // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                    }
                // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                }
            // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
            } finally {
                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                s.close()
                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                socket = null
            // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
            }
        // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
        }
    // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
    }

    // 中文注释：下一行定义函数，负责完成对应的业务或界面逻辑。
    fun stop() {
        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
        socket?.close()
        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
        job?.cancel()
        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
        job = null
    // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
    }
// 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
}
