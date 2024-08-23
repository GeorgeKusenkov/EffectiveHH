package com.egasmith.login.presentation.ui.blocks.auth

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
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

import com.egasmith.core.ui.theme.EffectiveMobileProjectHHTheme
import com.egasmith.login.R
import com.egasmith.login.presentation.ui.blocks.auth.components.EmailPhoneTextInput
import com.egasmith.login.presentation.ui.blocks.auth.components.AuthButtons
import com.egasmith.login.presentation.viewmodel.LoginViewModel

@Composable
fun AuthenticationBlock(loginViewModel: LoginViewModel = viewModel()) {
    val isInputValid by loginViewModel.isInputValid.collectAsState()

    InfoBlock(
        content = {
            Column {
                Spacer(modifier = Modifier.height(16.dp))

                SimpleTitle(stringResource(R.string.work_find))

                Spacer(modifier = Modifier.height(16.dp))

                EmailPhoneTextInput(loginViewModel)

                Spacer(modifier = Modifier.height(16.dp))

                AuthButtons(isInputValid, loginViewModel)

                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun AuthenticationBlockPreview() {
    EffectiveMobileProjectHHTheme {
        AuthenticationBlock()
    }
}