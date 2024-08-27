package com.egasmith.presentation.modalscreen

sealed class ModalState {
    data object Closed : ModalState()
    data object BottomSheet : ModalState()
    data class CoverLetter(val initialText: String? = null) : ModalState()
}