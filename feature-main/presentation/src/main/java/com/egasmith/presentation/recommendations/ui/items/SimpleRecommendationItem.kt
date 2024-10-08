package com.egasmith.presentation.recommendations.ui.items

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.egasmith.core.ui.items.InfoBlock
import com.egasmith.presentation.recommendations.ui.text.RecommendationText

@Composable
fun SimpleRecommendationItem(
    text: String,
    icon: Int
) {
    InfoBlock(
        modifier = Modifier.size(132.dp, 120.dp),
        contentPadding = PaddingValues(6.dp, 8.dp),
        content = {
            Column {
                Icon(
                    painter = painterResource(icon),
                    contentDescription = null,
                    modifier = Modifier.size(32.dp),
                    tint = Color.Unspecified
                )
                Spacer(Modifier.size(12.dp))
                RecommendationText(text = text)
            }
        }
    )
}

