// 中文注释：下一行声明当前 Kotlin 文件所属的软件包。
package com.rinaboard.controller.ui

// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import android.os.Bundle
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.activity.ComponentActivity
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.activity.compose.setContent
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.activity.enableEdgeToEdge
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.foundation.Canvas
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.foundation.background
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.foundation.gestures.detectDragGestures
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.foundation.gestures.detectTapGestures
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.foundation.layout.Arrangement
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.foundation.layout.Box
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.foundation.layout.Column
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.foundation.layout.Row
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.foundation.layout.Spacer
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.foundation.layout.WindowInsets
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.foundation.layout.fillMaxHeight
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.foundation.layout.fillMaxSize
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.foundation.layout.fillMaxWidth
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.foundation.layout.height
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.foundation.layout.padding
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.foundation.layout.safeDrawing
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.foundation.layout.size
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.foundation.layout.width
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.foundation.layout.windowInsetsPadding
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.foundation.shape.RoundedCornerShape
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.material.icons.Icons
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.material.icons.rounded.ArrowBack
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.material.icons.rounded.Clear
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.material.icons.rounded.DeleteSweep
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.material.icons.rounded.Draw
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.material.icons.rounded.Send
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.material3.Button
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.material3.ButtonDefaults
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.material3.Card
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.material3.CardDefaults
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.material3.FilledTonalButton
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.material3.Icon
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.material3.IconButton
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.material3.MaterialTheme
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.material3.OutlinedButton
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.material3.Surface
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.material3.Text
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.runtime.Composable
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.runtime.getValue
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.runtime.mutableStateOf
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.runtime.remember
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.runtime.rememberCoroutineScope
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.runtime.setValue
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.runtime.snapshots.SnapshotStateList
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.runtime.toMutableStateList
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.ui.Alignment
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.ui.Modifier
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.ui.geometry.CornerRadius
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.ui.geometry.Offset
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.ui.geometry.Size
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.ui.graphics.Color
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.ui.graphics.drawscope.Stroke
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.ui.input.pointer.pointerInput
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.ui.platform.LocalConfiguration
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.ui.platform.LocalContext
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.ui.text.font.FontWeight
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.ui.unit.dp
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import com.rinaboard.controller.data.BoardClient
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import com.rinaboard.controller.data.BoardProtocol
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import com.rinaboard.controller.led.LedMap
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import com.rinaboard.controller.ui.theme.RinaBackground
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import com.rinaboard.controller.ui.theme.RinaCyan
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import com.rinaboard.controller.ui.theme.RinaDivider
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import com.rinaboard.controller.ui.theme.RinaPink
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import com.rinaboard.controller.ui.theme.RinaPinkSoft
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import com.rinaboard.controller.ui.theme.RinaTextSecondary
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import com.rinaboard.controller.ui.theme.RinaTheme
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import kotlinx.coroutines.launch
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import kotlin.math.hypot
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import kotlin.math.min

// 中文注释：下一行定义当前模块使用的类型或单例对象。
class DrawActivity : ComponentActivity() {
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
                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                DrawScreen(onClose = { finish() })
                // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
            }
            // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
        }
        // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
    }
// 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
}

// 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
private enum class DrawMode { DRAW, ERASE }

