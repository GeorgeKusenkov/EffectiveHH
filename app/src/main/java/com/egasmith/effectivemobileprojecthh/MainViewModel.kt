package com.egasmith.effectivemobileprojecthh

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.egasmith.core.api.models.HHResponseDTO
import com.egasmith.core.data.OffersRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val offersRepository: OffersRepository) : ViewModel() {
    private val _offers = MutableLiveData<HHResponseDTO>()
    val offers: LiveData<HHResponseDTO> get() = _offers

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> get() = _error

    fun loadOffers() {
        viewModelScope.launch {
            try {
                Log.d("OFFERSINFO", "offersRepository.getOffers(): ${offersRepository.getOffers()}")
                val response = offersRepository.getOffers()
                _offers.postValue(response)
            } catch (e: Exception) {
                _error.postValue("Error loading offers: ${e.message}")
            }
        }
    }
}