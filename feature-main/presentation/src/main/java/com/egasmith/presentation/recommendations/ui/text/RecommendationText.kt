package com.egasmith.presentation.recommendations.ui.text

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun RecommendationText(modifier: Modifier = Modifier, text: String) {
    Text(
        modifier = modifier,
        text = text.trimStart(),
        fontWeight = FontWeight.W500,
        lineHeight = 18.sp,
        fontSize = 12.sp
    )
}