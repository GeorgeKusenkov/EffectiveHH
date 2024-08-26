package com.egasmith.login.presentation.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.egasmith.core.ui.text.HeaderText
import com.egasmith.core.ui.theme.EffectiveMobileProjectHHTheme
import com.egasmith.login.R
import com.egasmith.login.presentation.ui.blocks.auth.components.EmailPhoneTextInput
import com.egasmith.login.presentation.ui.blocks.auth.AuthenticationBlock
import com.egasmith.login.presentation.ui.blocks.empoyeesearch.EmployeeSearchBlock

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    onContinueClick: (String) -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(0.dp, 25.dp),
        verticalArrangement = Arrangement.Top,
    ) {
        Spacer(modifier = Modifier.size(20.dp))
        HeaderText(text = stringResource(id = R.string.login_to_account))
        Spacer(modifier = Modifier.weight(1f))
        AuthenticationBlock(
            onContinueClick = { email ->
                onContinueClick(email)
            }
        )
        Spacer(modifier = Modifier.size(20.dp))
        EmployeeSearchBlock()
        Spacer(modifier = Modifier.weight(1f))
    }
}

@Preview(showBackground = true)
@Composable
fun EmailTextInputPreview() {
    EffectiveMobileProjectHHTheme {
        EmailPhoneTextInput()
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    EffectiveMobileProjectHHTheme {
//        LoginScreen()
    }
}