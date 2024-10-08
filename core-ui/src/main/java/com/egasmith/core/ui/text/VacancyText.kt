package com.egasmith.core.ui.text

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun VacancyText(text: String, color: Color = MaterialTheme.colorScheme.onSurface) {
    Text(
        text = text,
        fontSize = 16.sp,
        color = color,
        fontWeight = FontWeight.W500,
    )
}