package com.egasmith.core.ui.text

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp
import com.egasmith.core.ui.theme.Blue
import com.egasmith.core.ui.theme.Green

@Composable
fun ColoredText(text: String, isGreen: Boolean = true) {
    val color = if (isGreen) Green else Blue // Зеленый или синий цвет
    Text(
        text = text,
        fontSize = 14.sp,
        color = color
    )
}