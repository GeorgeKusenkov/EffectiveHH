package com.egasmith.presentation.modalscreen

import androidx.compose.runtime.Composable
import com.egasmith.core.ui.buttons.GreenConfirmButton

@Composable
fun ConfirmButton(text: String, onClick: () -> Unit) {
    GreenConfirmButton(
        text = text,
        onClick = onClick
    )
}