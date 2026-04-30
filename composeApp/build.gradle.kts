import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
    alias(libs.plugins.composeHotReload)
}

kotlin {

    androidTarget {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }

    listOf(
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "ComposeApp"
            isStatic = true
        }
    }

    js {
        browser()
        binaries.executable()
    }

    jvm()

    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
        browser()
        binaries.executable()
    }

    sourceSets {
        androidMain.dependencies {
            implementation(libs.compose.uiToolingPreview)
            implementation(libs.androidx.activity.compose)
        }
        commonMain.dependencies {
            implementation(libs.compose.runtime)
            implementation(libs.compose.foundation)
            implementation(libs.compose.material3)
            implementation(libs.compose.ui)
            implementation(libs.compose.components.resources)
            implementation(libs.compose.uiToolingPreview)
            implementation(libs.androidx.lifecycle.viewmodelCompose)
            implementation(libs.androidx.lifecycle.runtimeCompose)

            implementation(projects.zwkfb)
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
        jvmMain.dependencies {
            implementation(compose.desktop.currentOs)
            implementation(libs.kotlinx.coroutinesSwing)
        }
        iosMain.dependencies {}
        jsMain.dependencies {}
        wasmJsMain.dependencies {}
        webMain.dependencies {}
    }
}

android {

    signingConfigs {
        create("release") {
            storeFile = file("../key.jks")
            storePassword = "12345678"
            keyAlias = "key"
            keyPassword = "12345678"
        }
    }
    namespace = "com.zwkfb.multiplatform"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.zwkfb.multiplatform"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "0.0.1"
    }

    splits {
        abi {
            isEnable = true // 是否开启ABI分割
            reset()  // 清空默认的abi配置
            include("armeabi-v7a", "arm64-v8a", "x86", "x86_64") // 指定要支持的ABI
            isUniversalApk = false     // 是否生成通用apk
        }
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            signingConfig = signingConfigs.getByName("release")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

}

dependencies {
    implementation(libs.compose.uiTooling)
}

compose.desktop {
    application {
        mainClass = "com.zwkfb.multiplatform.MainKt"

        nativeDistributions {
            targetFormats(
                TargetFormat.Dmg, TargetFormat.Msi,
                TargetFormat.Deb, TargetFormat.Exe
            )
            packageName = "灵阁"
            packageVersion = "1.0.0"
        }
    }
}
