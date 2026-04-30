import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidKotlinMultiplatformLibrary)
    alias(libs.plugins.androidLint)

    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
    alias(libs.plugins.composeHotReload)
    id("maven-publish")
}

kotlin {

    androidLibrary {
        namespace = "compose.multiplatform.zwkfb"
        compileSdk = 36
        minSdk = 24

        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }

        withHostTestBuilder {}

        withDeviceTestBuilder { sourceSetTreeName = "test" }.configure {
            instrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        }
    }

    listOf(
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "zwkfbKit"
            isStatic = true
        }
    }

    js {
        browser()
        binaries.executable()
    }

    jvm {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }

    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
        browser()
        binaries.executable()
    }

    sourceSets {
        commonMain {
            dependencies {
                implementation("org.jetbrains.kotlin:kotlin-stdlib:2.3.20")
                // 在此处添加 KMP 依赖项

//                api("org.jetbrains.compose.ui:ui-graphics:1.11.0-beta03")

                // 0.0.2
                api("org.jetbrains.compose.runtime:runtime:1.11.0-beta03")
                api("org.jetbrains.compose.foundation:foundation:1.11.0-beta03")
                api("org.jetbrains.compose.material3:material3:1.11.0-alpha07")
                api("org.jetbrains.compose.ui:ui:1.11.0-beta03")
                api("org.jetbrains.compose.ui:ui-tooling-preview:1.11.0-beta03")
                api("org.jetbrains.compose.components:components-resources:1.11.0-beta03")

                // 0.0.3
                api("org.jetbrains.androidx.lifecycle:lifecycle-viewmodel-compose:2.11.0-alpha03")
                api("org.jetbrains.androidx.lifecycle:lifecycle-runtime-compose:2.11.0-alpha03")
                api("org.jetbrains.compose.material:material-icons-extended:1.7.3")
                api("org.jetbrains.androidx.navigation:navigation-compose:2.9.2")

            }
        }

        commonTest {
            dependencies {
                implementation(libs.kotlin.test)
            }
        }

        androidMain {
            dependencies {
                // 0.0.3
                api("androidx.activity:activity-compose:1.13.0")

                // 本库的预览界面依赖库，
                implementation("org.jetbrains.compose.ui:ui-tooling:1.11.0-beta03")
                implementation("androidx.customview:customview-poolingcontainer:1.0.0")
                implementation("androidx.emoji2:emoji2:1.5.0")
            }
        }

        getByName("androidDeviceTest") {
            dependencies {
                implementation(libs.androidx.runner)
                implementation(libs.androidx.core)
                implementation(libs.androidx.testExt.junit)
            }
        }

        jvmMain{
            dependencies {
                implementation(compose.desktop.currentOs)
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-swing:1.10.2")
            }
        }

        iosMain {
            dependencies {

            }
        }
        jsMain {
            dependencies {}
        }
        wasmJsMain {
            dependencies {}
        }
        webMain {
            dependencies {}
        }

    }

}

tasks.withType<org.jetbrains.kotlin.gradle.targets.js.npm.tasks.KotlinNpmInstallTask>().configureEach {
    onlyIf { false } // 跳过 NPM 安装
}