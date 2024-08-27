package com.egasmith.presentation.vacancydetails.ui.components.appbar

import androidx.compose.foundation.clickable
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource

@Composable
fun TopBarIcon(modifier: Modifier = Modifier, icon: Int, description: String) {
    Icon(
        modifier = modifier
            .clickable {

            },
        painter = painterResource(icon),
        contentDescription = description,
        tint = Color.Unspecified
    )
}