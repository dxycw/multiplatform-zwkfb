package com.zwkfb.multiplatform

import androidx.compose.ui.Alignment
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import compose.multiplatform.zwkfb.a


fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        state = rememberWindowState(
            position = WindowPosition.Aligned(Alignment.Center),
        ),
        title = "灵阁",
//        icon = rememberVectorPainter(Icons.Default.Add),
    ) {
        App(){
            a()
        }
    }
}

