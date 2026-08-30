// 中文注释：下一行声明当前 Kotlin 文件所属的软件包。
package com.rinaboard.controller

// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import android.os.Bundle
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.activity.ComponentActivity
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.activity.compose.setContent
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.activity.enableEdgeToEdge
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.lifecycle.viewmodel.compose.viewModel
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import com.rinaboard.controller.ui.AppViewModel
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import com.rinaboard.controller.ui.RinaBoardApp
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import com.rinaboard.controller.ui.theme.RinaTheme

// 中文注释：下一行定义当前模块使用的类型或单例对象。
class MainActivity : ComponentActivity() {
    // 中文注释：下一行定义函数，负责完成对应的业务或界面逻辑。
    override fun onCreate(savedInstanceState: Bundle?) {
        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
        super.onCreate(savedInstanceState)
        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
        enableEdgeToEdge()
        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
        setContent {
            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
            RinaTheme {
                // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
                val vm: AppViewModel = viewModel()
                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                RinaBoardApp(vm)
            // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
            }
        // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
        }
    // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
    }
// 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
}
