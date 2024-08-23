package com.egasmith.core.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.egasmith.core.ui.theme.EffectiveMobileProjectHHTheme

@Composable
fun SimpleTitle(text: String) {
    Text(
        text = text,
        color = Color.White,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold
    )
}

@Preview(showBackground = true)
@Composable
fun BlockTitlePreview() {
    EffectiveMobileProjectHHTheme {
        SimpleTitle("Button")
    }
}