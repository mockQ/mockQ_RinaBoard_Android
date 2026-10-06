package com.rinaboard.controller.data

import android.content.Context

/** 仅保存 APP 本地界面设置；设备连接已经从 IP/Wi-Fi 改成 BLE 自动发现。 */
class BoardSettings(context: Context) {
    private val prefs = context.applicationContext.getSharedPreferences("rina_board", Context.MODE_PRIVATE)

    var brightnessMin: Int
        get() = prefs.getInt(KEY_BRIGHTNESS_MIN, DEFAULT_BRIGHTNESS_MIN)
        set(value) = prefs.edit().putInt(KEY_BRIGHTNESS_MIN, value.coerceIn(0, 199)).apply()

    var brightnessMax: Int
        get() = prefs.getInt(KEY_BRIGHTNESS_MAX, DEFAULT_BRIGHTNESS_MAX)
        set(value) = prefs.edit().putInt(KEY_BRIGHTNESS_MAX, value.coerceIn(0, 200)).apply()

    var brightnessValue: Int
        get() = prefs.getInt(KEY_BRIGHTNESS_VALUE, DEFAULT_BRIGHTNESS)
        set(value) = prefs.edit().putInt(KEY_BRIGHTNESS_VALUE, value.coerceIn(0, 200)).apply()

    /** 手机本地表情目录的 SAF Tree URI。为空时兼容读取 APK assets/out。 */
    var faceFolderUri: String?
        get() = prefs.getString(KEY_FACE_FOLDER_URI, null)
        set(value) = prefs.edit().putString(KEY_FACE_FOLDER_URI, value).apply()

    companion object {
        const val BLE_DEVICE_NAME = "RinaBoard"
        const val DEFAULT_BRIGHTNESS_MIN = 5
        const val DEFAULT_BRIGHTNESS_MAX = 100
        const val DEFAULT_BRIGHTNESS = 25

        private const val KEY_BRIGHTNESS_MIN = "brightness_min"
        private const val KEY_BRIGHTNESS_MAX = "brightness_max"
        private const val KEY_BRIGHTNESS_VALUE = "brightness_value"
        private const val KEY_FACE_FOLDER_URI = "face_folder_uri"
    }
}
