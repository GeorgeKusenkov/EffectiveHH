package com.egasmith.core.ui.text

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.egasmith.core.ui.theme.Blue
import com.egasmith.core.ui.theme.Green

@Composable
fun ColoredText(
    modifier: Modifier = Modifier,
    text: String,
    isGreen: Boolean = true,
    fontSize: TextUnit = 16.sp
) {
    val color = if (isGreen) Green else Blue // Зеленый или синий цвет
    Text(
        modifier = modifier,
        text = text,
        fontSize = fontSize,
        color = color
    )
}