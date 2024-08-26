package com.egasmith.presentation.vacancies

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.egasmith.core.common.UiState
import com.egasmith.domain.model.Vacancy
import com.egasmith.domain.usecases.GetVacanciesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VacanciesViewModel @Inject constructor(
    private val getVacanciesUseCase: GetVacanciesUseCase
) : ViewModel() {

    private val _vacanciesState = MutableStateFlow<UiState<List<Vacancy>>>(UiState.Loading)
    val vacanciesState: StateFlow<UiState<List<Vacancy>>> = _vacanciesState.asStateFlow()

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
                            _vacanciesState.value = UiState.Success(vacancies)
                        },
                        onFailure = { error ->
                            _vacanciesState.value = UiState.Error(error.message)
                        }
                    )
                }
        }
    }
}