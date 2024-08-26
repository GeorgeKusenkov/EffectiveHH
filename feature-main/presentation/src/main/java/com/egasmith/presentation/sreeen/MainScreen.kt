package com.egasmith.presentation.sreeen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.egasmith.presentation.recommendations.RecommendationsScreen
import com.egasmith.presentation.searchbar.SearchBar
import com.egasmith.presentation.vacancies.VacanciesScreen

@Composable
fun MainScreen(
    onVacancyClick: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
    ) {
        SearchBar()
        VacanciesScreen(
            onVacancyClick = onVacancyClick,
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        )
    }
}
