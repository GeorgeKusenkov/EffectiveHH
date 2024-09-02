package com.egasmith.presentation.recommendations

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.egasmith.core.common.UiState
import com.egasmith.core.ui.items.ErrorText
import com.egasmith.core.ui.items.ShowCircularIndicator
import com.egasmith.core.ui.theme.EffectiveMobileProjectHHTheme
import com.egasmith.presentation.recommendations.ui.RecommendationItem
import com.egasmith.presentation.recommendations.ui.items.RecommendationItemWithButton
import com.egasmith.presentation.recommendations.ui.items.RecommendationItemWithTextAndLink
import com.egasmith.presentation.recommendations.ui.items.SimpleRecommendationItem

@Composable
fun RecommendationsScreen(viewModel: RecommendationsViewModel = hiltViewModel()) {

    val recommendationsState by viewModel.recommendations.collectAsState()

    when (val state = recommendationsState) {
        is UiState.Loading -> ShowCircularIndicator()
        is UiState.Success -> RecommendationsList(state.data)
        is UiState.Error -> ErrorText(state)
    }
}

@Composable
fun RecommendationsList(recommendations: List<RecommendationItem>) {
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(vertical = 10.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(recommendations) { recommendation ->
            when (recommendation) {
                is RecommendationItem.WithIconAndButton -> {
                    RecommendationItemWithButton(
                        text = recommendation.text,
                        buttonText = recommendation.buttonText,
                        icon = recommendation.icon,
                        link = recommendation.link,
                        description = "Recommendation icon"
                    )
                }

                is RecommendationItem.WithIcon -> {
                    SimpleRecommendationItem(
                        text = recommendation.text,
                        icon = recommendation.icon
                    )
                }

                is RecommendationItem.WithTextAndLink -> {
                    RecommendationItemWithTextAndLink(
                        text = recommendation.text,
                        link = recommendation.link
                    )
                }
            }
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