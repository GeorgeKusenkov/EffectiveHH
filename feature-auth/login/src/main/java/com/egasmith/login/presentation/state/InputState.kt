package com.egasmith.login.presentation.state

sealed class InputState {
    data object Empty : InputState()
    data class Filled(val input: String) : InputState()
}
