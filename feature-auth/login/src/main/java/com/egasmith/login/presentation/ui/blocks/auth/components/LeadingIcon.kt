package com.egasmith.login.presentation.ui.blocks.auth.components

import com.egasmith.core.ui.theme.TintGray

import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.egasmith.login.presentation.state.InputState
import com.egasmith.core.ui.R

@Composable
fun LeadingIcon(state: InputState, isFocused: Boolean): (@Composable () -> Unit)? {
    return if (state is InputState.Empty && !isFocused) {
        {
            Icon(
                painter = painterResource(id = R.drawable.ic_email),
                contentDescription = "Email icon",
                tint = TintGray
            )
        }
    } else null
}