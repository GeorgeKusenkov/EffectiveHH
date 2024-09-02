package com.egasmith.presentation.recommendations.ui

import com.egasmith.domain.model.Recommendation
import com.egasmith.presentation.R

fun Recommendation.toRecommendationItem(): RecommendationItem {
    val icon = when (id) {
        "near_vacancies" -> R.drawable.ic_location
        "temporary_job" -> R.drawable.ic_not_full_job
        else -> R.drawable.ic_location
    }

    return when {
        id != null && buttonText != null -> {
            RecommendationItem.WithIconAndButton(
                text = truncateText(title, 2),
                buttonText = buttonText ?: "",
                icon = R.drawable.ic_resume_up,
                link = link
            )
        }

        id != null -> {
            RecommendationItem.WithIcon(
                text = truncateText(title, 3),
                icon = icon
            )
        }

        else -> {
            RecommendationItem.WithTextAndLink(
                text = truncateText(title, 3),
                link = link
            )
        }
    }
}