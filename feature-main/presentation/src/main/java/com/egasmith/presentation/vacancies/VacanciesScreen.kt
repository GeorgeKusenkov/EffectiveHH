package com.egasmith.presentation.vacancies

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.egasmith.core.common.UiState
import com.egasmith.core.common.vacanciesWord
import com.egasmith.core.ui.buttons.BlueConfirmButton
import com.egasmith.core.ui.items.ErrorText
import com.egasmith.core.ui.items.ShowCircularIndicator
import com.egasmith.core.ui.text.HeaderText
import com.egasmith.domain.model.Vacancy
import com.egasmith.presentation.recommendations.RecommendationsScreen

@Composable
fun VacanciesScreen(
    onVacancyClick: (String) -> Unit,
    showRecommendations: Boolean,
    showAllVacancies: Boolean,
    onShowMoreClick: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: VacanciesViewModel = hiltViewModel()
) {
    val vacanciesState by viewModel.vacanciesState.collectAsState()

    when (val state = vacanciesState) {
        is UiState.Loading -> ShowCircularIndicator()
        is UiState.Success -> VacancyList(
            modifier = modifier,
            vacancies = state.data,
            onVacancyClick = onVacancyClick,
            showRecommendations = showRecommendations,
            showAllVacancies = showAllVacancies,
            onShowMoreClick = onShowMoreClick
        )
        is UiState.Error -> ErrorText(state)
    }
}

@Composable
fun VacancyList(
    modifier: Modifier = Modifier,
    vacancies: List<Vacancy>,
    onVacancyClick: (String) -> Unit,
    showRecommendations: Boolean,
    showAllVacancies: Boolean,
    onShowMoreClick: () -> Unit
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(vertical = 10.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        if (showRecommendations) {
            item { RecommendationsScreen() }
        }

        item { HeaderText(text = "Вакансии для вас") }

        items(if (showAllVacancies) vacancies else vacancies.take(3)) { vacancy ->
            VacancyItem(vacancy, onVacancyClick)
        }

        if (vacancies.size > 3 && !showAllVacancies) {
            val remainingVacancies = vacancies.size - 3
            item {
                BlueConfirmButton(
                    text = "Ещё ${remainingVacancies.vacanciesWord()}",
                    isActive = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 10.dp),
                    onClick = {
                        onShowMoreClick()
                    }
                )
            }
        }
    }
}

