package com.egasmith.core.ui

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.egasmith.effectivemobileprojecthh.ui.theme.Blue
import com.egasmith.effectivemobileprojecthh.ui.theme.DarkBlue
import com.egasmith.effectivemobileprojecthh.ui.theme.Gray

@Composable
fun ResponseButton(
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
    ResponseButton(text = "Button", isActive = true)
}
