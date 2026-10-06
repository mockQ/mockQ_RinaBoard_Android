// 中文注释：下一行声明当前 Kotlin 文件所属的软件包。
package com.rinaboard.controller.ui

// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import android.content.Intent
import android.net.Uri
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import android.provider.Settings
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.foundation.background
import androidx.compose.foundation.Canvas
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.drawscope.Stroke
import com.rinaboard.controller.data.FaceAssetRepository
import com.rinaboard.controller.data.FacePattern
import com.rinaboard.controller.led.LedMap
import kotlin.math.min
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.foundation.layout.Arrangement
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.foundation.layout.Box
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.foundation.layout.BoxWithConstraints
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.foundation.layout.Column
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.foundation.layout.PaddingValues
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.foundation.layout.Row
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.foundation.layout.Spacer
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.foundation.layout.fillMaxSize
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.foundation.layout.fillMaxHeight
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.foundation.layout.fillMaxWidth
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.foundation.layout.height
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.foundation.layout.offset
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.foundation.layout.padding
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.foundation.layout.size
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.foundation.layout.width
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.foundation.lazy.LazyColumn
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.foundation.lazy.itemsIndexed
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.foundation.lazy.grid.GridCells
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.foundation.lazy.grid.LazyGridState
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.foundation.lazy.grid.items
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.foundation.shape.CircleShape
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.foundation.shape.RoundedCornerShape
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.foundation.text.KeyboardOptions
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.material.icons.Icons
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.material.icons.rounded.BatteryChargingFull
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.material.icons.rounded.Brush
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.material.icons.rounded.ChevronLeft
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.material.icons.rounded.ChevronRight
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.material.icons.rounded.Delete
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.material.icons.rounded.Face
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.material.icons.rounded.Home
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.material.icons.rounded.Loop
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.material.icons.rounded.Memory
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.material.icons.rounded.PowerSettingsNew
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.material.icons.rounded.Refresh
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.material.icons.rounded.Settings
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.material.icons.rounded.StopCircle
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.material.icons.rounded.Bluetooth
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.material3.AlertDialog
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.material3.Button
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.material3.ButtonDefaults
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.material3.Card
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.material3.CardDefaults
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.material3.ExperimentalMaterial3Api
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.material3.FilledTonalButton
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.material3.HorizontalDivider
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.material3.Icon
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.material3.IconButton
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.material3.LinearProgressIndicator
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.material3.MaterialTheme
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.material3.NavigationBar
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.material3.NavigationBarItem
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.material3.OutlinedButton
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.material3.OutlinedTextField
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.material3.Scaffold
// 中文注释：亮度控制使用单值 Slider 和设置页 RangeSlider。
import androidx.compose.material3.Slider
import androidx.compose.material3.RangeSlider
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.material3.Surface
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.material3.Text
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.material3.TextButton
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.material3.TopAppBar
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.runtime.getValue
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.runtime.mutableIntStateOf
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.runtime.mutableStateListOf
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.runtime.mutableStateOf
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.runtime.remember
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.runtime.setValue
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.ui.Alignment
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.ui.Modifier
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.ui.graphics.Color
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.ui.graphics.vector.ImageVector
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.ui.platform.LocalConfiguration
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.ui.platform.LocalContext
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.ui.text.font.FontWeight
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.ui.text.input.KeyboardType
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.ui.text.style.TextOverflow
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.ui.unit.Dp
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.ui.unit.dp
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.compose.collectAsStateWithLifecycle
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import com.rinaboard.controller.data.BoardSettings
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import com.rinaboard.controller.model.BatteryState
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import com.rinaboard.controller.model.ConnectionState
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import com.rinaboard.controller.model.SequenceStep
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import com.rinaboard.controller.ui.theme.RinaCyan
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import com.rinaboard.controller.ui.theme.RinaPink
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import com.rinaboard.controller.ui.theme.RinaPinkSoft
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import com.rinaboard.controller.ui.theme.RinaSuccess
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import com.rinaboard.controller.ui.theme.RinaTextSecondary
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import com.rinaboard.controller.ui.theme.RinaWarning
import kotlin.math.roundToInt

// 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
private enum class MainTab(val title: String, val icon: ImageVector) {
    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
    HOME("主页", Icons.Rounded.Home),
    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
    FACE("表情", Icons.Rounded.Face),
    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
    DEVICE("设备", Icons.Rounded.Memory),
    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
    SETTINGS("设置", Icons.Rounded.Settings)
// 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
}

