package com.egasmith.core.ui.buttons

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.egasmith.core.ui.theme.Green

@Composable
fun GreenConfirmButton(
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    Button(
        modifier = modifier.fillMaxWidth(),
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            contentColor = Color.White,
            containerColor = Green
        )
    ) {
        Text(text)
    }
}

@Preview(showBackground = true)
@Composable
fun ConfirmButtonPreview() {
    GreenConfirmButton("Button", onClick = {})
}