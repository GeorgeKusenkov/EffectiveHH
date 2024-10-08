package com.egasmith.core.ui.buttons

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.egasmith.core.ui.theme.Blue
import com.egasmith.core.ui.theme.DarkBlue
import com.egasmith.core.ui.theme.Gray

@Composable
fun BlueConfirmButton(
    modifier: Modifier = Modifier,
    text: String,
    isActive: Boolean = false,
    onClick: () -> Unit = {}
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            contentColor = if (isActive) Color.White else Gray,
            containerColor = if (isActive) Blue else DarkBlue
        ),
        shape = RoundedCornerShape(8.dp)
    ) {
        Text(text)
    }
}

@Preview(showBackground = true)
@Composable
fun NotActiveButtonPresent() {
    BlueConfirmButton(text = "Button", isActive = true)
}
