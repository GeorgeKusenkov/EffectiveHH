package com.egasmith.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.egasmith.core.common.UiState
import com.egasmith.domain.model.VacancyDetails
import com.egasmith.domain.usecases.GetVacanciesDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VacancyDetailsViewModel @Inject constructor(
    private val getVacanciesDetailsUseCase: GetVacanciesDetailsUseCase
) : ViewModel() {

    private val _vacancyDetails = MutableStateFlow<UiState<List<VacancyDetails>>>(UiState.Loading)
    val vacancyDetails: StateFlow<UiState<List<VacancyDetails>>> = _vacancyDetails.asStateFlow()

    init {
        loadVacancyDetails()
    }

    private fun loadVacancyDetails() {
        viewModelScope.launch {
            _vacancyDetails.value = UiState.Loading
            getVacanciesDetailsUseCase.execute()
                .collect { result ->
                    result.fold(
                        onSuccess = {
                            _vacancyDetails.value = UiState.Success(it)
                        },
                        onFailure = {
                            _vacancyDetails.value = UiState.Error(it.message)
                        }
                    )
            }
        }
    }
}