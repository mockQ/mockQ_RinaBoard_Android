// 中文注释：下一行声明当前 Kotlin 文件所属的软件包。
package com.rinaboard.controller.ui

// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import android.content.Intent
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import android.provider.Settings
// 中文注释：下一行导入后续代码需要使用的类、函数或扩展。
import androidx.compose.foundation.background
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
import androidx.compose.material.icons.rounded.Wifi
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
            SectionCard(title = "Wi-Fi 连接", subtitle = "连接璃奈板后即可控制") {
                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                InfoLine("SSID", BoardSettings.AP_SSID)
// 中文注释：下面原有注释用于说明相邻代码的设计目的。
//                InfoLine("设备 IP", vm.host.collectAsStateWithLifecycle().value)
                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                Spacer(Modifier.height(10.dp))
                // 中文注释：下一行创建或配置一个 Compose 界面组件。
                Row(
                    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                    modifier = Modifier.fillMaxWidth(),
                    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                ) {
                    // 中文注释：下一行创建或配置一个 Compose 界面组件。
                    OutlinedButton(
                        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                        onClick = {
                            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                            context.startActivity(Intent(Settings.ACTION_WIFI_SETTINGS))
                        // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                        },
                        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                        modifier = Modifier.weight(1f)
                    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                    ) {
                        // 中文注释：下一行创建或配置一个 Compose 界面组件。
                        Icon(Icons.Rounded.Wifi, null)
                        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                        Spacer(Modifier.width(6.dp))
                        // 中文注释：下一行创建或配置一个 Compose 界面组件。
                        Text("打开 Wi-Fi")
                    // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                    }
                    // 中文注释：下一行创建或配置一个 Compose 界面组件。
                    Button(onClick = vm::testConnection, modifier = Modifier.weight(1f)) {
                        // 中文注释：下一行创建或配置一个 Compose 界面组件。
                        Icon(Icons.Rounded.Refresh, null)
                        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                        Spacer(Modifier.width(6.dp))
                        // 中文注释：下一行创建或配置一个 Compose 界面组件。
                        Text("测试连接")
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
    // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
    val context = LocalContext.current

    // 中文注释：下面原有注释用于说明相邻代码的设计目的。
    // 输入“表情总数”，下方快捷按钮会自动生成 1..N。
    // 中文注释：下面原有注释用于说明相邻代码的设计目的。
    // 默认保持原来的 15 个快捷表情。
    // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
    var faceTotalText by remember { mutableStateOf("15") }

    // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
    var seqFace by remember { mutableStateOf("1") }
    // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
    var seqTime by remember { mutableStateOf("500") }
    // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
    val sequence = remember { mutableStateListOf<SequenceStep>() }

    // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
    val faceTotal = faceTotalText
        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
        .toIntOrNull()
        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
        ?.coerceIn(1, 999)
        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
        ?: 0

    // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
    val faceNumbers = remember(faceTotal) {
        // 中文注释：下一行根据条件决定是否执行对应分支。
        if (faceTotal > 0) {
            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
            (1..faceTotal).toList()
        // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
        } else {
            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
            emptyList()
        // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
        }
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
        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
        item {
            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
            SectionCard(
                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                title = "指定表情"
// 中文注释：下面原有注释用于说明相邻代码的设计目的。
//                subtitle = "输入表情总数，快捷按钮自动生成 1–N"
            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
            ) {
                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                OutlinedTextField(
                    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                    value = faceTotalText,
                    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                    onValueChange = { value ->
                        // 中文注释：下面原有注释用于说明相邻代码的设计目的。
                        // 最多允许 999 个表情编号。
                        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                        faceTotalText = value
                            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                            .filter(Char::isDigit)
                            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                            .take(3)
                    // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                    },
                    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                    label = { Text("表情总数") },
                    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                    placeholder = { Text("例如 53") },
                    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                    keyboardOptions = KeyboardOptions(
                        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                        keyboardType = KeyboardType.Number
                    // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                    ),
                    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                    modifier = Modifier.fillMaxWidth(),
                    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                    singleLine = true
                // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                )

                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                Spacer(Modifier.height(12.dp))

                // 中文注释：下一行根据条件决定是否执行对应分支。
                if (faceTotal > 0) {
// 中文注释：下面原有注释用于说明相邻代码的设计目的。
//                    Text(
// 中文注释：下面原有注释用于说明相邻代码的设计目的。
//                        text = "快捷表情 1–$faceTotal",
// 中文注释：下面原有注释用于说明相邻代码的设计目的。
//                        style = MaterialTheme.typography.labelLarge,
// 中文注释：下面原有注释用于说明相邻代码的设计目的。
//                        color = RinaTextSecondary
// 中文注释：下面原有注释用于说明相邻代码的设计目的。
//                    )

                    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                    Spacer(Modifier.height(8.dp))

                    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                    /*
                     // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                     * 固定显示 5 列 × 最多 3 行。
                     // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                     *
                     // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                     * 每个按钮高度 44dp：
                     // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                     * 3 × 44 + 2 × 8 = 148dp
                     // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                     *
                     // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                     * 当表情总数超过 15 时：
                     // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                     * - 网格内部可纵向滚动
                     // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                     * - 右侧显示粉色滚动条
                     // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                     *
                     // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                     * 因为整个网格高度固定，所以不会把下面的“上一个 / 下一个”
                     // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                     * 或其他页面模块继续往下撑。
                     // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                     */
                    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                    FaceQuickGrid(
                        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                        faceNumbers = faceNumbers,
                        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                        onFaceClick = vm::showFace
                    // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                    )
                // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                } else {
                    // 中文注释：下一行创建或配置一个 Compose 界面组件。
                    Surface(
                        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                        modifier = Modifier
                            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                            .fillMaxWidth()
                            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                            .height(64.dp),
                        // 中文注释：下一行处理灯珠颜色、画笔 RGB 或界面颜色。
                        color = Color(0xFFF7F8FA),
                        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                        shape = RoundedCornerShape(14.dp)
                    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                    ) {
                        // 中文注释：下一行创建或配置一个 Compose 界面组件。
                        Box(
                            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                            modifier = Modifier.fillMaxSize(),
                            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                            contentAlignment = Alignment.Center
                        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                        ) {
                            // 中文注释：下一行创建或配置一个 Compose 界面组件。
                            Text(
                                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                                text = "请输入有效的表情总数",
                                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                                color = RinaTextSecondary,
                                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                                style = MaterialTheme.typography.bodyMedium
                            // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                            )
                        // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                        }
                    // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                    }
                // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                }

                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                Spacer(Modifier.height(10.dp))

                // 中文注释：下一行创建或配置一个 Compose 界面组件。
                Row(
                    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                    modifier = Modifier.fillMaxWidth(),
                    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                ) {
                    // 中文注释：下一行创建或配置一个 Compose 界面组件。
                    OutlinedButton(
                        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                        onClick = vm::previousFace,
                        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                        modifier = Modifier.weight(1f)
                    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                    ) {
                        // 中文注释：下一行创建或配置一个 Compose 界面组件。
                        Text(
                            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                            text = "上一个",
                            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                            maxLines = 1,
                            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                            softWrap = false
                        // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                        )
                    // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                    }

                    // 中文注释：下一行创建或配置一个 Compose 界面组件。
                    OutlinedButton(
                        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                        onClick = vm::nextFace,
                        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                        modifier = Modifier.weight(1f)
                    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                    ) {
                        // 中文注释：下一行创建或配置一个 Compose 界面组件。
                        Text(
                            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                            text = "下一个",
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
        // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
        }

        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
        item {
            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
            SectionCard(
                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                "璃奈璃画室"
// 中文注释：下面原有注释用于说明相邻代码的设计目的。
//                "使用 308 颗 LED 的真实物理坐标，进入后自动横屏"
            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
            ) {
                // 中文注释：下一行创建或配置一个 Compose 界面组件。
                Button(
                    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                    onClick = {
                        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                        context.startActivity(
                            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                            Intent(
                                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                                context,
                                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                                DrawActivity::class.java
                            // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                            )
                        // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                        )
                    // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                    },
                    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                    modifier = Modifier.fillMaxWidth()
                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                ) {
                    // 中文注释：下一行创建或配置一个 Compose 界面组件。
                    Icon(Icons.Rounded.Brush, null)
                    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                    Spacer(Modifier.width(8.dp))
                    // 中文注释：下一行创建或配置一个 Compose 界面组件。
                    Text("进入画室")
                // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                }
            // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
            }
        // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
        }

        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
        item {
            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
            SectionCard(
                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                "表情序列"
// 中文注释：下面原有注释用于说明相邻代码的设计目的。
//                "按 face,time(ms); 格式发送 SQ"
            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
            ) {
                // 中文注释：下一行创建或配置一个 Compose 界面组件。
                Row(
                    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                    modifier = Modifier.fillMaxWidth(),
                    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                ) {
                    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                    OutlinedTextField(
                        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                        value = seqFace,
                        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                        onValueChange = {
                            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                            seqFace = it
                                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                                .filter(Char::isDigit)
                                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                                .take(3)
                        // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                        },
                        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                        label = { Text("表情") },
                        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                        modifier = Modifier.weight(1f),
                        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                        singleLine = true,
                        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                        keyboardOptions = KeyboardOptions(
                            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                            keyboardType = KeyboardType.Number
                        // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                        )
                    // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                    )

                    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                    OutlinedTextField(
                        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                        value = seqTime,
                        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                        onValueChange = {
                            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                            seqTime = it
                                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                                .filter(Char::isDigit)
                                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                                .take(5)
                        // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                        },
                        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                        label = { Text("毫秒") },
                        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                        modifier = Modifier.weight(1f),
                        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                        singleLine = true,
                        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                        keyboardOptions = KeyboardOptions(
                            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                            keyboardType = KeyboardType.Number
                        // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                        )
                    // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                    )
                // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                }

                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                Spacer(Modifier.height(8.dp))

                // 中文注释：下一行创建或配置一个 Compose 界面组件。
                Button(
                    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                    onClick = {
                        // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
                        val f = seqFace.toIntOrNull()
                        // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
                        val t = seqTime.toIntOrNull()

                        // 中文注释：下一行根据条件决定是否执行对应分支。
                        if (
                            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                            f != null &&
                            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                            f > 0 &&
                            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                            t != null
                        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                        ) {
                            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                            sequence += SequenceStep(
                                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                                f,
                                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                                t.coerceAtLeast(100)
                            // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                            )
                        // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                        }
                    // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                    },
                    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                    modifier = Modifier.fillMaxWidth()
                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                ) {
                    // 中文注释：下一行创建或配置一个 Compose 界面组件。
                    Text("添加序列排练")
                // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                }

                // 中文注释：下一行根据条件决定是否执行对应分支。
                if (sequence.isNotEmpty()) {
                    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                    Spacer(Modifier.height(10.dp))
                    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                    sequence.forEachIndexed { index, step ->
                        // 中文注释：下一行创建或配置一个 Compose 界面组件。
                        Row(
                            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                            Modifier.fillMaxWidth(),
                            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                            verticalAlignment = Alignment.CenterVertically
                        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                        ) {
                            // 中文注释：下一行创建或配置一个 Compose 界面组件。
                            Text(
                                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                                "${index + 1}. f${step.face} · ${step.durationMs}ms",
                                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                                modifier = Modifier.weight(1f)
                            // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                            )
                            // 中文注释：下一行创建或配置一个 Compose 界面组件。
                            IconButton(
                                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                                onClick = {
                                    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                                    sequence.removeAt(index)
                                // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                                }
                            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                            ) {
                                // 中文注释：下一行创建或配置一个 Compose 界面组件。
                                Icon(
                                    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                                    Icons.Rounded.Delete,
                                    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                                    null
                                // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                                )
                            // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                            }
                        // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                        }
                        // 中文注释：下一行根据条件决定是否执行对应分支。
                        if (index < sequence.lastIndex) {
                            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                            HorizontalDivider()
                        // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                        }
                    // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                    }

                    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                    Spacer(Modifier.height(8.dp))

                    // 中文注释：下一行创建或配置一个 Compose 界面组件。
                    Button(
                        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                        onClick = {
                            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                            vm.playSequence(
                                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                                sequence.toList()
                            // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                            )
                        // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                        },
                        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                        modifier = Modifier.fillMaxWidth()
                    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                    ) {
                        // 中文注释：下一行创建或配置一个 Compose 界面组件。
                        Text("表演开始")
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
// 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
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
//                ProtocolLine("PB / PC / PF", "彩色逐灯绘画：开始 / RGB 分块 / 刷新")
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
    // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
    val context = LocalContext.current
    // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
    val host by vm.host.collectAsStateWithLifecycle()
    // 中文注释：下一行定义或读取本段逻辑需要使用的变量、常量或状态。
    var editHost by remember(host) { mutableStateOf(host) }

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
            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
            SectionCard("设备网络") {
                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                OutlinedTextField(
                    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                    value = editHost,
                    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                    onValueChange = { editHost = it.filter { c -> c.isDigit() || c == '.' }.take(15) },
                    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                    label = { Text("设备 IP") },
                    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                    modifier = Modifier.fillMaxWidth(),
                    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                    singleLine = true,
                    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal)
                // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                )
                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                Spacer(Modifier.height(10.dp))
                // 中文注释：下一行创建或配置一个 Compose 界面组件。
                Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                    // 中文注释：下一行创建或配置一个 Compose 界面组件。
                    Button(onClick = { vm.setHost(editHost) }, modifier = Modifier.weight(1f)) { Text("保存并测试") }
                    // 中文注释：下一行创建或配置一个 Compose 界面组件。
                    OutlinedButton(onClick = {
                        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                        editHost = BoardSettings.DEFAULT_HOST
                        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                        vm.resetHost()
                    // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                    }, modifier = Modifier.weight(1f)) { Text("恢复默认") }
                // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                }
            // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
            }
        // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
        }
        // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
        item {
            // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
            SectionCard("Wi-Fi 参数") {
                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                InfoLine("SSID", BoardSettings.AP_SSID)
// 中文注释：下面原有注释用于说明相邻代码的设计目的。
//                InfoLine("默认 IP", BoardSettings.DEFAULT_HOST)
// 中文注释：下面原有注释用于说明相邻代码的设计目的。
//                InfoLine("HTTP 端口", "80")
                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                InfoLine("电量 UDP", "5001 / 每 5 秒")
                // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                Spacer(Modifier.height(10.dp))
                // 中文注释：下一行创建或配置一个 Compose 界面组件。
                OutlinedButton(onClick = { context.startActivity(Intent(Settings.ACTION_WIFI_SETTINGS)) }, modifier = Modifier.fillMaxWidth()) {
                    // 中文注释：下一行创建或配置一个 Compose 界面组件。
                    Icon(Icons.Rounded.Wifi, null)
                    // 中文注释：下一行执行本段程序所需的配置、计算、状态更新或函数调用。
                    Spacer(Modifier.width(8.dp))
                    // 中文注释：下一行创建或配置一个 Compose 界面组件。
                    Text("打开系统 Wi-Fi 设置")
                // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
                }
            // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
            }
        // 中文注释：下一行用于结束当前代码块、函数、类型或参数列表。
        }
// 中文注释：下面原有注释用于说明相邻代码的设计目的。
//        item {
// 中文注释：下面原有注释用于说明相邻代码的设计目的。
//            SectionCard("界面说明", "粉色主色 + 青色强调，圆角卡片和轻量信息层级") {
// 中文注释：下面原有注释用于说明相邻代码的设计目的。
//                Text("主界面固定竖屏；“临时绘画”使用独立横屏 Activity。手机端优先通过 UDP 接收电量，同时以 HTTP /BT 作为连接检测和备用读取。", color = RinaTextSecondary)
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
