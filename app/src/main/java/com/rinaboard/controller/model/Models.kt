// 中文注释：下一行声明当前 Kotlin 文件所属的软件包。
package com.rinaboard.controller.model

// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import org.json.JSONObject

// 中文注释：下一行定义当前模块使用的类型或单例对象。
data class BatteryState(
    // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
    val millivolts: Int = 0,
    // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
    val percent: Int = 0,
    // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
    val charging: Boolean = false,
    // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
    val full: Boolean = false,
    // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
    val updatedAtMs: Long = 0L,
    // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
    val source: String = ""
// 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
) {
    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
    companion object {
        // 中文注释：下一行定义函数，负责完成对应的业务或界面逻辑。
        fun fromJson(text: String, source: String): BatteryState {
            // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
            val obj = JSONObject(text)
            // 中文注释：下一行结束当前函数并返回计算结果。
            return BatteryState(
                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                millivolts = obj.optInt("mv", 0),
                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                percent = obj.optInt("percent", 0).coerceIn(0, 100),
                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                charging = obj.optBoolean("charging", false),
                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                full = obj.optBoolean("full", false),
                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                updatedAtMs = System.currentTimeMillis(),
                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                source = source
            // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
            )
        // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
        }
    // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
    }
// 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
}

// 中文注释：下一行定义当前模块使用的类型或单例对象。
data class Su03tUpdateState(
    // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
    val state: String = "idle",
    // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
    val progress: Int = 0
// 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
) {
    // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
    val running: Boolean get() = state == "running"

    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
    companion object {
        // 中文注释：下一行定义函数，负责完成对应的业务或界面逻辑。
        fun fromJson(text: String): Su03tUpdateState {
            // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
            val obj = JSONObject(text)
            // 中文注释：下一行结束当前函数并返回计算结果。
            return Su03tUpdateState(
                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                state = obj.optString("state", "idle"),
                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                progress = obj.optInt("progress", 0).coerceIn(0, 100)
            // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
            )
        // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
        }
    // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
    }
// 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
}

// 中文注释：下一行定义当前模块使用的类型或单例对象。
data class SequenceStep(
    // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
    val face: Int,
    // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
    val durationMs: Int
// 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
)

// 中文注释：下一行定义当前模块使用的类型或单例对象。
enum class ConnectionState {
    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
    CHECKING,
    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
    ONLINE,
    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
    OFFLINE
// 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
}
