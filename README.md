
<div align="center">

<h1>
  Multiplatform-Zwkfb
</h1>

**一款强大的Kotlin多平台“zwkfb”中文开发包，适用于使用Compose Multiplatform的Kotlin多平台项目。**

[![GitHub](https://jitpack.io/v/dxycw/multiplatform-zwkfb.svg)](https://jitpack.io/#dxycw/multiplatform-zwkfb)
[![Kotlin](https://img.shields.io/badge/kotlin-v2.3.20-blue.svg?logo=kotlin)](http://kotlinlang.org)
[![Compose Multiplatform](https://img.shields.io/badge/Compose%20Multiplatform-v1.10.3-blue)](https://github.com/JetBrains/compose-multiplatform)

![badge-android](http://img.shields.io/badge/platform-android-6EDB8D.svg?style=flat)
![badge-ios](http://img.shields.io/badge/platform-ios-CDCDCD.svg?style=flat)
![badge-desktop](http://img.shields.io/badge/platform-desktop-DB413D.svg?style=flat)
![badge-web](https://img.shields.io/badge/platform-web-59B6EC.svg?style=flat)

</div>


> [!NOTE]
> 
> 如果你使用的是Android平台的xml布局项目，请使用[zwkfb_view](https://github.com/dxycw/zwkfb_view)项目。


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
    implementation("com.github.dxycw.multiplatform-zwkfb:zwkfb:0.0.3")
    
    // 如果使用 Android Jetpack Compose，请添加以下依赖项
    implementation("com.github.dxycw.multiplatform-zwkfb:zwkfb-android:0.0.3")
    
    // 如果使用 Windows Jetpack Compose，请添加以下依赖项
    implementation("com.github.dxycw.multiplatform-zwkfb:zwkfb-jvm:0.0.3")
    
    // 以下平台可以用，但目前不推荐使用
    
    // 如果使用 IOS Jetpack Compose，请添加以下依赖项
    implementation("com.github.dxycw.multiplatform-zwkfb:zwkfb-iosarm64:0.0.3")
    implementation("com.github.dxycw.multiplatform-zwkfb:zwkfb-iossimulatorarm64:0.0.3")
    
    // 如果使用 Web Jetpack Compose，请添加以下依赖项
    implementation("com.github.dxycw.multiplatform-zwkfb:zwkfb-js:0.0.3")
    implementation("com.github.dxycw.multiplatform-zwkfb:zwkfb-wasm-js:0.0.3")
    
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

* 本项目所有平台[使用的依赖库](%E6%96%87%E6%A1%A3/%E4%BD%BF%E7%94%A8%E7%9A%84%E4%BE%9D%E8%B5%96%E5%BA%93.md)；

**5、示例代码：**

* 本项目所有平台[示例代码](https://gitee.com/dxycw/zwkfb-multiplatform#%E9%A1%B9%E7%9B%AE%E7%9B%AE%E5%BD%95)；

> [!CAUTION] 
>
>  * 项目>=0.0.2版本：
>     因为 org.jetbrains.compose 的 [1.11.0-alpha02](https://github.com/JetBrains/compose-multiplatform/releases/tag/v1.11.0-alpha02) 版本以后去掉了“x86_64”平台，所以本项目也去掉 了“x86_64”平台的依赖项，所以在项目中使用时去掉“x86_64”平台的依赖；
>
>     ```kotlin
>     listOf(
>     //    iosX64(),   // 去掉“x86_64”平台的依赖项，所以在项目中使用时去掉“x86_64”平台的依赖；
>         iosArm64(),
>         iosSimulatorArm64()
>     ).forEach { iosTarget ->
>         // 略
>     }



# 更新内容

## 0.0.3

* 优化 项目文档，完善使用方法、平台支持、依赖库等信息；
* 添加 Multiplatform平台的 “列()”、“行()”、“间隔器()”、两个“盒子()”、“选择容器()”、“禁用选择()”、两个“画布()”、两个“基础文本()” 函数组件；
* 添加 Multiplatform平台的 “是否系统深色主题()” 函数；
* 添加 Multiplatform平台的 “列范围”、“行范围”、“盒子范围” 接口类；
* 添加 Android平台的 ComponentActivity类的“置内容()” 函数；
* 添加 Android平台的 “本地活动” 属性函数；
* 更新 Multiplatform平台的 org.jetbrains.androidx.lifecycle:lifecycle-viewmodel-compose 依赖库版本为 2.11.0-alpha03；
* 更新 Multiplatform平台的 org.jetbrains.androidx.lifecycle:lifecycle-runtime-compose 依赖库版本为 2.11.0-alpha03；
* 添加 Multiplatform平台的 org.jetbrains.compose.material:material-icons-extended 依赖库版本为 1.7.3；
* 添加 Multiplatform平台的 org.jetbrains.androidx.navigation:navigation-compose 依赖库版本为 2.9.2；
* 添加 Android平台的 androidx.activity:activity-compose 依赖库版本为 1.13.0；

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
