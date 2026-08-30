// 中文注释：下一行声明当前 Kotlin 文件所属的软件包。
package com.rinaboard.controller.data

// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import android.content.Context

// 中文注释：下一行定义当前模块使用的类型或单例对象。
class BoardSettings(context: Context) {
    // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
    private val prefs = context.applicationContext.getSharedPreferences("rina_board", Context.MODE_PRIVATE)

    // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
    var host: String
        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
        get() = prefs.getString(KEY_HOST, DEFAULT_HOST) ?: DEFAULT_HOST
        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
        set(value) = prefs.edit().putString(KEY_HOST, value.trim()).apply()

    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
    companion object {
        // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
        const val DEFAULT_HOST = "192.168.1.18"
        // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
        const val DEFAULT_PORT = 80
        // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
        const val BATTERY_UDP_PORT = 5001
        // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
        const val AP_SSID = "RinaCyanBoard"
        // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
        const val AP_PASSWORD = "1211009rina"
        // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
        private const val KEY_HOST = "device_host"
    // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
    }
// 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
}
