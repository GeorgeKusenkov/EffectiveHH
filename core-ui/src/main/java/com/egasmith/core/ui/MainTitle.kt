package com.egasmith.core.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun MainTitle(text: String) {
    Text(
        text = text,
        color = Color.White,
        fontSize = 20.pxToSp()
    )
}