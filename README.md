# Multiplatform-Zwkfb

[![](https://jitpack.io/v/dxycw/multiplatform-zwkfb.svg)](https://jitpack.io/#dxycw/multiplatform-zwkfb)

**本项目用于Kotlin多平台项目（Android、iOS、Desktop （Windows、MacOS和Linux）、js、wasmJs和web）的“zwkfb”中文开发包，
如果你使用的的是xml布局项目，请使用[zwkfb_view](https://github.com/dxycw/zwkfb_view)。**

# 使用方法

**1、在项目的 settings.gradle 文件中添加 JitPack 仓库：**

```kotlin
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        mavenCentral()
        maven { url = uri("https://jitpack.io") }  // 添加 JitPack 仓库
    }
}
```

**2、在项目的 build.gradle 文件中添加依赖项：**

```kotlin
dependencies {
    
    // 如果使用多平台Jetpack Compose Multiplatform，请添加以下依赖项
    implementation("com.github.dxycw.multiplatform-zwkfb:zwkfb:0.0.2")
    
    // 如果使用 Android Jetpack Compose，请添加以下依赖项
    implementation("com.github.dxycw.multiplatform-zwkfb:zwkfb-android:0.0.2")
    
    // 如果使用 Windows Jetpack Compose，请添加以下依赖项
    implementation("com.github.dxycw.multiplatform-zwkfb:zwkfb-jvm:0.0.2")
    
    // 以下平台可以用，但目前不推荐使用
    
    // 如果使用 IOS Jetpack Compose，请添加以下依赖项
    // 本版本不支持“x86_64”平台，所以在项目中使用时去掉“x86_64”平台的依赖项，下个版本将删除
    //implementation("com.github.dxycw.multiplatform-zwkfb:zwkfb-iosx64:0.0.1")
    implementation("com.github.dxycw.multiplatform-zwkfb:zwkfb-iosarm64:0.0.2")
    implementation("com.github.dxycw.multiplatform-zwkfb:zwkfb-iossimulatorarm64:0.0.2")
    
    // 如果使用 Web Jetpack Compose，请添加以下依赖项
    implementation("com.github.dxycw.multiplatform-zwkfb:zwkfb-js:0.0.2")
    implementation("com.github.dxycw.multiplatform-zwkfb:zwkfb-wasm-js:0.0.2")
    
}
```

**3、目前可以使用的平台：**

| 平台                | 是否可用 |
|-------------------|------|
| Multiplatform     | ✅️   |
| Android           | ✅️   |
| Desktop (Windows) | ✅️   |
| Desktop (MacOS)   | ❌️   |
| Desktop (Linux)   | ❌️   |
| IOS               | ❌️   |
| Web               | ❌️   |

**4、使用的依赖库：**

* 本项目所有平台[使用的依赖库](%E6%A1%88%E4%BE%8B%E6%95%99%E7%A8%8B/%E4%BD%BF%E7%94%A8%E7%9A%84%E4%BE%9D%E8%B5%96%E5%BA%93.md)；

**5、示例代码：**

* 本项目所有平台[示例代码](%E6%A1%88%E4%BE%8B%E6%95%99%E7%A8%8B/%E7%A4%BA%E4%BE%8B%E4%BB%A3%E7%A0%81/%E7%A4%BA%E4%BE%8B%E4%BB%A3%E7%A0%81.md)；

**6、项目更新问题：**

* 项目>=0.0.2版本：
    因为 org.jetbrains.compose 的 [1.11.0-alpha02](https://github.com/JetBrains/compose-multiplatform/releases/tag/v1.11.0-alpha02) 版本以后去掉了“x86_64”平台，所以本项目也去掉了“x86_64”平台的依赖项，所以在项目中使用时去掉“x86_64”平台的依赖；
    ```kotlin
    listOf(
    //    iosX64(),   // 去掉“x86_64”平台的依赖项，所以在项目中使用时去掉“x86_64”平台的依赖；
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        // 略
    }
    ```



# 更新内容

## 0.0.2

* 优化 项目文档，完善使用方法、平台支持、依赖库等信息；
* 添加 四个“文本()”、两个“按钮()”、两个“凸起按钮()”、两个“填充色调按钮()”、两个“轮廓按钮()”、两个“文本按钮()” 函数组件；
* 添加 “本地文本样式” 属性函数；
* 添加 “提供文本样式()” 函数；
* 添加 “按钮默认值” 对象函数；
* 添加 “按钮颜色”、“按钮形状” 类；
* 更新 org.jetbrains.compose.runtime:runtime 依赖库版本为 1.11.0-beta03；
* 更新 org.jetbrains.compose.foundation:foundation 依赖库版本为 1.11.0-beta03；
* 更新 org.jetbrains.compose.material3:material3 依赖库版本为 1.11.0-alpha07；
* 更新 org.jetbrains.compose.ui:ui 依赖库版本为 1.11.0-beta03；
* 更新 org.jetbrains.compose.ui:ui-tooling-preview 依赖库版本为 1.11.0-beta03；
* 更新 org.jetbrains.compose.components:components-resources 依赖库版本为 1.11.0-beta03；
* 去掉 IOS平台的“x86_64”平台依赖项，因为 org.jetbrains.compose 的 [1.11.0-alpha02](https://github.com/JetBrains/compose-multiplatform/releases/tag/v1.11.0-alpha02) 版本去掉了“x86_64”平台，所以项目也去掉了“x86_64”平台的依赖项，所以在项目中使用时去掉“x86_64”平台的依赖；

## 0.0.1

* 创建项目，发布第一个版本；
* 完善项目文档，添加使用方法、平台支持、依赖库等信息；