// 中文注释：下一行标记一个 Jetpack Compose 可组合界面函数。
@Composable
// 中文注释：下一行定义函数，负责完成对应的业务或界面逻辑。
private fun DrawScreen(onClose: () -> Unit) {
    // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
    val context = LocalContext.current
    // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
    val scope = rememberCoroutineScope()
    // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
    val client = remember { BoardClient(context) }
    // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
    val ledColors: SnapshotStateList<Color> = remember {
        // 中文注释：下一行构造或发送与 ESP32-S3 通信的控制协议。
        List(BoardProtocol.LED_COUNT) { Color.Black }.toMutableStateList()
        // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
    }
    // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
    var mode by remember { mutableStateOf(DrawMode.DRAW) }
    // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
    var status by remember { mutableStateOf("拖动或点击绘制；发送后灯板使用固定颜色显示") }
    // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
    var sending by remember { mutableStateOf(false) }
    // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
    val brushColor = Color(180, 0, 100)
    // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
    val litCount = ledColors.count { it != Color.Black }
    // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
    val screenWidthDp = LocalConfiguration.current.screenWidthDp
    // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
    val toolPanelWidth = when {
        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
        screenWidthDp < 700 -> 190.dp
        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
        screenWidthDp < 850 -> 210.dp
        // 中文注释：下一行进入上一条件不成立时的处理分支。
        else -> 230.dp
        // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
    }

    // 中文注释：下一行创建或配置一个 Compose 界面组件。
    Surface(
        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
        modifier = Modifier
            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
            .fillMaxSize()
            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
            .windowInsetsPadding(WindowInsets.safeDrawing),
        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
        color = RinaBackground
        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
    ) {
        // 中文注释：下一行创建或配置一个 Compose 界面组件。
        Row(
            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
            modifier = Modifier
                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                .fillMaxSize()
                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                .padding(4.dp),
            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
            horizontalArrangement = Arrangement.spacedBy(4.dp)
            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
        ) {
            // 中文注释：下一行创建或配置一个 Compose 界面组件。
            Card(
                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                modifier = Modifier
                    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                    .weight(1f)
                    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                    .fillMaxHeight(),
                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                shape = RoundedCornerShape(18.dp),
                // 中文注释：下一行处理灯珠颜色、画笔 RGB 或界面颜色。
                colors = CardDefaults.cardColors(containerColor = Color.White),
                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
            ) {
                // 中文注释：下一行创建或配置一个 Compose 界面组件。
                Box(
                    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                    modifier = Modifier
                        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                        .fillMaxSize()
                        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                        .padding(3.dp)
                    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                ) {
                    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                    LedDrawingCanvas(
                        // 中文注释：下一行处理灯珠颜色、画笔 RGB 或界面颜色。
                        ledColors = ledColors,
                        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                        mode = mode,
                        // 中文注释：下一行处理灯珠颜色、画笔 RGB 或界面颜色。
                        brushColor = brushColor,
                        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                        onLed = { id, color ->
                            // 中文注释：下一行根据条件决定是否执行对应分支。
                            if (id in ledColors.indices) {
                                // 中文注释：下一行处理灯珠颜色、画笔 RGB 或界面颜色。
                                ledColors[id] = color
                                // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                            }
                            // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                        }
                        // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                    )
                    // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                }
                // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
            }

            // 中文注释：下一行创建或配置一个 Compose 界面组件。
            Column(
                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                modifier = Modifier
                    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                    .width(toolPanelWidth)
                    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                    .fillMaxHeight(),
                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                verticalArrangement = Arrangement.spacedBy(5.dp)
                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
            ) {
                // 中文注释：下一行创建或配置一个 Compose 界面组件。
                Row(
                    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                    modifier = Modifier.fillMaxWidth(),
                    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                    verticalAlignment = Alignment.CenterVertically
                    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                ) {
                    // 中文注释：下一行创建或配置一个 Compose 界面组件。
                    IconButton(
                        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                        onClick = onClose,
                        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                        modifier = Modifier.size(40.dp)
                        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                    ) {
                        // 中文注释：下一行创建或配置一个 Compose 界面组件。
                        Icon(Icons.Rounded.ArrowBack, contentDescription = "返回")
                        // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                    }
                    // 中文注释：下一行创建或配置一个 Compose 界面组件。
                    Column(modifier = Modifier.weight(1f)) {
                        // 中文注释：下一行创建或配置一个 Compose 界面组件。
                        Text(
                            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                            text = "临时绘画",
                            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                            fontWeight = FontWeight.ExtraBold,
                            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                            style = MaterialTheme.typography.titleMedium
                            // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                        )
                        // 中文注释：下一行创建或配置一个 Compose 界面组件。
                        Text(
                            // 中文注释：下一行构造或发送与 ESP32-S3 通信的控制协议。
                            text = "已点亮 $litCount / ${BoardProtocol.LED_COUNT}",
                            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                            color = RinaTextSecondary,
                            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                            style = MaterialTheme.typography.labelSmall
                            // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                        )
                        // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                    }
                    // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                }

                // 中文注释：下一行创建或配置一个 Compose 界面组件。
                Card(
                    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                    shape = RoundedCornerShape(16.dp),
                    // 中文注释：下一行处理灯珠颜色、画笔 RGB 或界面颜色。
                    colors = CardDefaults.cardColors(containerColor = Color.White)
                    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                ) {
                    // 中文注释：下一行创建或配置一个 Compose 界面组件。
                    Column(
                        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                        modifier = Modifier.padding(8.dp),
                        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                        verticalArrangement = Arrangement.spacedBy(6.dp)
                        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                    ) {
                        // 中文注释：下一行创建或配置一个 Compose 界面组件。
                        Row(
                            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                            modifier = Modifier.fillMaxWidth(),
                            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                            horizontalArrangement = Arrangement.spacedBy(6.dp)
                            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                        ) {
                            // 中文注释：下一行创建或配置一个 Compose 界面组件。
                            FilledTonalButton(
                                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                                onClick = { mode = DrawMode.DRAW },
                                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                                modifier = Modifier
                                    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                                    .weight(1f)
                                    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                                    .height(40.dp),
                                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                                contentPadding = ButtonDefaults.ContentPadding,
                                // 中文注释：下一行处理灯珠颜色、画笔 RGB 或界面颜色。
                                colors = ButtonDefaults.filledTonalButtonColors(
                                    // 中文注释：下一行处理灯珠颜色、画笔 RGB 或界面颜色。
                                    containerColor = if (mode == DrawMode.DRAW) RinaPinkSoft else Color(0xFFF1F2F3)
                                    // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                                )
                                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                            ) {
                                // 中文注释：下一行创建或配置一个 Compose 界面组件。
                                Icon(
                                    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                                    Icons.Rounded.Draw,
                                    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                                    contentDescription = "画笔",
                                    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                                    tint = RinaPink,
                                    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                                    modifier = Modifier.size(18.dp)
                                    // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                                )
                                // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                            }
                            // 中文注释：下一行创建或配置一个 Compose 界面组件。
                            FilledTonalButton(
                                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                                onClick = { mode = DrawMode.ERASE },
                                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                                modifier = Modifier
                                    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                                    .weight(1f)
                                    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                                    .height(40.dp),
                                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                                contentPadding = ButtonDefaults.ContentPadding,
                                // 中文注释：下一行处理灯珠颜色、画笔 RGB 或界面颜色。
                                colors = ButtonDefaults.filledTonalButtonColors(
                                    // 中文注释：下一行处理灯珠颜色、画笔 RGB 或界面颜色。
                                    containerColor = if (mode == DrawMode.ERASE) Color(0xFFEAF8FE) else Color(0xFFF1F2F3)
                                    // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                                )
                                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                            ) {
                                // 中文注释：下一行创建或配置一个 Compose 界面组件。
                                Icon(
                                    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                                    Icons.Rounded.Clear,
                                    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                                    contentDescription = "橡皮擦",
                                    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                                    tint = RinaCyan,
                                    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                                    modifier = Modifier.size(18.dp)
                                    // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                                )
                                // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                            }
                            // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                        }
                        // 中文注释：下一行创建或配置一个 Compose 界面组件。
                        OutlinedButton(
                            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                            onClick = {
                                // 中文注释：下一行循环处理一组数据。
                                for (index in ledColors.indices) {
                                    // 中文注释：下一行处理灯珠颜色、画笔 RGB 或界面颜色。
                                    ledColors[index] = Color.Black
                                    // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                                }
                                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                                status = "已清空画板"
                                // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                            },
                            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                            modifier = Modifier
                                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                                .fillMaxWidth()
                                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                                .height(38.dp)
                            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                        ) {
                            // 中文注释：下一行创建或配置一个 Compose 界面组件。
                            Icon(
                                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                                Icons.Rounded.DeleteSweep,
                                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                                contentDescription = null,
                                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                                modifier = Modifier.size(17.dp)
                                // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                            )
                            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                            Spacer(Modifier.width(4.dp))
                            // 中文注释：下一行创建或配置一个 Compose 界面组件。
                            Text("清空", style = MaterialTheme.typography.labelMedium)
                            // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                        }
                        // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                    }
                    // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                }

                // 中文注释：下一行创建或配置一个 Compose 界面组件。
                Button(
                    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                    onClick = {
                        // 中文注释：下一行根据条件决定是否执行对应分支。
                        if (litCount == 0) {
                            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                            status = "不能交白卷哦~"
                            // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                        } else {
                            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                            sending = true
                            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                            status = "正在发送临时绘画…"
                            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                            scope.launch {
                                // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
                                val ids = ledColors.indices.filter { ledColors[it] != Color.Black }
                                // 临时绘画只发送点亮灯珠编号，不再发送任何 RGB 颜色数据。
                                client.command(BoardProtocol.draw(ids))
                                    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                                    .onSuccess {
                                        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                                        status = "画面发送成功 · $litCount 颗灯珠已按固定颜色显示"
                                        // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                                    }
                                    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                                    .onFailure {
                                        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                                        status = "发送失败：${it.message ?: "网络不可达"}"
                                        // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                                    }
                                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                                sending = false
                                // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                            }
                            // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                        }
                        // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                    },
                    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                    enabled = !sending,
                    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                    modifier = Modifier
                        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                        .fillMaxWidth()
                        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                        .height(46.dp)
                    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                ) {
                    // 中文注释：下一行创建或配置一个 Compose 界面组件。
                    Icon(
                        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                        Icons.Rounded.Send,
                        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                        contentDescription = null,
                        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                        modifier = Modifier.size(18.dp)
                        // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                    )
                    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                    Spacer(Modifier.width(4.dp))
                    // 中文注释：下一行创建或配置一个 Compose 界面组件。
                    Text(
                        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                        text = if (sending) "发送中" else "发送画面",
                        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                        style = MaterialTheme.typography.labelLarge
                        // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                    )
                    // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                }

                // 中文注释：下一行创建或配置一个 Compose 界面组件。
                Card(
                    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                    modifier = Modifier.fillMaxWidth(),
                    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                    shape = RoundedCornerShape(14.dp),
                    // 中文注释：下一行处理灯珠颜色、画笔 RGB 或界面颜色。
                    colors = CardDefaults.cardColors(containerColor = Color.White)
                    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                ) {
                    // 中文注释：下一行创建或配置一个 Compose 界面组件。
                    Text(
                        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                        text = status,
                        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 7.dp),
                        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                        color = RinaTextSecondary,
                        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                        style = MaterialTheme.typography.bodySmall,
                        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                        maxLines = 2
                        // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                    )
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

@Composable
private fun LedDrawingCanvas(
    // 中文注释：下一行处理灯珠颜色、画笔 RGB 或界面颜色。
    ledColors: List<Color>,
    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
    mode: DrawMode,
    // 中文注释：下一行处理灯珠颜色、画笔 RGB 或界面颜色。
    brushColor: Color,
    // 中文注释：下一行处理灯珠颜色、画笔 RGB 或界面颜色。
    onLed: (id: Int, color: Color) -> Unit
// 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
) {
    // 中文注释：下一行创建或配置一个 Compose 界面组件。
    Canvas(
        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
        modifier = Modifier
            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
            .fillMaxSize()
            // 中文注释：下一行处理灯珠颜色、画笔 RGB 或界面颜色。
            .pointerInput(mode, brushColor) {
                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                detectTapGestures { position ->
                    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                    nearestLed(position, size.width.toFloat(), size.height.toFloat())?.let { id ->
                        // 中文注释：下一行处理灯珠颜色、画笔 RGB 或界面颜色。
                        onLed(id, if (mode == DrawMode.ERASE) Color.Black else brushColor)
                        // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                    }
                    // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                }
                // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
            }
            // 中文注释：下一行处理灯珠颜色、画笔 RGB 或界面颜色。
            .pointerInput(mode, brushColor) {
                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                detectDragGestures { change, _ ->
                    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                    nearestLed(change.position, size.width.toFloat(), size.height.toFloat())?.let { id ->
                        // 中文注释：下一行处理灯珠颜色、画笔 RGB 或界面颜色。
                        onLed(id, if (mode == DrawMode.ERASE) Color.Black else brushColor)
                        // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                    }
                    // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                }
                // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
            }
        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
    ) {
        // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
        val cell = ledCellSize(size)
        // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
        val corner = cell * 0.18f
        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
        LedMap.points.forEach { led ->
            // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
            val point = project(led.x, led.y, size.width, size.height)
            // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
            val color = ledColors.getOrElse(led.id) { Color.Black }
            // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
            val isOn = color != Color.Black
            // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
            val topLeft = Offset(point.x - cell / 2f, point.y - cell / 2f)
            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
            drawRoundRect(
                // 中文注释：下一行处理灯珠颜色、画笔 RGB 或界面颜色。
                color = if (isOn) color else Color(0xFFF1F2F3),
                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                topLeft = topLeft,
                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                size = Size(cell, cell),
                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                cornerRadius = CornerRadius(corner, corner)
                // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
            )
            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
            drawRoundRect(
                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                color = if (isOn) color else RinaDivider,
                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                topLeft = topLeft,
                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                size = Size(cell, cell),
                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                cornerRadius = CornerRadius(corner, corner),
                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                style = Stroke(width = if (isOn) 2.0f else 1.2f)
                // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
            )
            // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
        }
        // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
    }
// 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
}

// 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
private const val LED_CELL_RAW_SIZE = 6.70f

// 中文注释：下一行定义函数，负责完成对应的业务或界面逻辑。
private fun drawingScale(width: Float, height: Float): Float {
    // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
    val mapWidth = LedMap.maxX - LedMap.minX
    // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
    val mapHeight = LedMap.maxY - LedMap.minY
    // 中文注释：下一行结束当前函数并返回计算结果。
    return min(
        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
        width / (mapWidth + LED_CELL_RAW_SIZE),
        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
        height / (mapHeight + LED_CELL_RAW_SIZE)
        // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
    )
// 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
}

// 中文注释：下一行定义函数，负责完成对应的业务或界面逻辑。
private fun project(x: Float, y: Float, width: Float, height: Float): Offset {
    // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
    val mapWidth = LedMap.maxX - LedMap.minX
    // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
    val mapHeight = LedMap.maxY - LedMap.minY
    // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
    val scale = drawingScale(width, height)
    // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
    val drawWidth = mapWidth * scale
    // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
    val drawHeight = mapHeight * scale
    // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
    val left = (width - drawWidth) / 2f
    // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
    val top = (height - drawHeight) / 2f
    // 中文注释：下一行结束当前函数并返回计算结果。
    return Offset(
        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
        x = left + (x - LedMap.minX) * scale,
        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
        y = top + (LedMap.maxY - y) * scale
        // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
    )
// 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
}

// 中文注释：下一行定义函数，负责完成对应的业务或界面逻辑。
private fun ledCellSize(size: Size): Float {
    // 中文注释：下一行结束当前函数并返回计算结果。
    return LED_CELL_RAW_SIZE * drawingScale(size.width, size.height)
// 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
}

// 中文注释：下一行定义函数，负责完成对应的业务或界面逻辑。
private fun nearestLed(position: Offset, width: Float, height: Float): Int? {
    // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
    var bestId: Int? = null
    // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
    var bestDistance = Float.MAX_VALUE
    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
    LedMap.points.forEach { led ->
        // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
        val point = project(led.x, led.y, width, height)
        // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
        val distance = hypot(position.x - point.x, position.y - point.y)
        // 中文注释：下一行根据条件决定是否执行对应分支。
        if (distance < bestDistance) {
            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
            bestDistance = distance
            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
            bestId = led.id
            // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
        }
        // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
    }
    // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
    val hitRadius = (ledCellSize(Size(width, height)) * 0.58f).coerceAtLeast(18f)
    // 中文注释：下一行结束当前函数并返回计算结果。
    return if (bestDistance <= hitRadius) bestId else null
// 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
}
