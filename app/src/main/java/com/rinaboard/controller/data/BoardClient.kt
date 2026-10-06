package com.rinaboard.controller.data

import android.content.Context
import com.rinaboard.controller.model.BatteryState
import com.rinaboard.controller.model.ConnectionState
import com.rinaboard.controller.model.Su03tUpdateState
import kotlinx.coroutines.flow.StateFlow

/** APP 与璃奈板的统一客户端；底层已经从 Wi-Fi/HTTP 改成 BLE GATT。 */
class BoardClient(context: Context) {
    private val ble = BoardBleManager.get(context)
    val connectionState: StateFlow<ConnectionState> = ble.connectionState

    suspend fun connect(): Result<Unit> = ble.connect()
    fun disconnect() = ble.disconnect()

    suspend fun command(path: String): Result<String> = runCatching {
        require(path.isNotBlank()) { "命令不能为空" }
        require(!path.any { it == '\r' || it == '\n' }) { "命令包含非法字符" }
        ble.command(path)
    }

    suspend fun brightness(): Result<Int> = command(BoardProtocol.BRIGHTNESS_QUERY).mapCatching { body ->
        body.trim().removePrefix("OK BQ").trim().toInt().coerceIn(0, 200)
    }

    suspend fun battery(): Result<BatteryState> = command(BoardProtocol.BATTERY).mapCatching {
        BatteryState.fromJson(it, "BLE")
    }

    suspend fun updateStatus(): Result<Su03tUpdateState> = command(BoardProtocol.SU03T_UPDATE_STATUS).mapCatching {
        Su03tUpdateState.fromJson(it)
    }
}
