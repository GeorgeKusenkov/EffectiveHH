package com.egasmith.core.ui.text

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun ProfessionTitleText(text: String) {
    Text(
        text = text,
        fontSize = 22.sp,
        fontWeight = FontWeight.W600,
        color = MaterialTheme.colorScheme.onSurface
    )
}