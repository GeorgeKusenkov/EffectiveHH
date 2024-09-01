package com.egasmith.presentation.recommendations.ui.text

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.egasmith.core.ui.text.StandardText

@Composable
fun RecommendationText(text: String) {
    StandardText(
        text = text.trimStart(),
        fontWeight = FontWeight.W500,
        lineHeight = 18.sp,
        fontSize = 12.sp
    )
}