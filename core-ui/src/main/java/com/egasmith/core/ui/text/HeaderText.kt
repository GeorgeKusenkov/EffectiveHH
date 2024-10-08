package com.egasmith.core.ui.text

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HeaderText(text: String) {
    Text(
        modifier = Modifier.padding(0.dp, 10.dp),
        text = text,
        fontSize = 20.sp,
        fontWeight = FontWeight.W600,
        color = MaterialTheme.colorScheme.onSurface
    )
}