// 中文注释：下一行声明当前 Kotlin 文件所属的软件包。
package com.rinaboard.controller.data

// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import com.rinaboard.controller.model.SequenceStep

// 中文注释：下一行定义当前模块使用的类型或单例对象。
object BoardProtocol {
    // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
    const val LED_COUNT = 308
    // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。

    // 中文注释：下一行定义函数，负责完成对应的业务或界面逻辑。
    fun face(number: Int) = "FC${number.coerceAtLeast(0)}"
    // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
    const val SCREEN_OFF = "FC0"
    // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
    const val NEXT_FACE = "FD"
    // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
    const val PREVIOUS_FACE = "FU"
    // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
    const val FACE_LOOP = "FL"
    // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
    const val STOP_AND_BLINK = "FS"
    // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
    const val BLINK_ON = "BL1"
    // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
    const val BLINK_OFF = "BL0"
    // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
    const val BATTERY = "BT"
    // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
    const val SU03T_UPDATE = "SU"
    // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
    const val SU03T_UPDATE_STATUS = "US"
    // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
    const val SU03T_POWER_ON = "VP1"
    // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
    const val SU03T_POWER_OFF = "VP0"
    // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。

    // 亮度协议：BR0~BR200 设置亮度，BQ 查询当前亮度。100~200% 映射到固定色相剩余的物理亮度余量。
    fun brightness(percent: Int) = "BR${percent.coerceIn(0, 200)}"
    const val BRIGHTNESS_QUERY = "BQ"

    // 中文注释：下一行定义函数，负责完成对应的业务或界面逻辑。
    fun draw(ids: Collection<Int>): String =
        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
        "DR" + ids.asSequence().filter { it in 0 until LED_COUNT }.distinct().sorted().joinToString(",")

    fun sequence(steps: List<SequenceStep>): String = buildString {
        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
        append("SQ")
        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
        steps.forEach {
            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
            append(it.face.coerceAtLeast(1))
            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
            append(',')
            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
            append(it.durationMs.coerceAtLeast(100))
            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
            append(';')
            // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
        }
        // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
    }

}
