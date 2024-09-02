package com.egasmith.presentation.recommendations.ui.items

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.unit.dp
import com.egasmith.core.ui.items.InfoBlock
import com.egasmith.presentation.recommendations.ui.text.RecommendationText

@Composable
fun RecommendationItemWithTextAndLink(text: String, link: String) {
    val uriHandler = LocalUriHandler.current
    InfoBlock(
        modifier = Modifier.size(132.dp, 120.dp),
        contentPadding = PaddingValues(6.dp, 8.dp),
        content = {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                RecommendationText(
                    text = text,
                    modifier = Modifier.clickable {
                        uriHandler.openUri(link)
                    }
                )
            }
        }
    )
}