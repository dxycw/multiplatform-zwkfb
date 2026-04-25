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

        withHostTestBuilder {}

        withDeviceTestBuilder { sourceSetTreeName = "test" }.configure {
            instrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        }
    }

    js {
        browser()
        binaries.executable()
    }

    jvm()

    @OptIn(org.jetbrains.kotlin.gradle.ExperimentalWasmDsl::class)
    wasmJs {
        browser()
        binaries.executable()
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

    sourceSets {
        commonMain {
            dependencies {
                implementation(libs.kotlin.stdlib)
                // Add KMP dependencies here

                // 0.0.2
                api("org.jetbrains.compose.runtime:runtime:1.11.0-beta03")
                api("org.jetbrains.compose.foundation:foundation:1.11.0-beta03")
                api("org.jetbrains.compose.material3:material3:1.11.0-alpha07")
                api("org.jetbrains.compose.ui:ui:1.11.0-beta03")
                api("org.jetbrains.compose.ui:ui-tooling-preview:1.11.0-beta03")
                api("org.jetbrains.compose.components:components-resources:1.11.0-beta03")

                // 0.0.1
                api("org.jetbrains.androidx.lifecycle:lifecycle-viewmodel-compose:2.10.0")
                api("org.jetbrains.androidx.lifecycle:lifecycle-runtime-compose:2.10.0")

            }
        }

        commonTest {
            dependencies {
                implementation(libs.kotlin.test)
            }
        }

        androidMain {
            dependencies {}
        }

        getByName("androidDeviceTest") {
            dependencies {
                implementation(libs.androidx.runner)
                implementation(libs.androidx.core)
                implementation(libs.androidx.testExt.junit)
            }
        }

        jvmMain {
            dependencies {
                implementation(compose.desktop.currentOs)
                implementation(libs.kotlinx.coroutinesSwing)
            }
        }

        iosMain {
            dependencies {}
        }
    }

}

tasks.withType<org.jetbrains.kotlin.gradle.targets.js.npm.tasks.KotlinNpmInstallTask>().configureEach {
    onlyIf { false } // 跳过 NPM 安装
}