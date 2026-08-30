// 中文注释：应用模块使用 Android Application、Kotlin Android 和 Compose 三个插件。
plugins {
    // 中文注释：启用 Android 应用程序构建插件。
    id("com.android.application")
    // 中文注释：启用 Kotlin Android 支持。
    id("org.jetbrains.kotlin.android")
    // 中文注释：启用 Kotlin Compose 编译插件。
    id("org.jetbrains.kotlin.plugin.compose")
}

// 中文注释：下面集中配置 Android 应用模块的 SDK、包名、Java 版本和 Compose 功能。
android {
    // 中文注释：声明代码命名空间，需与 Kotlin 包名保持一致。
    namespace = "com.rinaboard.controller"
    // 中文注释：指定编译时使用的 Android SDK 版本。
    compileSdk = 36

    // 中文注释：配置安装包的基础参数。
    defaultConfig {
        // 中文注释：声明最终 APK 的 applicationId。
        applicationId = "com.rinaboard.controller"
        // 中文注释：最低支持 Android 8.0（API 26）。
        minSdk = 26
        // 中文注释：目标 Android SDK 版本。
        targetSdk = 36
        // 中文注释：应用内部版本号。
        versionCode = 2
        // 中文注释：用户可见版本名，本版增加彩色逐灯绘画功能。
        versionName = "1.1.0-color"
    }

    // 中文注释：启用 Jetpack Compose 和 BuildConfig 生成功能。
    buildFeatures {
        // 中文注释：开启 Compose 界面框架。
        compose = true
        // 中文注释：允许生成 BuildConfig 常量类。
        buildConfig = true
    }

    // 中文注释：统一 Java 源码与目标字节码版本为 Java 17。
    compileOptions {
        // 中文注释：设置 Java 源代码兼容版本。
        sourceCompatibility = JavaVersion.VERSION_17
        // 中文注释：设置 Java 目标字节码版本。
        targetCompatibility = JavaVersion.VERSION_17
    }

    // 中文注释：排除依赖包里不需要重复打包的许可证资源。
    packaging {
        // 中文注释：避免 META-INF 中重复资源造成打包冲突。
        resources.excludes += "/META-INF/{AL2.0,LGPL2.1}"
    }
}

// 中文注释：设置 Kotlin JVM 目标版本为 Java 17。
kotlin {
    // 中文注释：使用新的 compilerOptions 配置方式，避免旧 jvmTarget 警告。
    compilerOptions {
        // 中文注释：生成兼容 JVM 17 的 Kotlin 字节码。
        jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_17)
    }
}

// 中文注释：下面声明 APP 运行所需的 AndroidX、协程与 Compose 依赖。
dependencies {
    // 中文注释：Android Kotlin 常用扩展函数。
    implementation("androidx.core:core-ktx:1.17.0")
    // 中文注释：Compose Activity 容器支持。
    implementation("androidx.activity:activity-compose:1.11.0")

    // 中文注释：Lifecycle 运行时 Kotlin 扩展。
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.9.4")
    // 中文注释：Compose 中安全收集 Lifecycle StateFlow。
    implementation("androidx.lifecycle:lifecycle-runtime-compose:2.9.4")
    // 中文注释：Compose ViewModel 支持。
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.9.4")

    // 中文注释：Android 协程支持，用于网络命令和状态轮询。
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.10.2")

    // 中文注释：使用 Compose BOM 统一所有 Compose 库版本。
    val composeBom = platform("androidx.compose:compose-bom:2026.06.01")
    // 中文注释：正式代码采用同一 Compose BOM。
    implementation(composeBom)
    // 中文注释：Android 测试也采用同一 Compose BOM。
    androidTestImplementation(composeBom)

    // 中文注释：Compose 基础 UI。
    implementation("androidx.compose.ui:ui")
    // 中文注释：Compose 预览支持。
    implementation("androidx.compose.ui:ui-tooling-preview")
    // 中文注释：Compose Foundation，包含 Canvas、手势等基础功能。
    implementation("androidx.compose.foundation:foundation")
    // 中文注释：Material 3 控件，包括 Slider、Button、Card 等。
    implementation("androidx.compose.material3:material3")
    // 中文注释：Material 扩展图标，用于绘画、发送和设置界面。
    implementation("androidx.compose.material:material-icons-extended")

    // 中文注释：Debug 版本启用 Compose 调试工具。
    debugImplementation("androidx.compose.ui:ui-tooling")
}
