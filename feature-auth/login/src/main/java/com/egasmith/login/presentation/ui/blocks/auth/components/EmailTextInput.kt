package com.egasmith.login.presentation.ui.blocks.auth.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.egasmith.core.ui.theme.EffectiveMobileProjectHHTheme
import com.egasmith.core.ui.theme.LightGray
import com.egasmith.core.ui.theme.TintGray
import com.egasmith.login.presentation.state.InputState
import com.egasmith.login.presentation.viewmodel.LoginViewModel

@Composable
fun EmailPhoneTextInput(
    loginViewModel: LoginViewModel = viewModel()
) {
    val state by loginViewModel.state.collectAsState()
    val showError by loginViewModel.showError.collectAsState()
    val isFocused = remember { mutableStateOf(false) }
    val focusManager = LocalFocusManager.current

    Column {
        OutlinedTextField(
            value = getInputFieldValue(state),
            onValueChange = { loginViewModel.onInputChanged(it) },
            label = { Text(text = "Электронная почта или телефон", fontSize = 13.sp) },
            modifier = Modifier.textInputModifier(isFocused),
            keyboardOptions = TextInputKeyboardOptions(),
            leadingIcon = LeadingIcon(state, isFocused.value),
            trailingIcon = {
                TrailingIcon(state, isFocused.value, onClear = {
                    loginViewModel.onClearClick()
                    focusManager.clearFocus()
                })
            },
            colors = textFieldColors(showError),
            shape = RoundedCornerShape(14.dp),
            isError = showError
        )
        if (showError) {
            Text(
                text = "Вы ввели неверный e-mail или телефон",
                color = Color.Red,
                fontSize = 12.sp,
                modifier = Modifier.padding(start = 16.dp, top = 4.dp)
            )
        }
    }
}

@Composable
private fun Modifier.textInputModifier(isFocused: MutableState<Boolean>): Modifier =
    this
        .fillMaxWidth()
        .onFocusChanged { focusState ->
            isFocused.value = focusState.isFocused
        }
        .background(
            color = LightGray,
            shape = RoundedCornerShape(14.dp)
        )

@Composable
private fun TextInputKeyboardOptions() = KeyboardOptions(
    capitalization = KeyboardCapitalization.None,
    autoCorrect = false,
    keyboardType = KeyboardType.Email,
    imeAction = ImeAction.Next
)

@Composable
private fun getInputFieldValue(state: InputState): String {
    return when (state) {
        is InputState.Empty -> ""
        is InputState.Filled -> state.input
    }
}

@Composable
private fun textFieldColors(isError: Boolean) = OutlinedTextFieldDefaults.colors(
    focusedBorderColor = if (isError) Color.Red else Color.Transparent,
    unfocusedBorderColor = if (isError) Color.Red else Color.Transparent,
    disabledBorderColor = Color.Transparent,
    cursorColor = Color.White,
    focusedTextColor = Color.White,
    unfocusedTextColor = TintGray,
    unfocusedLabelColor = TintGray,
    focusedLabelColor = TintGray,
    errorBorderColor = Color.Red,
    errorLabelColor = Color.Red,
    errorCursorColor = Color.Red,
    errorTextColor = Color.White
)

@Preview(showBackground = true)
@Composable
fun EmailTextInputPreview() {
    EffectiveMobileProjectHHTheme {
        EmailPhoneTextInput()
    }
}