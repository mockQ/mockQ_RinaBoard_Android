# Rina Board Android Controller

从零编写的璃奈板 Android 控制 APP。技术栈：Kotlin + Jetpack Compose。

## 1. 对应当前 ESP32-S3 Wi-Fi 固件

默认参数：

- AP SSID: `RinaCyanBoard`
- AP Password: `1211009rina`
- Board IP: `192.168.1.18`
- HTTP Port: `80`
- Battery UDP Port: `5001`
- Battery UDP period: `5 s`

APP 不尝试静默接管 Android Wi-Fi；先在系统 Wi-Fi 中连接 `RinaCyanBoard`，再回到 APP。

### 支持命令

| APP 功能 | ESP32 命令 |
|---|---|
| 指定表情 | `FC<n>` |
| 熄屏 | `FC0` |
| 上一个 / 下一个 | `FU` / `FD` |
| 自动轮播 | `FL` |
| 停止并回眨眼 | `FS` |
| 眨眼开 / 关 | `BL1` / `BL0` |
| 表情序列 | `SQface,time;...` |
| 临时绘画 | `DR0,1,2,...` |
| 电量查询 | `BT` |
| SU-03T 上下电 | `VP1` / `VP0` |
| SU-03T 开始升级 | `SU` |
| SU-03T 升级状态 | `US` |

## 2. 页面

- **主页（竖屏）**：在线状态、电量、充电状态、快捷控制、Wi-Fi 入口。
- **表情（竖屏）**：指定表情、1~15 快捷表情、上一/下一、轮播、眨眼、表情序列。
- **临时绘画（独立横屏 Activity）**：按照提供的 308 点 `rawCoords` 绘制，支持画笔、橡皮、清空和发送。
- **设备（竖屏）**：SU-03T 上下电、从 SD 卡触发升级、查看升级进度。
- **设置（竖屏）**：修改板端 IP、打开 Wi-Fi 设置、查看协议参数。

## 3. UI

采用粉色主色 `#FB7299`、青色强调 `#23ADE5`、白色圆角卡片和浅灰背景；整体只参考哔哩哔哩常见的轻量粉色视觉语言，没有使用其 Logo 或素材。

## 4. 临时绘画坐标

`LedMap.kt` 含 0~307 共 308 个点，直接由用户提供的 `rawCoords` 生成。绘制时保持坐标等比例，并将 PCB 坐标 Y 轴翻转到 Android Canvas 坐标系。

注意：当前 ESP32 HTTP 服务一次 `recv()` 缓冲区为 1024 字节。APP 使用精简原始 HTTP GET，并限制单次请求到 960 字节。如果一次点亮过多 LED 导致 `DR` 命令过长，APP 会明确提示“命令过长”。普通表情通常远低于此限制。

## 5. Android 版本

- `compileSdk = 36`
- `targetSdk = 36`
- `minSdk = 26`
- AGP `8.13.2`
- Kotlin `2.3.21`
- Compose BOM `2026.06.01`
- Gradle distribution `8.13`

Android 16 / target SDK 36 下，局域网 TCP/UDP 仍可由 `INTERNET` 权限访问；未来若把 targetSdk 升到 Android 17 / API 37，需要按新规则增加 `ACCESS_LOCAL_NETWORK` 运行时权限。

## 6. 打开和编译

1. 用 Android Studio 打开项目根目录 `RinaBoardAndroid`。
2. 等待 Gradle Sync。
3. 确认安装 Android SDK 36 与 JDK 17+。
4. 连接 Android 手机，点击 Run。
5. 手机先连接 `RinaCyanBoard` Wi-Fi，再打开 APP 测试连接。

如果 Android Studio 提示 Gradle distribution，选择 Wrapper/Gradle 8.13。`gradle/wrapper/gradle-wrapper.properties` 已提供 distribution URL。

## 7. 目录

```text
RinaBoardAndroid/
├─ build.gradle.kts
├─ settings.gradle.kts
├─ gradle.properties
├─ gradle/wrapper/gradle-wrapper.properties
└─ app/
   ├─ build.gradle.kts
   └─ src/main/
      ├─ AndroidManifest.xml
      ├─ java/com/rinaboard/controller/
      │  ├─ MainActivity.kt
      │  ├─ data/
      │  │  ├─ BoardClient.kt
      │  │  ├─ BoardProtocol.kt
      │  │  ├─ BoardSettings.kt
      │  │  └─ BatteryTelemetryReceiver.kt
      │  ├─ led/LedMap.kt
      │  ├─ model/Models.kt
      │  └─ ui/
      │     ├─ AppViewModel.kt
      │     ├─ DrawActivity.kt
      │     ├─ MainScreen.kt
      │     └─ theme/
      │        ├─ Color.kt
      │        └─ Theme.kt
      └─ res/
```
