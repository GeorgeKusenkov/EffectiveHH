package com.egasmith.core.ui.text

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

@Composable
fun GrayText(text: String) {
    Text(
        text = text,
        fontSize = 14.sp,
        color = Color(0xFF9F9F9F) // Серый цвет
    )
}