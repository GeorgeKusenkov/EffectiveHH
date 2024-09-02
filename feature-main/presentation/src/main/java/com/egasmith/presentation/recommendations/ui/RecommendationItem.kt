package com.egasmith.presentation.recommendations.ui

sealed class RecommendationItem {
    data class WithIconAndButton(
        val text: String,
        val buttonText: String,
        val icon: Int,
        val link: String
    ) : RecommendationItem()

    data class WithIcon(
        val text: String,
        val icon: Int
    ) : RecommendationItem()

    data class WithTextAndLink(
        val text: String,
        val link: String
    ) : RecommendationItem()
}