package com.egasmith.core.ui

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.egasmith.core.ui.theme.DarkBlue


@Composable
fun NoBackgroundResponseButton(modifier: Modifier = Modifier, text: String) {
    Button(
        onClick = {},
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            contentColor = DarkBlue,
            containerColor = Color.Transparent
        ),
        shape = RoundedCornerShape(8.dp)
    ) {
        Text(text)
    }
}