// 中文注释：下一行使用 Kotlin/Android 注解配置对应声明。
@OptIn(ExperimentalMaterial3Api::class)
// 中文注释：下一行标记一个 Jetpack Compose 可组合界面函数。
@Composable
// 中文注释：下一行定义函数，负责完成对应的业务或界面逻辑。
fun RinaBoardApp(vm: AppViewModel) {
    // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
    var tab by remember { mutableStateOf(MainTab.HOME) }
    // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
    val message by vm.message.collectAsStateWithLifecycle()
    // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
    val busy by vm.busy.collectAsStateWithLifecycle()

    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
    Scaffold(
        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
        topBar = {
            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
            TopAppBar(
                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                title = {
                    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                    Column {
                        // 中文注释：下一行创建或配置一个 Compose 界面组件。
                        Text("Rina Board", fontWeight = FontWeight.Bold)
                        // 中文注释：下一行创建或配置一个 Compose 界面组件。
                        Text(
                            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                            text = message,
                            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                            style = MaterialTheme.typography.labelSmall,
                            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                            color = RinaTextSecondary,
                            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                            maxLines = 1,
                            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                            overflow = TextOverflow.Ellipsis
                            // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                        )
                        // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                    }
                    // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                },
                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                actions = {
                    // 中文注释：下一行根据条件决定是否执行对应分支。
                    if (busy) {
                        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                        LinearProgressIndicator(
                            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                            modifier = Modifier.width(52.dp).padding(end = 12.dp),
                            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                            color = RinaPink
                            // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                        )
                        // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                    }
                    // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                }
                // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
            )
            // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
        },
        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
        bottomBar = {
            // 中文注释：下一行处理灯珠颜色、画笔 RGB 或界面颜色。
            NavigationBar(containerColor = Color.White) {
                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                MainTab.entries.forEach { item ->
                    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                    NavigationBarItem(
                        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                        selected = tab == item,
                        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                        onClick = { tab = item },
                        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                        icon = { Icon(item.icon, null) },
                        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                        label = { Text(item.title) }
                        // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                    )
                    // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                }
                // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
            }
            // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
        }
        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
    ) { padding ->
        // 中文注释：下一行创建或配置一个 Compose 界面组件。
        Surface(Modifier.fillMaxSize().padding(padding), color = MaterialTheme.colorScheme.background) {
            // 中文注释：下一行根据不同状态选择相应处理分支。
            when (tab) {
                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                MainTab.HOME -> HomeScreen(vm)
                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                MainTab.FACE -> FaceScreen(vm)
                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                MainTab.DEVICE -> DeviceScreen(vm)
                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                MainTab.SETTINGS -> SettingsScreen(vm)
                // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
            }
            // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
        }
        // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
    }
// 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
}

// 中文注释：下一行标记一个 Jetpack Compose 可组合界面函数。
@Composable
// 中文注释：下一行定义函数，负责完成对应的业务或界面逻辑。
private fun HomeScreen(vm: AppViewModel) {
    // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
    val context = LocalContext.current
    // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
    val connection by vm.connection.collectAsStateWithLifecycle()
    // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
    val battery by vm.battery.collectAsStateWithLifecycle()

    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
    LazyColumn(
        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
        modifier = Modifier.fillMaxSize(),
        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
        contentPadding = PaddingValues(
            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
            horizontal = adaptiveHorizontalPadding(),
            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
            vertical = 12.dp
            // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
        ),
        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
        verticalArrangement = Arrangement.spacedBy(14.dp)
        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
    ) {
        // 中文注释：下一行处理璃奈板电池电量或充电状态数据。
        item { ConnectionHero(connection, battery, vm) }
        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
        item {
            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
            SectionCard(title = "快捷控制", subtitle = "常用表情操作") {
                // 中文注释：下一行创建或配置一个 Compose 界面组件。
                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                    QuickAction("上一个", Icons.Rounded.ChevronLeft, Modifier.weight(1f)) { vm.previousFace() }
                    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                    QuickAction("眨眼", Icons.Rounded.Face, Modifier.weight(1f)) { vm.stopAndBlink() }
                    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                    QuickAction("下一个", Icons.Rounded.ChevronRight, Modifier.weight(1f)) { vm.nextFace() }
                    // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                }
                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                Spacer(Modifier.height(10.dp))
                // 中文注释：下一行创建或配置一个 Compose 界面组件。
                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                    QuickAction("轮播", Icons.Rounded.Loop, Modifier.weight(1f)) { vm.startLoop() }
                    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                    QuickAction("停止", Icons.Rounded.StopCircle, Modifier.weight(1f)) { vm.stopAndBlink() }
                    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                    QuickAction("熄屏", Icons.Rounded.PowerSettingsNew, Modifier.weight(1f)) { vm.screenOff() }
                    // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                }
                // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
            }
            // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
        }
        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
        item {
            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
            SectionCard(title = "蓝牙连接", subtitle = "APP 自动扫描并连接璃奈板") {
                InfoLine("设备", BoardSettings.BLE_DEVICE_NAME)
                InfoLine("协议", "BLE GATT")
                Spacer(Modifier.height(10.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    OutlinedButton(
                        onClick = { context.startActivity(Intent(Settings.ACTION_BLUETOOTH_SETTINGS)) },
                        modifier = Modifier.weight(1f)
                    ) {
                        Icon(Icons.Rounded.Bluetooth, null)
                        Spacer(Modifier.width(6.dp))
                        Text("蓝牙设置")
                    }
                    Button(onClick = vm::testConnection, modifier = Modifier.weight(1f)) {
                        Icon(Icons.Rounded.Refresh, null)
                        Spacer(Modifier.width(6.dp))
                        Text("连接 / 重连")
                    }
                }
                Spacer(Modifier.height(8.dp))
                OutlinedButton(onClick = vm::disconnectBluetooth, modifier = Modifier.fillMaxWidth()) {
                    Text("断开蓝牙")
                }
            }
            // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
        }
        // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
    }
// 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
}

// 中文注释：下一行标记一个 Jetpack Compose 可组合界面函数。
@Composable
// 中文注释：下一行定义函数，负责完成对应的业务或界面逻辑。
private fun ConnectionHero(connection: ConnectionState, battery: BatteryState, vm: AppViewModel) {
    // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
    val online = connection == ConnectionState.ONLINE
    // 中文注释：下一行创建或配置一个 Compose 界面组件。
    Card(
        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
        shape = RoundedCornerShape(24.dp),
        // 中文注释：下一行处理灯珠颜色、画笔 RGB 或界面颜色。
        colors = CardDefaults.cardColors(containerColor = if (online) RinaPinkSoft else Color.White),
        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
    ) {
        // 中文注释：下一行创建或配置一个 Compose 界面组件。
        Column(Modifier.padding(adaptiveHeroPadding())) {
            // 中文注释：下一行创建或配置一个 Compose 界面组件。
            Row(verticalAlignment = Alignment.CenterVertically) {
                // 中文注释：下一行创建或配置一个 Compose 界面组件。
                Box(
                    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                    Modifier.size(12.dp).background(
                        // 中文注释：下一行根据不同状态选择相应处理分支。
                        when (connection) {
                            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                            ConnectionState.ONLINE -> RinaSuccess
                            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                            ConnectionState.CHECKING -> RinaWarning
                            // 中文注释：下一行处理灯珠颜色、画笔 RGB 或界面颜色。
                            ConnectionState.OFFLINE -> Color(0xFFE05A5A)
                            // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                        },
                        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                        CircleShape
                        // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                    )
                    // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                )
                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                Spacer(Modifier.width(8.dp))
                // 中文注释：下一行创建或配置一个 Compose 界面组件。
                Text(
                    // 中文注释：下一行根据不同状态选择相应处理分支。
                    when (connection) {
                        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                        ConnectionState.ONLINE -> "璃奈板在线"
                        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                        ConnectionState.CHECKING -> "正在检测设备"
                        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                        ConnectionState.OFFLINE -> "璃奈板离线"
                        // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                    },
                    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                    fontWeight = FontWeight.Bold,
                    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                    style = MaterialTheme.typography.titleLarge
                    // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                )
                // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
            }
            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
            Spacer(Modifier.height(18.dp))
            // 中文注释：下一行创建或配置一个 Compose 界面组件。
            Row(verticalAlignment = Alignment.CenterVertically) {
                // 中文注释：下一行创建或配置一个 Compose 界面组件。
                Icon(Icons.Rounded.BatteryChargingFull, null, tint = if (battery.charging) RinaCyan else RinaPink, modifier = Modifier.size(38.dp))
                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                Spacer(Modifier.width(12.dp))
                // 中文注释：下一行创建或配置一个 Compose 界面组件。
                Column(Modifier.weight(1f)) {
                    // 中文注释：下一行创建或配置一个 Compose 界面组件。
                    Text("${battery.percent}%", style = MaterialTheme.typography.headlineMedium, fontWeight = FontWeight.ExtraBold)
                    // 中文注释：下一行创建或配置一个 Compose 界面组件。
                    Text(
                        // 中文注释：下一行根据不同状态选择相应处理分支。
                        when {
                            // 中文注释：下一行处理璃奈板电池电量或充电状态数据。
                            battery.full -> "充电完成 · ${battery.millivolts} mV"
                            // 中文注释：下一行处理璃奈板电池电量或充电状态数据。
                            battery.charging -> "正在充电 · ${battery.millivolts} mV"
                            // 中文注释：下一行处理璃奈板电池电量或充电状态数据。
                            battery.millivolts > 0 -> "电池供电 · ${battery.millivolts} mV"
                            // 中文注释：下一行进入上一条件不成立时的处理分支。
                            else -> "等待电量数据"
                            // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                        },
                        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                        color = RinaTextSecondary
                        // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                    )
                    // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                }
                // 中文注释：下一行创建或配置一个 Compose 界面组件。
                IconButton(onClick = { vm.refreshBattery() }) { Icon(Icons.Rounded.Refresh, null) }
                // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
            }
            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
            Spacer(Modifier.height(10.dp))
            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
            LinearProgressIndicator(
                // 中文注释：下一行处理璃奈板电池电量或充电状态数据。
                progress = { battery.percent / 100f },
                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                modifier = Modifier.fillMaxWidth().height(8.dp),
                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                color = RinaPink,
                // 中文注释：下一行处理灯珠颜色、画笔 RGB 或界面颜色。
                trackColor = Color.White
                // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
            )
            // 中文注释：下一行根据条件决定是否执行对应分支。
            if (battery.source.isNotBlank()) {
                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                Spacer(Modifier.height(8.dp))
                // 中文注释：下一行创建或配置一个 Compose 界面组件。
                Text("数据来源：${battery.source}", style = MaterialTheme.typography.labelSmall, color = RinaTextSecondary)
                // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
            }
            // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
        }
        // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
    }
// 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
}

// 中文注释：下一行标记一个 Jetpack Compose 可组合界面函数。
@Composable
// 中文注释：下一行定义函数，负责完成对应的业务或界面逻辑。
private fun FaceScreen(vm: AppViewModel) {
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current
    val faceSettings = remember(context) { BoardSettings(context) }

    // 手机本地 out 文件夹通过 SAF 选择一次后持久授权。
    // 以后直接用文件管理器/文本编辑器修改 fN.txt，不需要重新打包 APK。
    var selectedTreeUri by remember { mutableStateOf(faceSettings.faceFolderUri) }
    var reloadToken by remember { mutableIntStateOf(0) }

    val folderPicker = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.OpenDocumentTree()
    ) { uri: Uri? ->
        if (uri != null) {
            // 尽量保存读写权限；部分文档提供器可能只给读取权限，因此做降级处理。
            val resolver = context.contentResolver
            runCatching {
                resolver.takePersistableUriPermission(
                    uri,
                    Intent.FLAG_GRANT_READ_URI_PERMISSION or Intent.FLAG_GRANT_WRITE_URI_PERMISSION
                )
            }.recoverCatching {
                resolver.takePersistableUriPermission(uri, Intent.FLAG_GRANT_READ_URI_PERMISSION)
            }

            selectedTreeUri = uri.toString()
            faceSettings.faceFolderUri = selectedTreeUri
            reloadToken++
        }
    }

    // 从外部文件管理器改完 fN.txt 返回 APP 时自动重新读取。
    DisposableEffect(lifecycleOwner) {
        val observer = LifecycleEventObserver { _, event ->
            if (event == Lifecycle.Event.ON_RESUME) {
                reloadToken++
            }
        }
        lifecycleOwner.lifecycle.addObserver(observer)
        onDispose { lifecycleOwner.lifecycle.removeObserver(observer) }
    }

    val facePatterns = remember(context, selectedTreeUri, reloadToken) {
        FaceAssetRepository.load(context, selectedTreeUri)
    }
    val selectedFolderName = remember(context, selectedTreeUri, reloadToken) {
        FaceAssetRepository.selectedFolderName(context, selectedTreeUri)
    }

    var seqFace by remember { mutableStateOf("1") }
    var seqTime by remember { mutableStateOf("500") }
    val sequence = remember { mutableStateListOf<SequenceStep>() }

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(
            horizontal = adaptiveHorizontalPadding(),
            vertical = 12.dp
        ),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        item {
            SectionCard(
                title = "指定表情",
                subtitle = when {
                    selectedTreeUri == null -> "选择手机中的 out 文件夹；以后直接修改 fN.txt 即可自动更新"
                    facePatterns.isEmpty() -> "${selectedFolderName ?: "out"} 中没有读取到 f数字.txt"
                    else -> "${selectedFolderName ?: "out"} · 已读取 ${facePatterns.size} 个图案"
                }
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    OutlinedButton(
                        onClick = { folderPicker.launch(null) },
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(if (selectedTreeUri == null) "选择 out 文件夹" else "更换 out 文件夹")
                    }
                    IconButton(onClick = { reloadToken++ }) {
                        Icon(Icons.Rounded.Refresh, contentDescription = "重新读取表情文件")
                    }
                }

                Spacer(Modifier.height(10.dp))

                if (facePatterns.isNotEmpty()) {
                    FacePatternGrid(
                        patterns = facePatterns,
                        onFaceClick = vm::showFace
                    )
                } else {
                    Surface(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(90.dp),
                        color = Color(0xFFF7F8FA),
                        shape = RoundedCornerShape(14.dp)
                    ) {
                        Box(
                            modifier = Modifier.fillMaxSize().padding(12.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = if (selectedTreeUri == null) {
                                    "把 SD 卡的 out 文件夹复制到手机，然后点上方按钮选择它"
                                } else {
                                    "未找到 f1.txt、f2.txt……请检查所选目录"
                                },
                                color = RinaTextSecondary,
                                style = MaterialTheme.typography.bodyMedium
                            )
                        }
                    }
                }

                Spacer(Modifier.height(10.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    OutlinedButton(
                        onClick = vm::previousFace,
                        modifier = Modifier.weight(1f)
                    ) {
                        Text("上一个", maxLines = 1, softWrap = false)
                    }

                    OutlinedButton(
                        onClick = vm::nextFace,
                        modifier = Modifier.weight(1f)
                    ) {
                        Text("下一个", maxLines = 1, softWrap = false)
                    }
                }
            }
        }

        item {
            SectionCard("璃奈璃画室") {
                Button(
                    onClick = {
                        context.startActivity(Intent(context, DrawActivity::class.java))
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Icon(Icons.Rounded.Brush, null)
                    Spacer(Modifier.width(8.dp))
                    Text("进入画室")
                }
            }
        }

        item {
            SectionCard("表情序列") {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    OutlinedTextField(
                        value = seqFace,
                        onValueChange = {
                            seqFace = it.filter(Char::isDigit).take(3)
                        },
                        label = { Text("表情") },
                        modifier = Modifier.weight(1f),
                        singleLine = true,
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                    )

                    OutlinedTextField(
                        value = seqTime,
                        onValueChange = {
                            seqTime = it.filter(Char::isDigit).take(5)
                        },
                        label = { Text("毫秒") },
                        modifier = Modifier.weight(1f),
                        singleLine = true,
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                    )
                }

                Spacer(Modifier.height(8.dp))

                Button(
                    onClick = {
                        val f = seqFace.toIntOrNull()
                        val t = seqTime.toIntOrNull()
                        if (f != null && f > 0 && t != null) {
                            sequence += SequenceStep(f, t.coerceAtLeast(100))
                        }
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("添加序列排练")
                }

                if (sequence.isNotEmpty()) {
                    Spacer(Modifier.height(10.dp))
                    sequence.forEachIndexed { index, step ->
                        Row(
                            Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                "${index + 1}. f${step.face} · ${step.durationMs}ms",
                                modifier = Modifier.weight(1f)
                            )
                            IconButton(onClick = { sequence.removeAt(index) }) {
                                Icon(Icons.Rounded.Delete, null)
                            }
                        }
                        if (index < sequence.lastIndex) HorizontalDivider()
                    }

                    Spacer(Modifier.height(8.dp))
                    Button(
                        onClick = { vm.playSequence(sequence.toList()) },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("表演开始")
                    }
                }
            }
        }
    }
}

@Composable
private fun FacePatternGrid(
    patterns: List<FacePattern>,
    onFaceClick: (Int) -> Unit
) {
    // 一行 2 个。卡片变大以后可以清楚看到真实 LED 表情图案。
    val columns = 2
    val visibleRows = 3
    val itemHeight = 168.dp
    val spacing = 10.dp
    val gridHeight = itemHeight * visibleRows + spacing * (visibleRows - 1)
    val gridState = rememberLazyGridState()

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(gridHeight)
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(columns),
            state = gridState,
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(spacing),
            horizontalArrangement = Arrangement.spacedBy(spacing)
        ) {
            items(
                items = patterns,
                key = { it.faceNo }
            ) { pattern ->
                FacePatternCard(
                    pattern = pattern,
                    onClick = { onFaceClick(pattern.faceNo) },
                    modifier = Modifier.height(itemHeight)
                )
            }
        }
    }
}

@Composable
private fun FacePatternCard(
    pattern: FacePattern,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    // 每个卡片只显示实际 LED 图案，不再显示“表情 1 / 表情 2”或灯珠数量文字。
    Card(
        onClick = onClick,
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(containerColor = RinaPinkSoft),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
    ) {
        FacePatternPreview(
            litLedIds = pattern.ledIds,
            modifier = Modifier
                .fillMaxSize()
                .padding(7.dp)
        )
    }
}

@Composable
private fun FacePatternPreview(
    litLedIds: Set<Int>,
    modifier: Modifier = Modifier
) {
    Canvas(
        modifier = modifier
            .background(Color(0xFF17171C), RoundedCornerShape(10.dp))
            .padding(5.dp)
    ) {
        if (LedMap.points.isEmpty()) return@Canvas

        val rawCell = 6.70f
        val mapWidth = LedMap.maxX - LedMap.minX
        val mapHeight = LedMap.maxY - LedMap.minY
        val scale = min(
            size.width / (mapWidth + rawCell),
            size.height / (mapHeight + rawCell)
        )
        val drawWidth = mapWidth * scale
        val drawHeight = mapHeight * scale
        val left = (size.width - drawWidth) / 2f
        val top = (size.height - drawHeight) / 2f
        val cell = (rawCell * scale).coerceAtLeast(1.4f)
        val corner = cell * 0.18f

        LedMap.points.forEach { led ->
            val x = left + (led.x - LedMap.minX) * scale
            val y = top + (LedMap.maxY - led.y) * scale
            val lit = led.id in litLedIds
            val topLeft = Offset(x - cell / 2f, y - cell / 2f)

            drawRoundRect(
                color = if (lit) RinaPink else Color(0xFF292931),
                topLeft = topLeft,
                size = Size(cell, cell),
                cornerRadius = CornerRadius(corner, corner)
            )

            if (lit && cell >= 3f) {
                drawRoundRect(
                    color = Color(0xFFFFB5D1),
                    topLeft = topLeft,
                    size = Size(cell, cell),
                    cornerRadius = CornerRadius(corner, corner),
                    style = Stroke(width = 0.7f)
                )
            }
        }
    }
}

// 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
/*
 // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
 * 快捷表情网格：
 // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
 * - 固定 5 列
 // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
 * - 视口最多显示 3 行，共 15 个
 // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
 * - 超过 15 个以后，只滚动网格本身
 // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
 * - 右侧显示一个可见滚动条
 // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
 */
// 中文注释：下一行标记一个 Jetpack Compose 可组合界面函数。
@Composable
// 中文注释：下一行定义函数，负责完成对应的业务或界面逻辑。
private fun FaceQuickGrid(
    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
    faceNumbers: List<Int>,
    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
    onFaceClick: (Int) -> Unit
// 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
) {
    // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
    val columns = 5
    // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
    val visibleRows = 3
    // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
    val buttonHeight = 44.dp
    // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
    val spacing = 8.dp
    // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
    val gridHeight =
        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
        buttonHeight * visibleRows +
                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                spacing * (visibleRows - 1)

    // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
    val gridState = rememberLazyGridState()

    // 中文注释：下一行创建或配置一个 Compose 界面组件。
    Box(
        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
        modifier = Modifier
            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
            .fillMaxWidth()
            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
            .height(gridHeight)
        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
    ) {
        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
        LazyVerticalGrid(
            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
            columns = GridCells.Fixed(columns),
            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
            state = gridState,
            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
            modifier = Modifier
                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                .fillMaxSize()
                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                .padding(
                    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                    end = if (faceNumbers.size > 15) {
                        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                        10.dp
                        // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                    } else {
                        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                        0.dp
                        // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                    }
                    // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                ),
            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
            verticalArrangement =
                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                Arrangement.spacedBy(spacing),
            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
            horizontalArrangement =
                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                Arrangement.spacedBy(spacing),
            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
            userScrollEnabled = faceNumbers.size > 15
            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
        ) {
            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
            items(
                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                items = faceNumbers,
                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                key = { it }
                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
            ) { n ->
                // 中文注释：下一行创建或配置一个 Compose 界面组件。
                FilledTonalButton(
                    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                    onClick = {
                        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                        onFaceClick(n)
                        // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                    },
                    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                    modifier = Modifier
                        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                        .fillMaxWidth()
                        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                        .height(buttonHeight),
                    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                    shape = RoundedCornerShape(12.dp),
                    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                    contentPadding = PaddingValues(0.dp),
                    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                    colors =
                        // 中文注释：下一行处理灯珠颜色、画笔 RGB 或界面颜色。
                        ButtonDefaults.filledTonalButtonColors(
                            // 中文注释：下一行处理灯珠颜色、画笔 RGB 或界面颜色。
                            containerColor = RinaPinkSoft,
                            // 中文注释：下一行处理灯珠颜色、画笔 RGB 或界面颜色。
                            contentColor = RinaPink
                            // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                        )
                    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                ) {
                    // 中文注释：下一行创建或配置一个 Compose 界面组件。
                    Text(
                        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                        text = n.toString(),
                        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                        fontWeight = FontWeight.Bold,
                        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                        maxLines = 1,
                        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                        softWrap = false
                        // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                    )
                    // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                }
                // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
            }
            // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
        }

        // 中文注释：下一行根据条件决定是否执行对应分支。
        if (faceNumbers.size > 15) {
            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
            FaceGridScrollBar(
                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                gridState = gridState,
                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                totalItems = faceNumbers.size,
                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                columns = columns,
                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                visibleRows = visibleRows,
                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                modifier = Modifier
                    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                    .align(Alignment.CenterEnd)
                    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                    .width(4.dp)
                    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                    .fillMaxHeight()
                // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
            )
            // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
        }
        // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
    }
// 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
}

// 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
/*
 // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
 * Compose Android 没有直接给 LazyVerticalGrid 提供系统 Scrollbar，
 // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
 * 因此这里绘制一个轻量的可见滚动条。
 // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
 *
 // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
 * 它会跟随当前网格第一条可见数据移动。
 // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
 */
// 中文注释：下一行标记一个 Jetpack Compose 可组合界面函数。
@Composable
// 中文注释：下一行定义函数，负责完成对应的业务或界面逻辑。
private fun FaceGridScrollBar(
    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
    gridState: LazyGridState,
    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
    totalItems: Int,
    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
    columns: Int,
    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
    visibleRows: Int,
    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
    modifier: Modifier = Modifier
// 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
) {
    // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
    val totalRows =
        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
        ((totalItems + columns - 1) / columns)
            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
            .coerceAtLeast(1)

    // 中文注释：下一行根据条件决定是否执行对应分支。
    if (totalRows <= visibleRows) {
        // 中文注释：下一行结束当前函数并返回计算结果。
        return
        // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
    }

    // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
    val firstVisibleRow =
        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
        (gridState.firstVisibleItemIndex / columns)
            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
            .coerceAtLeast(0)

    // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
    val maxFirstRow =
        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
        (totalRows - visibleRows)
            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
            .coerceAtLeast(1)

    // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
    val scrollProgress =
        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
        (
                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                firstVisibleRow.toFloat() /
                        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                        maxFirstRow.toFloat()
                // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                )
            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
            .coerceIn(0f, 1f)

    // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
    val thumbFraction =
        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
        (
                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                visibleRows.toFloat() /
                        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                        totalRows.toFloat()
                // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                )
            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
            .coerceIn(0.12f, 1f)

    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
    BoxWithConstraints(
        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
        modifier = modifier
            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
            .background(
                // 中文注释：下一行处理灯珠颜色、画笔 RGB 或界面颜色。
                color = Color(0xFFE5E7EB),
                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                shape = RoundedCornerShape(99.dp)
                // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
            )
        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
    ) {
        // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
        val maxThumbOffset =
            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
            maxHeight * (1f - thumbFraction)

        // 中文注释：下一行创建或配置一个 Compose 界面组件。
        Box(
            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
            modifier = Modifier
                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                .fillMaxWidth()
                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                .fillMaxHeight(thumbFraction)
                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                .offset(
                    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                    y = maxThumbOffset *
                            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                            scrollProgress
                    // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                )
                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                .background(
                    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                    color = RinaPink,
                    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                    shape = RoundedCornerShape(99.dp)
                    // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                )
            // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
        )
        // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
    }
// 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
}

// 中文注释：下一行标记一个 Jetpack Compose 可组合界面函数。
@Composable
// 中文注释：下一行定义函数，负责完成对应的业务或界面逻辑。
private fun DeviceScreen(vm: AppViewModel) {
    // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
    val suPower by vm.suPowerOn.collectAsStateWithLifecycle()
    // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
    val update by vm.update.collectAsStateWithLifecycle()
    val brightness by vm.brightness.collectAsStateWithLifecycle()
    val brightnessMin by vm.brightnessMin.collectAsStateWithLifecycle()
    val brightnessMax by vm.brightnessMax.collectAsStateWithLifecycle()
    // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
    var confirmUpdate by remember { mutableStateOf(false) }

    // 中文注释：下一行根据条件决定是否执行对应分支。
    if (confirmUpdate) {
        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
        AlertDialog(
            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
            onDismissRequest = { confirmUpdate = false },
            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
            title = { Text("更新 SU-03T 固件？") },
            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
            text = { Text("ESP32-S3 将从 SD 卡读取 *_update.bin，控制 SU-03T 重新上电并执行升级。升级期间请勿断电。") },
            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
            confirmButton = {
                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                TextButton(onClick = {
                    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                    confirmUpdate = false
                    // 中文注释：下一行处理 SU-03T 上下电、状态查询或固件升级相关逻辑。
                    vm.startSu03tUpdate()
                    // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                }) { Text("开始升级", color = RinaPink) }
                // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
            },
            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
            dismissButton = { TextButton(onClick = { confirmUpdate = false }) { Text("取消") } }
            // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
        )
        // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
    }

    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
    LazyColumn(
        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
        modifier = Modifier.fillMaxSize(),
        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
        contentPadding = PaddingValues(
            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
            horizontal = adaptiveHorizontalPadding(),
            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
            vertical = 12.dp
            // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
        ),
        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
        verticalArrangement = Arrangement.spacedBy(14.dp)
        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
    ) {
        item {
            SectionCard("灯板亮度", "拖动拉条即可实时调整，范围由设置页决定") {
                Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                    Text("当前亮度", color = RinaTextSecondary, modifier = Modifier.weight(1f))
                    Text("$brightness%", fontWeight = FontWeight.Bold, color = RinaPink)
                }
                Spacer(Modifier.height(6.dp))
                Slider(
                    value = brightness.toFloat().coerceIn(brightnessMin.toFloat(), brightnessMax.toFloat()),
                    onValueChange = { vm.setBrightness(it.roundToInt()) },
                    onValueChangeFinished = vm::commitBrightness,
                    valueRange = brightnessMin.toFloat()..brightnessMax.toFloat(),
                    steps = (brightnessMax - brightnessMin - 1).coerceAtLeast(0),
                    modifier = Modifier.fillMaxWidth()
                )
                Row(Modifier.fillMaxWidth()) {
                    Text("最低 $brightnessMin%", style = MaterialTheme.typography.bodySmall, color = RinaTextSecondary)
                    Spacer(Modifier.weight(1f))
                    Text("最高 $brightnessMax%", style = MaterialTheme.typography.bodySmall, color = RinaTextSecondary)
                }
            }
        }
        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
        item {
            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
            SectionCard("SU-03T 电源", "GPIO42 控制语音模块上下电") {
                // 中文注释：下一行创建或配置一个 Compose 界面组件。
                Row(verticalAlignment = Alignment.CenterVertically) {
                    // 中文注释：下一行创建或配置一个 Compose 界面组件。
                    Box(Modifier.size(10.dp).background(if (suPower) RinaSuccess else RinaTextSecondary, CircleShape))
                    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                    Spacer(Modifier.width(8.dp))
                    // 中文注释：下一行创建或配置一个 Compose 界面组件。
                    Text(if (suPower) "语音模块已上电" else "语音模块已断电", modifier = Modifier.weight(1f), fontWeight = FontWeight.Bold)
                    // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                }
                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                Spacer(Modifier.height(12.dp))
                // 中文注释：下一行创建或配置一个 Compose 界面组件。
                Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                    // 中文注释：下一行创建或配置一个 Compose 界面组件。
                    Button(onClick = { vm.setSu03tPower(true) }, modifier = Modifier.weight(1f)) { Text("上电") }
                    // 中文注释：下一行创建或配置一个 Compose 界面组件。
                    OutlinedButton(onClick = { vm.setSu03tPower(false) }, modifier = Modifier.weight(1f)) { Text("断电") }
                    // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                }
                // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
            }
            // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
        }
        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
        item {
            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
            SectionCard("SU-03T 固件更新", "SD 卡 → ESP32-S3 → UART XMODEM-1K") {
                // 中文注释：下一行创建或配置一个 Compose 界面组件。
                Row(verticalAlignment = Alignment.CenterVertically) {
                    // 中文注释：下一行创建或配置一个 Compose 界面组件。
                    Column(Modifier.weight(1f)) {
                        // 中文注释：下一行创建或配置一个 Compose 界面组件。
                        Text(
                            // 中文注释：下一行根据不同状态选择相应处理分支。
                            when (update.state) {
                                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                                "running" -> "正在更新 ${update.progress}%"
                                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                                "success" -> "上次更新成功"
                                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                                "failed" -> "上次更新失败"
                                // 中文注释：下一行进入上一条件不成立时的处理分支。
                                else -> "等待更新"
                                // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                            },
                            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                            fontWeight = FontWeight.Bold
                            // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                        )
                        // 中文注释：下一行创建或配置一个 Compose 界面组件。
                        Text("固件路径：/sdcard/su03t/*_update.bin", color = RinaTextSecondary, style = MaterialTheme.typography.bodySmall)
                        // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                    }
                    // 中文注释：下一行创建或配置一个 Compose 界面组件。
                    IconButton(onClick = vm::refreshUpdateStatus) { Icon(Icons.Rounded.Refresh, null) }
                    // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                }
                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                Spacer(Modifier.height(10.dp))
                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                LinearProgressIndicator(
                    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                    progress = { update.progress / 100f },
                    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                    modifier = Modifier.fillMaxWidth().height(8.dp),
                    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                    color = RinaCyan
                    // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                )
                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                Spacer(Modifier.height(12.dp))
                // 中文注释：下一行创建或配置一个 Compose 界面组件。
                Button(
                    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                    onClick = { confirmUpdate = true },
                    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                    enabled = !update.running,
                    // 中文注释：下一行处理灯珠颜色、画笔 RGB 或界面颜色。
                    colors = ButtonDefaults.buttonColors(containerColor = RinaCyan),
                    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                    modifier = Modifier.fillMaxWidth()
                    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                ) { Text("从 SD 卡更新 SU-03T") }
                // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
            }
            // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
        }
// 中文注释：下面原有注释用于说明相邻代码的设计目的。
//        item {
// 中文注释：下面原有注释用于说明相邻代码的设计目的。
//            SectionCard("当前协议", "与 ESP32-S3 固件保持一致") {
// 中文注释：下面原有注释用于说明相邻代码的设计目的。
//                ProtocolLine("BT", "读取电池 JSON")
// 中文注释：下面原有注释用于说明相邻代码的设计目的。
//                ProtocolLine("VP0 / VP1", "SU-03T 断电 / 上电")
// 中文注释：下面原有注释用于说明相邻代码的设计目的。
//                ProtocolLine("SU / US", "开始升级 / 查询升级状态")
// 中文注释：下面原有注释用于说明相邻代码的设计目的。
//                ProtocolLine("FC / FU / FD", "指定 / 上一个 / 下一个表情")
// 中文注释：下面原有注释用于说明相邻代码的设计目的。
//                ProtocolLine("DR", "临时绘画：发送点亮灯珠编号")
// 中文注释：下面原有注释用于说明相邻代码的设计目的。
//                ProtocolLine("SQ", "发送表情播放序列")
// 中文注释：下面原有注释用于说明相邻代码的设计目的。
//            }
// 中文注释：下面原有注释用于说明相邻代码的设计目的。
//        }
        // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
    }
// 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
}

// 中文注释：下一行标记一个 Jetpack Compose 可组合界面函数。
@Composable
// 中文注释：下一行定义函数，负责完成对应的业务或界面逻辑。
private fun SettingsScreen(vm: AppViewModel) {
    val brightnessMin by vm.brightnessMin.collectAsStateWithLifecycle()
    val brightnessMax by vm.brightnessMax.collectAsStateWithLifecycle()
    var brightnessRange by remember(brightnessMin, brightnessMax) {
        mutableStateOf(brightnessMin.toFloat()..brightnessMax.toFloat())
    }

    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
    LazyColumn(
        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
        modifier = Modifier.fillMaxSize(),
        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
        contentPadding = PaddingValues(
            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
            horizontal = adaptiveHorizontalPadding(),
            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
            vertical = 12.dp
            // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
        ),
        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
        verticalArrangement = Arrangement.spacedBy(14.dp)
        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
    ) {
        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
        item {
            SectionCard("亮度拉条范围", "设置设备页亮度拉条允许的最低和最高亮度") {
                Row(Modifier.fillMaxWidth()) {
                    Text("最低 ${brightnessRange.start.roundToInt()}%", modifier = Modifier.weight(1f), color = RinaTextSecondary)
                    Text("最高 ${brightnessRange.endInclusive.roundToInt()}%", color = RinaTextSecondary)
                }
                Spacer(Modifier.height(8.dp))
                RangeSlider(
                    value = brightnessRange,
                    onValueChange = { range ->
                        val low = range.start.roundToInt().coerceIn(0, 199)
                        val high = range.endInclusive.roundToInt().coerceIn(low + 1, 200)
                        brightnessRange = low.toFloat()..high.toFloat()
                    },
                    onValueChangeFinished = {
                        vm.setBrightnessLimits(
                            brightnessRange.start.roundToInt(),
                            brightnessRange.endInclusive.roundToInt()
                        )
                    },
                    valueRange = 0f..200f,
                    steps = 199,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(Modifier.height(8.dp))
                Text(
                    "设备页只能在这个范围内调节；100% 对应 RGB(180,0,100)，100~200% 会在保持相同比例的前提下使用剩余亮度余量。",
                    style = MaterialTheme.typography.bodySmall,
                    color = RinaTextSecondary
                )
                Spacer(Modifier.height(10.dp))
                OutlinedButton(
                    onClick = {
                        vm.resetBrightnessLimits()
                        brightnessRange = BoardSettings.DEFAULT_BRIGHTNESS_MIN.toFloat()..BoardSettings.DEFAULT_BRIGHTNESS_MAX.toFloat()
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("恢复默认范围 ${BoardSettings.DEFAULT_BRIGHTNESS_MIN}% ~ ${BoardSettings.DEFAULT_BRIGHTNESS_MAX}%")
                }
            }
        }
// 中文注释：下面原有注释用于说明相邻代码的设计目的。
//        item {
// 中文注释：下面原有注释用于说明相邻代码的设计目的。
//            SectionCard("界面说明", "粉色主色 + 青色强调，圆角卡片和轻量信息层级") {
// 中文注释：下面原有注释用于说明相邻代码的设计目的。
// 中文注释：下面原有注释用于说明相邻代码的设计目的。
//            }
// 中文注释：下面原有注释用于说明相邻代码的设计目的。
//        }
        // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
    }
// 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
}

// 中文注释：下一行标记一个 Jetpack Compose 可组合界面函数。
@Composable
// 中文注释：下一行定义函数，负责完成对应的业务或界面逻辑。
private fun adaptiveHorizontalPadding(): Dp {
    // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
    val screenWidthDp = LocalConfiguration.current.screenWidthDp
    // 中文注释：下一行结束当前函数并返回计算结果。
    return when {
        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
        screenWidthDp <= 360 -> 12.dp
        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
        screenWidthDp <= 420 -> 16.dp
        // 中文注释：下一行进入上一条件不成立时的处理分支。
        else -> 20.dp
        // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
    }
// 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
}

// 中文注释：下一行标记一个 Jetpack Compose 可组合界面函数。
@Composable
// 中文注释：下一行定义函数，负责完成对应的业务或界面逻辑。
private fun adaptiveCardPadding(): Dp {
    // 中文注释：下一行结束当前函数并返回计算结果。
    return if (LocalConfiguration.current.screenWidthDp <= 360) 13.dp else 16.dp
// 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
}

// 中文注释：下一行标记一个 Jetpack Compose 可组合界面函数。
@Composable
// 中文注释：下一行定义函数，负责完成对应的业务或界面逻辑。
private fun adaptiveHeroPadding(): Dp {
    // 中文注释：下一行结束当前函数并返回计算结果。
    return if (LocalConfiguration.current.screenWidthDp <= 360) 16.dp else 20.dp
// 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
}

// 中文注释：下一行标记一个 Jetpack Compose 可组合界面函数。
@Composable
// 中文注释：下一行定义函数，负责完成对应的业务或界面逻辑。
private fun SectionCard(title: String, subtitle: String? = null, content: @Composable () -> Unit) {
    // 中文注释：下一行创建或配置一个 Compose 界面组件。
    Card(
        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
        modifier = Modifier.fillMaxWidth(),
        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
        shape = RoundedCornerShape(20.dp),
        // 中文注释：下一行处理灯珠颜色、画笔 RGB 或界面颜色。
        colors = CardDefaults.cardColors(containerColor = Color.White),
        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
    ) {
        // 中文注释：下一行创建或配置一个 Compose 界面组件。
        Column(Modifier.padding(adaptiveCardPadding())) {
            // 中文注释：下一行创建或配置一个 Compose 界面组件。
            Text(title, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
            // 中文注释：下一行根据条件决定是否执行对应分支。
            if (!subtitle.isNullOrBlank()) {
                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                Spacer(Modifier.height(2.dp))
                // 中文注释：下一行创建或配置一个 Compose 界面组件。
                Text(subtitle, style = MaterialTheme.typography.bodySmall, color = RinaTextSecondary)
                // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
            }
            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
            Spacer(Modifier.height(14.dp))
            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
            content()
            // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
        }
        // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
    }
// 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
}

// 中文注释：下一行标记一个 Jetpack Compose 可组合界面函数。
@Composable
// 中文注释：下一行定义函数，负责完成对应的业务或界面逻辑。
private fun QuickAction(
    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
    label: String,
    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
    icon: ImageVector,
    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
    modifier: Modifier = Modifier,
    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
    onClick: () -> Unit
// 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
) {
    // 中文注释：下一行创建或配置一个 Compose 界面组件。
    FilledTonalButton(
        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
        onClick = onClick,
        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
        modifier = modifier.height(56.dp),
        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
        shape = RoundedCornerShape(16.dp),
        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
        contentPadding = PaddingValues(horizontal = 5.dp, vertical = 0.dp),
        // 中文注释：下一行处理灯珠颜色、画笔 RGB 或界面颜色。
        colors = ButtonDefaults.filledTonalButtonColors(containerColor = RinaPinkSoft)
        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
    ) {
        // 中文注释：下一行创建或配置一个 Compose 界面组件。
        Icon(
            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
            imageVector = icon,
            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
            contentDescription = null,
            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
            tint = RinaPink,
            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
            modifier = Modifier.size(19.dp)
            // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
        )
        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
        Spacer(Modifier.width(4.dp))
        // 中文注释：下一行创建或配置一个 Compose 界面组件。
        Text(
            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
            text = label,
            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
            maxLines = 1,
            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
            softWrap = false,
            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
            overflow = TextOverflow.Clip,
            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
            style = MaterialTheme.typography.labelLarge
            // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
        )
        // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
    }
// 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
}

// 中文注释：下一行标记一个 Jetpack Compose 可组合界面函数。
@Composable
// 中文注释：下一行定义函数，负责完成对应的业务或界面逻辑。
private fun InfoLine(name: String, value: String) {
    // 中文注释：下一行创建或配置一个 Compose 界面组件。
    Row(Modifier.fillMaxWidth().padding(vertical = 3.dp)) {
        // 中文注释：下一行创建或配置一个 Compose 界面组件。
        Text(name, color = RinaTextSecondary, modifier = Modifier.width(92.dp))
        // 中文注释：下一行创建或配置一个 Compose 界面组件。
        Text(value, fontWeight = FontWeight.SemiBold)
        // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
    }
// 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
}

// 中文注释：下一行标记一个 Jetpack Compose 可组合界面函数。
@Composable
// 中文注释：下一行定义函数，负责完成对应的业务或界面逻辑。
private fun ProtocolLine(command: String, meaning: String) {
    // 中文注释：下一行创建或配置一个 Compose 界面组件。
    Row(Modifier.fillMaxWidth().padding(vertical = 5.dp), verticalAlignment = Alignment.CenterVertically) {
        // 中文注释：下一行创建或配置一个 Compose 界面组件。
        Surface(color = RinaPinkSoft, shape = RoundedCornerShape(8.dp)) {
            // 中文注释：下一行创建或配置一个 Compose 界面组件。
            Text(command, color = RinaPink, fontWeight = FontWeight.Bold, modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp))
            // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
        }
        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
        Spacer(Modifier.width(10.dp))
        // 中文注释：下一行创建或配置一个 Compose 界面组件。
        Text(meaning, color = RinaTextSecondary)
        // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
    }
// 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
}
