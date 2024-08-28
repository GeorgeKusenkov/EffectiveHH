package com.egasmith.presentation.vacancies

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.egasmith.core.common.UiState
import com.egasmith.core.ui.buttons.BlueConfirmButton
import com.egasmith.core.ui.text.HeaderText
import com.egasmith.domain.model.Vacancy
import com.egasmith.presentation.recommendations.RecommendationsScreen

@Composable
fun VacanciesScreen(
    onVacancyClick: (String) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: VacanciesViewModel = hiltViewModel()
) {
    val vacanciesState by viewModel.vacanciesState.collectAsState()

    when (val state = vacanciesState) {
        is UiState.Loading -> ShowCircularIndicator()
        is UiState.Success -> VacancyList(modifier = modifier, vacancies = state.data, onVacancyClick = onVacancyClick)
        is UiState.Error -> ErrorText(state)
    }
}

@Composable
fun VacancyList(
    modifier: Modifier = Modifier,
    vacancies: List<Vacancy>,
    onVacancyClick: (String) -> Unit
) {

    var showAllVacancies by remember { mutableStateOf(false) }

    Column(
        modifier = modifier.fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            contentPadding = PaddingValues(vertical = 10.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {

            //Блок рекомендаций
            item { RecommendationsScreen() }

            //Заголовок
            item { HeaderText(text = "Вакансии для вас") }

            //Список вакансий
            items(if (showAllVacancies) vacancies else vacancies.take(3)) { vacancy ->
                VacancyItem(vacancy, onVacancyClick)
            }

            // Кнопка появится если более 3х вакансий
            if (vacancies.size > 3 && !showAllVacancies) {
                item {
                    BlueConfirmButton(
                        text = "Ещё ${vacancies.size - 3} вакансии",
                        isActive = true,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 10.dp),
                        onClick = {
                            showAllVacancies = true
                        }
                    )
                }
            }
        }
    }
}

@Composable
private fun ShowCircularIndicator() {
    CircularProgressIndicator(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    )
}

@Composable
private fun ErrorText(state: UiState.Error) {
    Text(
        text = state.message ?: "Ошибка при загрузке данных",
        color = Color.Red,
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    )
}