package com.egasmith.presentation.vacancydetails.ui.screen

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.egasmith.core.common.UiState
import com.egasmith.presentation.vacancydetails.ui.components.ErrorState
import com.egasmith.presentation.vacancydetails.ui.components.LoadingIndicator
import com.egasmith.presentation.vacancydetails.ui.components.VacancyDetailsContent
import com.egasmith.presentation.vacancydetails.ui.components.appbar.TopAppBar

@Composable
fun VacancyDetailsScreen(
    modifier: Modifier = Modifier,
    vacancyId: String,
    navController: NavHostController,
    viewModel: VacancyDetailsViewModel = hiltViewModel()
) {
    LaunchedEffect(vacancyId) {
        viewModel.loadVacancyDetails(vacancyId)
    }

    val vacancyDetailsState by viewModel.vacancyDetails.collectAsState()

    Column {

        // Верхнее меню
        TopAppBar(
            onBackClick = {
                Log.d("TopAppBar", "Back button clicked")
                navController.navigateUp()
            }
        )

        // Данные о вакансии + модальное окно
        when (val state = vacancyDetailsState) {
            is UiState.Loading -> LoadingIndicator(modifier)
            is UiState.Success -> VacancyDetailsContent(state.data)
            is UiState.Error -> ErrorState(state.message)
        }
    }

}

