package com.egasmith.register.presentation.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.unit.dp

@Composable
fun CodeInputField(
    verificationCode: MutableState<List<String>>,
    digitFieldFocusControllers: List<FocusRequester>,
    onCodeComplete: () -> Unit
) {
    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        verificationCode.value.forEachIndexed { index, digit ->
            CodeDigitInput(
                value = digit,
                onValueChange = { newDigit ->
                    updateCodeState(verificationCode, index, newDigit)
                    changeFocusIfNeeded(newDigit, index, digitFieldFocusControllers, onCodeComplete)
                },
                digitFieldFocusController = digitFieldFocusControllers[index],
                onBackspace = { moveToPreviousField(index, digitFieldFocusControllers) }
            )
        }
    }
}

private fun updateCodeState(codeState: MutableState<List<String>>, index: Int, newDigit: String) {
    if (newDigit.length == 1 && newDigit.all { it.isDigit() }) {
        codeState.value = codeState.value.toMutableList().also { it[index] = newDigit }
    }
}

private fun changeFocusIfNeeded(
    newDigit: String,
    index: Int,
    digitFieldFocusController: List<FocusRequester>,
    onCodeComplete: () -> Unit
) {
    when {
        newDigit.isNotEmpty() && index < digitFieldFocusController.lastIndex -> {
            digitFieldFocusController[index + 1].requestFocus()
        }
        index == digitFieldFocusController.lastIndex -> {
            onCodeComplete()
        }
    }
}

private fun moveToPreviousField(index: Int, digitFieldFocusControllers: List<FocusRequester>) {
    if (index > 0) {
        digitFieldFocusControllers[index - 1].requestFocus()
    }
}