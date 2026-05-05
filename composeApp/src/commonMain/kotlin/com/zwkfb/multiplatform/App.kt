package com.zwkfb.multiplatform

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import compose.multiplatform.zwkfb.Greeting
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.painterResource
import zwkfbmultiplatform.composeapp.generated.resources.Res
import zwkfbmultiplatform.composeapp.generated.resources.compose_multiplatform
import 安卓x.组合.动画.动画可见性
import 安卓x.组合.基础.图像
import 安卓x.组合.基础.布局.列
import 安卓x.组合.材质3.卡片
import 安卓x.组合.材质3.凸起卡片
import 安卓x.组合.材质3.轮廓卡片
import 安卓x.组合.材质3.图标
import 安卓x.组合.材质3.图标按钮
import 安卓x.组合.材质3.按钮
import 安卓x.组合.材质3.文本
import 安卓x.组合.材质3.材质主题
import 安卓x.组合.材质3.水平分隔线
import 安卓x.组合.材质3.脚手架



@Composable
@Preview
fun App(内容: @Composable () -> Unit = {  }) {
    材质主题 {
        val 状态 = remember { SnackbarHostState() }
        脚手架(
            顶部栏 = {
                TopAppBar(
                    title = { 文本("灵阁") },
                    navigationIcon = {
                        图标按钮(
                            单击回调 = {},
                            颜色集 = IconButtonColors(
                                containerColor = Color.White,
                                contentColor = Color.Unspecified,
                                disabledContainerColor = Color.Transparent,
                                disabledContentColor = Color.Unspecified
                            )
                        ){
                            图标(
                                绘制器 = painterResource(Res.drawable.compose_multiplatform),
                                内容描述 = null,
                                修饰符 = Modifier.size(40.dp),
                                色调 = Color.Unspecified
                            )
                        }
                    },
                    actions = {
                        按钮(单击回调 = {  }) { 文本("Click me!") }
                    }
                )
            },
            提示条主机 = {
                SnackbarHost(
                    hostState = 状态,
                )
                rememberCoroutineScope().launch {
                    状态.showSnackbar(
                        message = "Hello, World!",
                        actionLabel = "Dismiss"
                    )
                }

            }
        ){ 内边距 ->
            var showContent by remember { mutableStateOf(false) }
            列(
                修饰符 = Modifier.padding(内边距)
                    .background(color = Color.White)
                    .safeContentPadding().fillMaxSize()
                    .verticalScroll(rememberScrollState()),
                水平对齐 = Alignment.CenterHorizontally,
            ) {
                按钮(单击回调 = { showContent = !showContent }) { 文本("Click me!") }
                水平分隔线()
                val greeting = remember { Greeting().greet() }
                动画可见性(showContent) {

                    列(
                        修饰符 = Modifier.fillMaxWidth(),
                        水平对齐 = Alignment.CenterHorizontally,
                    ) {
                        图像(
                            绘制器 = painterResource(Res.drawable.compose_multiplatform),
                            内容描述 = null,
                            修饰符 = Modifier.size(200.dp)
                        )
                        文本("Compose: $greeting")
                    }
                }

                卡片(修饰符 = Modifier.padding(16.dp)) {
                    列(
                        修饰符 = Modifier.padding(16.dp),
                        水平对齐 = Alignment.CenterHorizontally,
                    ) {
                        文本("Compose: $greeting")
                    }
                }

                凸起卡片(修饰符 = Modifier.padding(16.dp)) {
                    列(
                        修饰符 = Modifier.padding(16.dp),
                        水平对齐 = Alignment.CenterHorizontally,
                    ) {
                        文本("Compose: $greeting")
                    }
                }

                轮廓卡片(修饰符 = Modifier.padding(16.dp)) {
                    列(
                        修饰符 = Modifier.padding(16.dp),
                        水平对齐 = Alignment.CenterHorizontally,
                    ) {
                        文本("Compose: $greeting")
                    }
                }

                内容()

            }

        }

    }
}

