package com.egasmith.presentation.searchbar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.egasmith.core.ui.items.InfoBlock
import com.egasmith.core.ui.theme.EffectiveMobileProjectHHTheme
import com.egasmith.core.ui.theme.LightGray
import com.egasmith.presentation.R

@Composable
fun Filter() {
    InfoBlock(
        modifier = Modifier.size(50.dp),
        content = {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_filter),
                    contentDescription = "filter icon",
                    tint = Color.Unspecified
                )
            }
        },
        cardColor = LightGray
    )
}

@Preview(showBackground = true)
@Composable
fun FilterPreview() {
    EffectiveMobileProjectHHTheme {
        Filter()
    }
}