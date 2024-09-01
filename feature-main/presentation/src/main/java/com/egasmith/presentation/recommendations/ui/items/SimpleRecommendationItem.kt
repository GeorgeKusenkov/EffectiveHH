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
import com.egasmith.presentation.R
import com.egasmith.presentation.recommendations.ui.text.RecommendationText

@Composable
fun SimpleRecommendationItem(
    id: String,
    text: String,
) {
    InfoBlock(
    modifier = Modifier.size(132.dp, 120.dp),
    contentPadding = PaddingValues(6.dp, 8.dp),
    content = {
        Column {
            RecommendationIcon(id)
            Spacer(Modifier.size(12.dp))
            RecommendationText(text)
        }
    })
}

@Composable
fun RecommendationIcon(id: String) {
    val icon = when(id) {
        "near_vacancies" -> R.drawable.ic_location
        "temporary_job" -> R.drawable.ic_not_full_job
        else -> R.drawable.ic_location
    }

    Icon(
        modifier = Modifier.size(32.dp),
        painter = painterResource(icon),
        contentDescription = id,
        tint = Color.Unspecified
    )

}

