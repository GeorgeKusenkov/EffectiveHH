package com.egasmith.presentation.vacancies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.egasmith.core.common.UiState
import com.egasmith.domain.model.VacancyDomain
import com.egasmith.domain.usecases.GetVacanciesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class VacancyUI(
    val lookingNumber: Int,
    val title: String,
    val town: String,
    val company: String,
    val experience: String,
    val publishedDate: String,
    val isFavorite: Boolean,
    val salary: String
)

@HiltViewModel
class VacanciesViewModel @Inject constructor(
    private val getVacanciesUseCase: GetVacanciesUseCase
) : ViewModel() {
    private val _vacanciesState = MutableStateFlow<UiState<List<VacancyUI>>>(UiState.Loading)
    val vacanciesState: StateFlow<UiState<List<VacancyUI>>> = _vacanciesState.asStateFlow()

    init {
        loadVacancies()
    }

    private fun loadVacancies() {
        viewModelScope.launch {
            _vacanciesState.value = UiState.Loading
            getVacanciesUseCase.execute()
                .collect { result ->
                    result.fold(
                        onSuccess = { vacancies ->
                            _vacanciesState.value = UiState.Success(vacancies.map { it.toUIModel() })
                        },
                        onFailure = { error ->
                            _vacanciesState.value = UiState.Error(error.message)
                        }
                    )
                }
        }
    }

    private fun VacancyDomain.toUIModel(): VacancyUI {
        return VacancyUI(
            lookingNumber = lookingNumber,
            title = title,
            town = town,
            company = company,
            experience = experience,
            publishedDate = publishedDate,
            isFavorite = isFavorite,
            salary = salary
        )
    }
}