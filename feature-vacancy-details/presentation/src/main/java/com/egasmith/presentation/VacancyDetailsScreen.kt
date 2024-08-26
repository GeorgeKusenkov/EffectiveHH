package com.egasmith.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.egasmith.core.common.UiState
import com.egasmith.core.ui.theme.EffectiveMobileProjectHHTheme
import com.egasmith.domain.model.VacancyDetails
import com.egasmith.presentation.components.CompanyInfo
import com.egasmith.presentation.components.Questions
import com.egasmith.presentation.components.Responsibilities
import com.egasmith.presentation.components.TopAppBar
import com.egasmith.presentation.components.VacancyHeader
import com.egasmith.presentation.components.VacancyStatistic

@Composable
fun VacancyDetailsScreen(
    modifier: Modifier = Modifier,
    vacancyId: String,
    viewModel: VacancyDetailsViewModel = hiltViewModel()
) {
    val vacancyDetailsState by viewModel.vacancyDetails.collectAsState()

    when (val state = vacancyDetailsState) {
        is UiState.Loading -> LoadingIndicator(modifier)
        is UiState.Success -> {
            val vacancies = state.data
            if (vacancies.isNotEmpty()) {
                VacancyDetailsContent(vacancies.first())
            } else {
                EmptyState()
            }
        }
        is UiState.Error -> ErrorState(state.message)
    }
}

@Composable
fun LoadingIndicator(modifier: Modifier) {
    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        CircularProgressIndicator()
    }
}

@Composable
fun EmptyState() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("Нет доступных вакансий")
    }
}

@Composable
fun ErrorState(message: String?) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("Ошибка при загрузке данных: ${message ?: "Неизвестная ошибка"}")
    }
}

@Composable
fun VacancyDetailsContent(vacancy: VacancyDetails) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(22.dp)
    ) {
        item { TopAppBar() }
        item {
            VacancyHeader(
                title = vacancy.title,
                salary = vacancy.salary?.full ?: "Не указана",
                experience = vacancy.experience.text,
                schedules = vacancy.schedules.firstOrNull() ?: "Не указан",
            )
        }
        item {
            VacancyStatistic(
                appliedNumber = vacancy.appliedNumber ?: 0,
                lookingNumber = vacancy.lookingNumber ?: 0
            )
        }
        item {
            CompanyInfo(
                companyTitle = vacancy.company.name,
                city = vacancy.company.address.city,
                street = "${vacancy.company.address.street}, ${vacancy.company.address.building}"
            )
        }
        item {
            Responsibilities(
                description = vacancy.company.description ?: "",
                responsibilities = vacancy.responsibilities
            )
        }
        item { Questions() }
    }
}

@Preview(showBackground = true)
@Composable
fun VacancyDetailsScreenPreview() {
    EffectiveMobileProjectHHTheme {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            containerColor = Color(0xFF0C0C0C),
        ) { innerPadding ->
//            VacancyDetailsScreen()
        }

    }
}