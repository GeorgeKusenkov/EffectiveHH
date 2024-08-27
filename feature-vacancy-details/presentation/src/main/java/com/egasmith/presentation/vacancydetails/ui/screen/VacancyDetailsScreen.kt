package com.egasmith.presentation.vacancydetails.ui.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.egasmith.core.common.UiState
import com.egasmith.presentation.vacancydetails.ui.components.ErrorState
import com.egasmith.presentation.vacancydetails.ui.components.LoadingIndicator
import com.egasmith.presentation.vacancydetails.ui.components.VacancyDetailsContent

@Composable
fun VacancyDetailsScreen(
    modifier: Modifier = Modifier,
    vacancyId: String,
    viewModel: VacancyDetailsViewModel = hiltViewModel()
) {
    LaunchedEffect(vacancyId) {
        viewModel.loadVacancyDetails(vacancyId)
    }

    val vacancyDetailsState by viewModel.vacancyDetails.collectAsState()

    when (val state = vacancyDetailsState) {
        is UiState.Loading -> LoadingIndicator(modifier)
        is UiState.Success -> VacancyDetailsContent(state.data)
        is UiState.Error -> ErrorState(state.message)
    }
}

