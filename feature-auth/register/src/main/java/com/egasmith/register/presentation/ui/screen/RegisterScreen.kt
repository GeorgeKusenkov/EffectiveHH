package com.egasmith.register.presentation.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.egasmith.core.ui.theme.EffectiveMobileProjectHHTheme
import androidx.compose.ui.platform.LocalFocusManager
import com.egasmith.core.ui.buttons.BlueConfirmButton
import com.egasmith.core.ui.text.HeaderText
import com.egasmith.core.ui.theme.Black
import com.egasmith.register.presentation.ui.components.CodeInputField

@Composable
fun RegisterScreen(modifier: Modifier = Modifier) {
    val verificationCode = remember { mutableStateOf(List(4) { "" }) }
    val digitFieldFocusControllers = List(4) { FocusRequester() }
    val keyboardFocusManager = LocalFocusManager.current
    val columnModifier = modifier
        .fillMaxSize()
        .padding(16.dp)

    Column(
        modifier = columnModifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {
        HeaderText("Отправили код на example@mail.ru")

        Spacer(Modifier.height(16.dp))

        Text(
            text = "Напишите его, чтобы подтвердить, что это вы, а не кто-то другой входит в личный кабинет",
        )

        Spacer(Modifier.height(12.dp))

        CodeInputField(
            verificationCode = verificationCode,
            digitFieldFocusControllers = digitFieldFocusControllers,
            onCodeComplete = { keyboardFocusManager.clearFocus() }
        )

        Spacer(Modifier.height(24.dp))

        BlueConfirmButton(
            text = "Подтвердить",
            isActive = verificationCode.value.all { it.isNotEmpty() },
            modifier = Modifier.fillMaxWidth()
        )
    }

    LaunchedEffect(Unit) {
        digitFieldFocusControllers.first().requestFocus()
    }
}

@Preview(showBackground = true)
@Composable
fun EmailTextInputPreview() {
    EffectiveMobileProjectHHTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Black
        ) {
            RegisterScreen()
        }
    }
}
