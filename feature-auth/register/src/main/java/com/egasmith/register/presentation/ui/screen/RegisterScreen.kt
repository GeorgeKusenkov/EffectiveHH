package com.egasmith.register.presentation.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.unit.dp
import androidx.compose.ui.platform.LocalFocusManager
import com.egasmith.core.ui.buttons.BlueConfirmButton
import com.egasmith.core.ui.text.HeaderText
import com.egasmith.register.presentation.ui.components.CodeInputField
import kotlinx.coroutines.delay

@Composable
fun RegisterScreen(
    email: String,
    onConfirmClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val verificationCode = remember { mutableStateOf(List(4) { "" }) }
    val digitFieldFocusRequesters = remember { List(4) { FocusRequester() } }
    val keyboardFocusManager = LocalFocusManager.current
    val columnModifier = modifier
        .fillMaxSize()
        .padding(16.dp)

    Column(
        modifier = columnModifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {
        HeaderText("Отправили код на $email")

        Spacer(Modifier.height(16.dp))

        Text(
            text = "Напишите его, чтобы подтвердить, что это вы, а не кто-то другой входит в личный кабинет",
        )

        Spacer(Modifier.height(12.dp))

        CodeInputField(
            verificationCode = verificationCode,
            digitFieldFocusControllers = digitFieldFocusRequesters,
            onCodeComplete = { keyboardFocusManager.clearFocus() }
        )

        Spacer(Modifier.height(24.dp))

        BlueConfirmButton(
            text = "Подтвердить",
            isActive = verificationCode.value.all { it.isNotEmpty() },
            modifier = Modifier.fillMaxWidth(),
            onClick = onConfirmClick
        )
    }

    LaunchedEffect(Unit) {
        delay(100)
        digitFieldFocusRequesters.firstOrNull()?.requestFocus()
    }
}