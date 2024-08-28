package com.egasmith.presentation.sreeen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.egasmith.core.common.UiState
import com.egasmith.presentation.searchbar.ActiveSearchBar
import com.egasmith.presentation.searchbar.InActiveSearchBar
import com.egasmith.presentation.vacancies.VacanciesScreen
import com.egasmith.presentation.vacancies.VacanciesViewModel

@Composable
fun MainScreen(
    onVacancyClick: (String) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: VacanciesViewModel = hiltViewModel()
) {
    var screenState by remember { mutableStateOf<MainScreenState>(MainScreenState.Initial) }
    var showAllVacancies by remember { mutableStateOf(false) }
    val vacanciesState by viewModel.vacanciesState.collectAsState()

    Column(
        modifier = modifier.fillMaxSize()
    ) {
        when (screenState) {
            is MainScreenState.Initial -> InActiveSearchBar()
            is MainScreenState.ActiveSearch -> ActiveSearchBar(
                vacancyNum = (vacanciesState as? UiState.Success)?.data?.size ?: 0,
                onBackClick = {
                    screenState = MainScreenState.Initial
                    showAllVacancies = false
                }
            )
        }

        VacanciesScreen(
            onVacancyClick = onVacancyClick,
            showRecommendations = screenState is MainScreenState.Initial,
            showAllVacancies = showAllVacancies,
            onShowMoreClick = {
                screenState = MainScreenState.ActiveSearch
                showAllVacancies = true
            },
            modifier = Modifier.weight(1f).fillMaxWidth()
        )
    }
}
