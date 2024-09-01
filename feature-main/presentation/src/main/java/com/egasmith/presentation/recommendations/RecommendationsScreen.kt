package com.egasmith.presentation.recommendations

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.egasmith.core.common.UiState
import com.egasmith.core.ui.items.ErrorText
import com.egasmith.core.ui.items.InfoBlock
import com.egasmith.core.ui.items.ShowCircularIndicator
import com.egasmith.presentation.R
import com.egasmith.core.ui.theme.EffectiveMobileProjectHHTheme
import com.egasmith.core.ui.theme.Green
import com.egasmith.domain.model.Recommendation
import com.egasmith.presentation.recommendations.ui.items.SimpleRecommendationItem
import com.egasmith.presentation.recommendations.ui.items.SimpleRecommendationItemWithButton
import com.egasmith.presentation.recommendations.ui.text.RecommendationText

@Composable
fun  RecommendationsScreen(viewModel: RecommendationsViewModel = hiltViewModel()) {

    val recommendationsState by viewModel.recommendations.collectAsState()

    when (val state = recommendationsState) {
        is UiState.Loading -> ShowCircularIndicator()
        is UiState.Success -> RecommendationsList(state.data)
        is UiState.Error -> ErrorText(state)
    }
}

@Composable
fun RecommendationsList(recommendations: List<Recommendation>) {
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(vertical = 10.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(recommendations) { recommendation ->
            if (recommendation.id != null) {
                if (recommendation.buttonText != null) {
                    RecommendationItemWithButton(
                        text = truncateText(recommendation.title, 2),
                        buttonText = recommendation.buttonText ?: "",
                        icon = R.drawable.ic_resume_up,
                        link = recommendation.link,
                        description = "Recommendation icon"
                    )
                } else {
                    SimpleRecommendationItem(
                        id = recommendation.id ?: "",
                        text = truncateText(recommendation.title, 3),
                    )
                }
            }
        }
    }
}

@Composable
fun RecommendationItemWithButton(
    text: String,
    buttonText: String,
    icon: Int,
    link: String,
    description: String
) {
    val uriHandler = LocalUriHandler.current

    InfoBlock(
        modifier = Modifier.size(132.dp, 120.dp),
        contentPadding = PaddingValues(6.dp, 8.dp),
        content = {
            Column {
                Icon(
                    modifier = Modifier.size(32.dp),
                    painter = painterResource(icon),
                    contentDescription = description,
                    tint = Color.Unspecified
                )

                Spacer(Modifier.size(12.dp))
                RecommendationText(text)
                Text(
                    text = buttonText,
                     modifier = Modifier.clickable {
                        uriHandler.openUri(link)
                     },
                    fontSize = 12.sp,
                    color = Green
                )
            }
        })
}

fun truncateText(text: String, maxLines: Int): String {
    // Implement logic to truncate text to a specific number of lines
    val lines = text.lines()
    return if (lines.size <= maxLines) {
        text
    } else {
        lines.take(maxLines).joinToString(" ") + "..."
    }
}

@Preview(showBackground = true)
@Composable
fun RecommendationsScreenPreview() {
    EffectiveMobileProjectHHTheme {
        RecommendationsScreen()
    }
}