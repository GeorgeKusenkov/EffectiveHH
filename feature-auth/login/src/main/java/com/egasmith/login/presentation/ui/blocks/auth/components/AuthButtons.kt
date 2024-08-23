package com.egasmith.login.presentation.ui.blocks.auth.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.egasmith.core.ui.BlueConfirmButton
import com.egasmith.core.ui.NoBackgroundResponseButton
import com.egasmith.login.R
import com.egasmith.login.presentation.viewmodel.LoginViewModel


@Composable
fun AuthButtons(isInputValid: Boolean, loginViewModel: LoginViewModel) {
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        BlueConfirmButton(
            text = stringResource(R.string.next),
            modifier = Modifier.weight(1f),
            isActive = isInputValid,
            onClick = {
                loginViewModel.onContinueClick()
                if (isInputValid) {
                    // Навигация на экран "Вход 2"
                }
            }
        )
        NoBackgroundResponseButton(
            text = stringResource(R.string.enter_with_pass),
            modifier = Modifier.weight(1f)
        )
    }
}