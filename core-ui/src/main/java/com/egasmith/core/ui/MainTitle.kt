package com.egasmith.core.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun MainTitle(modifier: Modifier = Modifier, text: String, fontWeight: FontWeight = FontWeight.Normal) {
    Text(
        modifier = modifier,
        text = text,
        color = Color.White,
        fontSize = 20.sp,
        fontWeight = fontWeight
    )
}