package com.egasmith.presentation.recommendations

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.egasmith.core.common.UiState
import com.egasmith.domain.MainRepository
import com.egasmith.domain.model.Recommendation
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecommendationsViewModel @Inject constructor(
    private val repository: MainRepository
) : ViewModel() {

    private val _recommendations = MutableStateFlow<UiState<List<Recommendation>>>(UiState.Loading)
    val recommendations: StateFlow<UiState<List<Recommendation>>> get() = _recommendations

    init {
        loadRecommendations()
    }

    private fun loadRecommendations() {
        viewModelScope.launch {
            repository.getRecommendations().collect { result ->
                result.onSuccess { offers ->
                    Log.d("OOOOFFERSD", offers.toString())
                    _recommendations.value = UiState.Success(offers)
                }.onFailure { error ->
                    _recommendations.value = UiState.Error(error.message)
                }
            }
        }
    }
}