package com.egasmith.presentation.sreeen

sealed class MainScreenState {
    data object Initial : MainScreenState()
    data object ActiveSearch : MainScreenState()
}