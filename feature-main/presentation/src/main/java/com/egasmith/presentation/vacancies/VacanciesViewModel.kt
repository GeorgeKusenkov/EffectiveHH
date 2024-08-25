package com.egasmith.presentation.vacancies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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
    private val _vacancies = MutableStateFlow<List<VacancyUI>>(emptyList())
    val vacancies: StateFlow<List<VacancyUI>> = _vacancies.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error.asStateFlow()

    init {
        loadVacancies()
    }

    private fun loadVacancies() {
        viewModelScope.launch {
            _isLoading.value = true
            getVacanciesUseCase.execute()
                .collect { result ->
                    _isLoading.value = false
                    result.fold(
                        onSuccess = { _vacancies.value = it.map { vacancy -> vacancy.toUIModel() } },
                        onFailure = { _error.value = it.message }
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