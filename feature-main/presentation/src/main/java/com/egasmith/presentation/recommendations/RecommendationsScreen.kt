package com.egasmith.presentation.recommendations

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.egasmith.presentation.R
import com.egasmith.core.ui.theme.EffectiveMobileProjectHHTheme
import com.egasmith.presentation.recommendations.ui.items.SimpleRecommendationItem
import com.egasmith.presentation.recommendations.ui.items.SimpleRecommendationItemWithAction

@Composable
fun  RecommendationsScreen() {
    LazyRow(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(vertical = 10.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        item {
            SimpleRecommendationItem(
                text = "Вакансии рядом с вами",
                icon = R.drawable.ic_location,
                description = "location icon"
            )
        }

        item {
            SimpleRecommendationItemWithAction(
                text = "Поднять резюме в поиске",
                icon = R.drawable.ic_resume_up,
                description = "location icon"
            )
        }

        item {
            SimpleRecommendationItem(
                text = "Временная работа и подработка",
                icon = R.drawable.ic_not_full_job,
                description = "location icon"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RecommendationsScreenPreview() {
    EffectiveMobileProjectHHTheme {
        RecommendationsScreen()
    }
}