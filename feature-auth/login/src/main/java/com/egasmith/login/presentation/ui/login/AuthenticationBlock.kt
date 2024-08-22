package com.egasmith.login.presentation.ui.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.egasmith.core.ui.SimpleTitle
import com.egasmith.core.ui.InfoBlock
import com.egasmith.core.ui.NoBackgroundResponseButton
import com.egasmith.core.ui.ResponseButton
import com.egasmith.core.ui.theme.EffectiveMobileProjectHHTheme
import com.egasmith.login.R
import com.egasmith.login.presentation.state.InputState
import com.egasmith.login.presentation.ui.components.EmailPhoneTextInput
import com.egasmith.login.presentation.viewmodel.LoginViewModel

@Composable
fun AuthenticationBlock(loginViewModel: LoginViewModel = viewModel()) {
    val state by loginViewModel.state.collectAsState()
    val isInputValid = state is InputState.Filled && (state as InputState.Filled).isValid

    InfoBlock(
        content = {
            Column {
                Spacer(modifier = Modifier.height(16.dp))
                SimpleTitle(stringResource(R.string.work_find))
                Spacer(modifier = Modifier.height(16.dp))
                EmailPhoneTextInput(loginViewModel)
                Spacer(modifier = Modifier.height(16.dp))
                AuthButtons(isInputValid)
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    )
}

@Composable
private fun AuthButtons(isEmailValid: Boolean) {
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        ResponseButton(
            text = stringResource(R.string.next),
            modifier = Modifier.weight(1f),
            isActive = isEmailValid,
            onClick = { /* Implement navigation here */ }
        )
        NoBackgroundResponseButton(
            text = stringResource(R.string.enter_with_pass),
            modifier = Modifier.weight(1f)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AuthenticationBlockPreview() {
    EffectiveMobileProjectHHTheme {
        AuthenticationBlock()
    }
}