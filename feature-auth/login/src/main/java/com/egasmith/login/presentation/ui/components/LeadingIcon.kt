package com.egasmith.login.presentation.ui.components

import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.egasmith.login.R
import com.egasmith.login.presentation.state.InputState

@Composable
fun LeadingIcon(state: InputState, isFocused: Boolean): (@Composable () -> Unit)? {
    return if (state is InputState.Empty && !isFocused) {
        {
            Icon(
                painter = painterResource(id = R.drawable.ic_email),
                contentDescription = "Email icon",
                tint = com.egasmith.effectivemobileprojecthh.ui.theme.TintGray
            )
        }
    } else null
}