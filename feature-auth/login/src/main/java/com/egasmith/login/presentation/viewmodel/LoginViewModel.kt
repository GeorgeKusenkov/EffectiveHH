package com.egasmith.login.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.egasmith.login.presentation.state.InputState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class LoginViewModel : ViewModel() {
    private val _state = MutableStateFlow<InputState>(InputState.Empty)
    val state: StateFlow<InputState> = _state.asStateFlow()

    private val _isInputValid = MutableStateFlow(false)
    val isInputValid: StateFlow<Boolean> = _isInputValid.asStateFlow()

    private val _showError = MutableStateFlow(false)
    val showError: StateFlow<Boolean> = _showError.asStateFlow()

    fun getEmail(): String {
        return when (val currentState = _state.value) {
            is InputState.Filled -> currentState.input
            else -> ""
        }
    }

    fun onInputChanged(input: String) {
        _state.value = if (input.isEmpty()) {
            InputState.Empty
        } else {
            InputState.Filled(input)
        }
        _isInputValid.value = isValidInput(input)
        _showError.value = false
    }

    fun onClearClick() {
        _state.value = InputState.Empty
        _isInputValid.value = false
        _showError.value = false
    }

    fun onContinueClick() {
        _showError.value = !_isInputValid.value
    }

    private fun isValidInput(input: String): Boolean {
        return isValidEmail(input) || isValidPhoneNumber(input)
    }

    private fun isValidEmail(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun isValidPhoneNumber(phone: String): Boolean {
        return phone.matches(Regex("""^\+\d{10,15}$"""))
    }
}