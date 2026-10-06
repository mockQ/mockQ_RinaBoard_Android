package com.rinaboard.controller.data

import com.rinaboard.controller.model.BatteryState
import kotlinx.coroutines.CoroutineScope

/**
 * 兼容旧工程文件名。
 * APP 改为 BLE 后不再监听 Wi-Fi UDP 电量广播；电量通过 BLE 的 BT 命令读取。
 */
@Deprecated("BLE 版本不再使用 UDP 电量推送")
class BatteryTelemetryReceiver(
    private val onBattery: (BatteryState) -> Unit
) {
    fun start(scope: CoroutineScope) = Unit
    fun stop() = Unit
}
