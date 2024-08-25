package com.egasmith.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.egasmith.core.ui.theme.EffectiveMobileProjectHHTheme

@Composable
fun TopAppBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {

        TopBarIcon(icon = R.drawable.ic_arrow_back, description = "arrow back")
        Spacer(Modifier.weight(1f))
        TopBarIcon(icon = R.drawable.ic_eye, description = "ic_eye")
        TopBarIcon(icon = R.drawable.ic_share, description = "ic_share")
        TopBarIcon(icon = com.egasmith.core.ui.R.drawable.ic_is_favorite_filled, description = "ic_is_favorite_filled")
    }

}

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

@Preview(showBackground = true)
@Composable
fun TopAppBarPreview() {
    EffectiveMobileProjectHHTheme {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            containerColor = Color(0xFF0C0C0C),
        ) { innerPadding ->
            TopAppBar()
        }

    }
}