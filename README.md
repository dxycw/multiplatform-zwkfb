# Multiplatform-Zwkfb

[![](https://jitpack.io/v/dxycw/multiplatform-zwkfb.svg)](https://jitpack.io/#dxycw/multiplatform-zwkfb)

本项目使用Jetpack Compose Multiplatform开发的中文开发包项目，适用于多平台Jetpack Compose Multiplatform版。
如果你使用的的是xml布局项目，请使用[zwkfb_view](https://github.com/dxycw/zwkfb_view)。

# 使用方法

1、在项目的 settings.gradle 文件中添加 JitPack 仓库：

```kotlin
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        mavenCentral()
        maven { url = uri("https://jitpack.io") }  // 添加 JitPack 仓库
    }
}
```

2、在项目的 build.gradle 文件中添加依赖项：

```kotlin
dependencies {
    
    // 如果使用多平台Jetpack Compose Multiplatform，请添加以下依赖项
    implementation("com.github.dxycw.multiplatform-zwkfb:zwkfb:0.0.1")
    
    // 如果使用 Android Jetpack Compose，请添加以下依赖项
    implementation("com.github.dxycw.multiplatform-zwkfb:zwkfb-android:0.0.1")
    
    // 如果使用 Windows Jetpack Compose，请添加以下依赖项
    implementation("com.github.dxycw.multiplatform-zwkfb:zwkfb-jvm:0.0.1")
    
    //其他平台暂定...
    
}
```

3、使用的平台：

| 平台          | 是否可用     |
| ------------- |----------|
| Multiplatform | ✅️       |
| Android       | ✅️       |
| Windows       | ✅️      |
| IOS           | ❌️       |
| MacOS         | ❌️       |
| Web           | ❌️       |

# 更新内容

## 0.0.1

* 创建项目，发布第一个版本；
