package com.egasmith.presentation.vacancydetails.ui.components.appbar

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.egasmith.presentation.R

@Composable
fun TopAppBar(onBackClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {

        //На предыдщий экран
        TopBarIcon(
            icon = R.drawable.ic_arrow_back,
            description = "arrow back",
            modifier = Modifier.clickable {
                onBackClick()
            }
        )
        Spacer(Modifier.weight(1f))
        TopBarIcon(icon = R.drawable.ic_eye, description = "eye icon")
        Spacer(Modifier.size(18.dp))
        TopBarIcon(icon = R.drawable.ic_share, description = "share icon")
        Spacer(Modifier.size(18.dp))
        TopBarIcon(icon = com.egasmith.core.ui.R.drawable.ic_is_favorite_filled, description = "ic_is_favorite_filled")
    }
}


