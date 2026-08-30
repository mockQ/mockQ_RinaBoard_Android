// 中文注释：下一行声明当前 Kotlin 文件所属的软件包。
package com.rinaboard.controller.data

// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import com.rinaboard.controller.model.BatteryState
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import com.rinaboard.controller.model.Su03tUpdateState
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import kotlinx.coroutines.Dispatchers
// 中文注释：下一行导入协程延时函数，用于彩色分包之间留出稳定处理时间。
import kotlinx.coroutines.delay
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import kotlinx.coroutines.withContext
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import java.net.InetSocketAddress
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import java.net.Socket

// 中文注释：下一行定义当前模块使用的类型或单例对象。
class BoardClient(private val settings: BoardSettings) {
    // 中文注释：下一行定义函数，负责完成对应的业务或界面逻辑。
    suspend fun command(path: String): Result<String> = withContext(Dispatchers.IO) {
        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
        runCatching {
            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
            require(path.isNotBlank()) { "命令不能为空" }
            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
            require(!path.any { it == '\r' || it == '\n' || it == ' ' }) { "命令包含非法字符" }
            // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
            val host = settings.host
            // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
            val request = "GET /$path HTTP/1.1\r\nHost: $host\r\nConnection: close\r\n\r\n"
            // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
            val requestBytes = request.toByteArray(Charsets.US_ASCII)
            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
            require(requestBytes.size <= 960) {
                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                "命令过长（${requestBytes.size} bytes），当前 ESP32 HTTP 缓冲区无法一次接收"
                // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
            }
            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
            Socket().use { socket ->
                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                socket.soTimeout = 2200
                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                socket.connect(InetSocketAddress(host, BoardSettings.DEFAULT_PORT), 1500)
                // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
                val output = socket.getOutputStream()
                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                output.write(requestBytes)
                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                output.flush()
                // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
                val response = socket.getInputStream().bufferedReader().readText()
                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                response.substringAfter("\r\n\r\n", response).trim()
                // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
            }
            // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
        }
        // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
    }

    // 中文注释：下一行定义可靠发送单条彩色协议命令的辅助函数，网络抖动时最多自动重试三次。
    private suspend fun reliableColorCommand(path: String, label: String): Result<String> {
        // 中文注释：下一行保存最后一次失败原因，三次都失败时返回给界面显示。
        var lastError: Throwable? = null
        // 中文注释：下一行最多尝试发送三次，同一个 PC 分块重复发送不会破坏 ESP32 的接收计数。
        repeat(3) { attempt ->
            // 中文注释：下一行真正通过 TCP/HTTP 向 ESP32 发送当前命令。
            val result = command(path)
            // 中文注释：下一行只有网络成功并且板子明确返回 OK 才认为本次发送可靠成功。
            if (result.isSuccess) {
                // 中文注释：下一行读取 ESP32 返回的文本内容。
                val text = result.getOrDefault("")
                // 中文注释：下一行板子返回 OK 时立即结束重试并把结果交给调用者。
                if (text.startsWith("OK", ignoreCase = true)) return Result.success(text)
                // 中文注释：下一行把板子返回 ERR 或其他异常响应保存为本轮失败原因。
                lastError = IllegalStateException("$label 被板子拒绝：$text")
                // 中文注释：下一行处理 TCP 连接、超时等网络层失败。
            } else {
                // 中文注释：下一行保存网络层抛出的最后一个异常。
                lastError = result.exceptionOrNull() ?: IllegalStateException("$label 网络发送失败")
                // 中文注释：下一行结束当前成功/失败响应分支。
            }
            // 中文注释：下一行不是最后一次尝试时等待 80ms，避免连续快速重连让 ESP32 HTTP 任务来不及释放 socket。
            if (attempt < 2) delay(80)
            // 中文注释：下一行结束最多三次重试循环。
        }
        // 中文注释：下一行三次都失败后，把最后一次具体错误返回给绘画页面。
        return Result.failure(lastError ?: IllegalStateException("$label 发送失败"))
        // 中文注释：下一行结束可靠彩色命令发送函数。
    }

    // 中文注释：下一行定义函数，负责把 308 颗灯珠完整 RGB 画面可靠发送到 ESP32。
    suspend fun sendColorFrame(frame: IntArray): Result<String> {
        // 中文注释：下一行检查画面长度，防止灯珠数量错位后造成整帧颜色串位。
        if (frame.size != BoardProtocol.LED_COUNT) {
            // 中文注释：下一行灯珠数量不是 308 时直接拒绝发送。
            return Result.failure(IllegalArgumentException("彩色画面必须包含 ${BoardProtocol.LED_COUNT} 颗灯珠"))
            // 中文注释：下一行结束灯珠数量检查。
        }
        // 中文注释：下一行先可靠发送 PB，让 ESP32 清空临时画面和 308 颗接收标记。
        val begin = reliableColorCommand(BoardProtocol.COLOR_FRAME_BEGIN, "PB")
        // 中文注释：下一行 PB 三次都失败时不再继续发送 PC，避免生成半帧。
        if (begin.isFailure) return Result.failure(begin.exceptionOrNull() ?: IllegalStateException("PB 发送失败"))
        // 中文注释：下一行逐个发送 32 颗一包的 PC 数据，缩短每次 HTTP 请求长度以提高稳定性。
        for (chunk in BoardProtocol.colorChunks(frame)) {
            // 中文注释：下一行可靠发送当前 PC 分块，失败时内部最多自动重试三次。
            val result = reliableColorCommand(chunk, "PC")
            // 中文注释：下一行任何一个分块最终失败都立即停止，绝不继续 PF 显示残缺画面。
            if (result.isFailure) return Result.failure(result.exceptionOrNull() ?: IllegalStateException("PC 分块发送失败"))
            // 中文注释：下一行每个 PC 包之间等待 25ms，给 ESP32 Wi-Fi 和解析任务留下稳定处理时间。
            delay(25)
            // 中文注释：下一行结束所有 PC 分块发送循环。
        }
        // 中文注释：下一行最后可靠发送 PF，ESP32 只有确认 308 颗全部收到才会真正刷新灯板。
        val finish = reliableColorCommand(BoardProtocol.COLOR_FRAME_FINISH, "PF")
        // 中文注释：下一行 PF 失败时把具体原因返回给界面，不再误报发送成功。
        if (finish.isFailure) return Result.failure(finish.exceptionOrNull() ?: IllegalStateException("PF 发送失败"))
        // 中文注释：下一行返回 ESP32 的最终成功响应。
        return Result.success(finish.getOrDefault("OK PF").ifBlank { "OK PF" })
        // 中文注释：下一行结束完整彩色帧发送函数。
    }

    // 中文注释：下一行定义函数，负责完成对应的业务或界面逻辑。
    suspend fun battery(): Result<BatteryState> = command(BoardProtocol.BATTERY).mapCatching {
        // 中文注释：下一行处理璃奈板电池电量或充电状态数据。
        BatteryState.fromJson(it, "HTTP")
        // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
    }

    // 中文注释：下一行定义函数，负责完成对应的业务或界面逻辑。
    suspend fun updateStatus(): Result<Su03tUpdateState> = command(BoardProtocol.SU03T_UPDATE_STATUS).mapCatching {
        // 中文注释：下一行处理 SU-03T 上下电、状态查询或固件升级相关逻辑。
        Su03tUpdateState.fromJson(it)
        // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
    }
// 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
}