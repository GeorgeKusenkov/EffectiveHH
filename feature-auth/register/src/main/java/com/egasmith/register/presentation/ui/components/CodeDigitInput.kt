package com.egasmith.register.presentation.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.egasmith.effectivemobileprojecthh.ui.theme.LightGray
import com.egasmith.effectivemobileprojecthh.ui.theme.TintGray

@Composable
fun CodeDigitInput(
    value: String,
    onValueChange: (String) -> Unit,
    digitFieldFocusController: FocusRequester,
    onBackspace: () -> Unit
) {
    val isFocused = remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .size(width = 48.dp, height = 56.dp)
            .background(LightGray, RoundedCornerShape(8.dp))
            .focusRequester(digitFieldFocusController)
            .onFocusChanged { isFocused.value = it.isFocused },
        contentAlignment = Alignment.Center
    ) {
        if (value.isEmpty() && !isFocused.value) {
            Text(text = "*", color = Color.Gray, fontSize = 20.sp)
        }

        BasicTextField(
            cursorBrush = SolidColor(TintGray),
            value = value,
            onValueChange = onValueChange,
            singleLine = true,
            modifier = Modifier
                .fillMaxSize()
                .onKeyEvent { keyEvent ->
                    if (keyEvent.key == Key.Backspace && value.isEmpty()) {
                        onBackspace()
                        true
                    } else {
                        false
                    }
                },
            textStyle = TextStyle(
                color = Color.White,
                fontSize = 20.sp,
                textAlign = TextAlign.Center
            ),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            decorationBox = { innerTextField ->
                Box(contentAlignment = Alignment.Center) { innerTextField() }
            }
        )
    }
}