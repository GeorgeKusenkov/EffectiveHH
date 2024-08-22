package com.egasmith.login.presentation.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.egasmith.login.presentation.state.InputState

@Composable
fun TrailingIcon(
    state: InputState,
    isFocused: Boolean,
    onClear: () -> Unit
) {
    if (state is InputState.Filled && state.input.isNotEmpty() && isFocused) {
        IconButton(onClick = onClear) {
            Icon(Icons.Default.Clear, contentDescription = "Clear text", tint = Color.White)
        }
    }
}
