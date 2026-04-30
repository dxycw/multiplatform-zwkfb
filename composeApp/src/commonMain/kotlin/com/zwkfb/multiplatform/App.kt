package com.zwkfb.multiplatform

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import compose.multiplatform.zwkfb.Greeting
import org.jetbrains.compose.resources.imageResource
import org.jetbrains.compose.resources.painterResource
import zwkfbmultiplatform.composeapp.generated.resources.Res
import zwkfbmultiplatform.composeapp.generated.resources.compose_multiplatform
import 安卓x.组合.动画.动画可见性
import 安卓x.组合.基础.布局.列
import 安卓x.组合.材质3.按钮
import 安卓x.组合.材质3.文本
import 安卓x.组合.材质3.水平分隔线
import 安卓x.组合.材质3.脚手架


@Composable
@Preview
fun App() {
    MaterialTheme {
        脚手架(
            顶部栏 = {
                TopAppBar(
                    title = { 文本("灵阁") },
                    navigationIcon = {
                        Image(
                            painter = painterResource(Res.drawable.compose_multiplatform),
                            contentDescription = null,
                            modifier = Modifier.size(40.dp)
                        )
                    },
                    actions = {
                        按钮(单击回调 = {  }) {
                            文本("Click me!")
                        }
                    }
                )
            }
        ){ 内边距 ->
            var showContent by remember { mutableStateOf(false) }
            列(
                修饰符 = Modifier.padding(内边距)
                    .background(color = Color.White)
                    .safeContentPadding().fillMaxSize(),
                水平对齐 = Alignment.CenterHorizontally,
            ) {
                按钮(
                    单击回调 = { showContent = !showContent }
                ) { 文本("Click me!") }
                水平分隔线()
                文本("Click me!")
                动画可见性(showContent) {
                    val greeting = remember { Greeting().greet() }
                    列(
                        修饰符 = Modifier.fillMaxWidth(),
                        水平对齐 = Alignment.CenterHorizontally,
                    ) {
                        Image(
                            painter = painterResource(Res.drawable.compose_multiplatform),
                            contentDescription = null,
                            modifier = Modifier.size(200.dp)
                        )

                        文本("Compose: $greeting")
                    }
                }

            }
        }

    }
}

