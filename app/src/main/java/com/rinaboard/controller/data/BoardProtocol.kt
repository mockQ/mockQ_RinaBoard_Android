// 中文注释：下一行声明当前 Kotlin 文件所属的软件包。
package com.rinaboard.controller.data

// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import com.rinaboard.controller.model.SequenceStep

// 中文注释：下一行定义当前模块使用的类型或单例对象。
object BoardProtocol {
    // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
    const val LED_COUNT = 308
    // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
    const val COLOR_CHUNK_PIXELS = 32

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
    const val COLOR_FRAME_BEGIN = "PB"
    // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
    const val COLOR_FRAME_FINISH = "PF"

    // 中文注释：下一行定义函数，负责完成对应的业务或界面逻辑。
    fun draw(ids: Collection<Int>): String =
        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
        "DR" + ids.asSequence().filter { it in 0 until LED_COUNT }.distinct().sorted().joinToString(",")

    // 中文注释：下一行定义函数，负责完成对应的业务或界面逻辑。
    fun colorChunk(startIndex: Int, colors: IntArray): String {
        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
        require(startIndex in 0 until LED_COUNT) { "彩色分块起始灯珠编号越界" }
        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
        require(colors.isNotEmpty()) { "彩色分块不能为空" }
        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
        require(colors.size <= COLOR_CHUNK_PIXELS) { "单个彩色分块最多 $COLOR_CHUNK_PIXELS 颗灯珠" }
        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
        require(startIndex + colors.size <= LED_COUNT) { "彩色分块超出灯珠总数" }
        // 中文注释：下一行结束当前函数并返回计算结果。
        return buildString(3 + colors.size * 6) {
            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
            append("PC")
            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
            append(startIndex)
            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
            append(',')
            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
            colors.forEach { argb ->
                // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
                val red = (argb shr 16) and 0xFF
                // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
                val green = (argb shr 8) and 0xFF
                // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
                val blue = argb and 0xFF
                // 中文注释：下一行处理灯珠颜色、画笔 RGB 或界面颜色。
                append(HEX[red ushr 4])
                // 中文注释：下一行处理灯珠颜色、画笔 RGB 或界面颜色。
                append(HEX[red and 0x0F])
                // 中文注释：下一行处理灯珠颜色、画笔 RGB 或界面颜色。
                append(HEX[green ushr 4])
                // 中文注释：下一行处理灯珠颜色、画笔 RGB 或界面颜色。
                append(HEX[green and 0x0F])
                // 中文注释：下一行处理灯珠颜色、画笔 RGB 或界面颜色。
                append(HEX[blue ushr 4])
                // 中文注释：下一行处理灯珠颜色、画笔 RGB 或界面颜色。
                append(HEX[blue and 0x0F])
                // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
            }
            // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
        }
        // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
    }

    // 中文注释：下一行定义函数，负责完成对应的业务或界面逻辑。
    fun colorChunks(frame: IntArray): List<String> {
        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
        require(frame.size == LED_COUNT) { "彩色画面必须包含 $LED_COUNT 颗灯珠" }
        // 中文注释：下一行结束当前函数并返回计算结果。
        return buildList {
            // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
            var start = 0
            // 中文注释：下一行在条件成立期间持续循环处理数据。
            while (start < LED_COUNT) {
                // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
                val count = minOf(COLOR_CHUNK_PIXELS, LED_COUNT - start)
                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                add(colorChunk(start, frame.copyOfRange(start, start + count)))
                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                start += count
                // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
            }
            // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
        }
        // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
    }

    // 中文注释：下一行定义函数，负责完成对应的业务或界面逻辑。
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

    // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
    private const val HEX = "0123456789ABCDEF"
// 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
}
