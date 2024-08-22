package com.egasmith.login.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.egasmith.login.presentation.state.InputState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class LoginViewModel : ViewModel() {
    private val _state = MutableStateFlow<InputState>(InputState.Empty)
    val state: StateFlow<InputState> = _state.asStateFlow()

    fun onInputChanged(input: String) {
        _state.value = if (input.isEmpty()) {
            InputState.Empty
        } else {
            InputState.Filled(input, isValidInput(input))
        }
    }

    fun onClearClick() {
        _state.value = InputState.Empty
    }

    private fun isValidInput(input: String): Boolean {
        return isValidEmail(input) || isValidPhoneNumber(input)
    }

    private fun isValidEmail(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun isValidPhoneNumber(phone: String): Boolean {
        // Простая проверка: начинается с '+' и содержит от 10 до 15 цифр
        return phone.matches(Regex("""^\+\d{10,15}$"""))
    }
}