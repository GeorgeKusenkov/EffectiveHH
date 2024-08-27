package com.egasmith.presentation.vacancydetails.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.egasmith.domain.model.VacancyDetails
import com.egasmith.presentation.modalscreen.BottomSheetContent
import com.egasmith.presentation.modalscreen.ModalState
import com.egasmith.presentation.modalscreen.ResponseModalScreen
import com.egasmith.presentation.vacancydetails.ui.components.main.VacancyDetailsList

@Composable
fun VacancyDetailsContent(vacancy: VacancyDetails) {
    var modalState by remember { mutableStateOf<ModalState>(ModalState.Closed) }

    Box(modifier = Modifier.fillMaxSize()) {
        Column {
            // Данные о вакансии
            VacancyDetailsList(
                vacancy = vacancy,
                onQuestionClick = { question ->
                    modalState = ModalState.CoverLetter(initialText = question)
                },
                onConfirmClick = {
                    modalState = ModalState.BottomSheet
                }
            )
        }

        // Отображение модальных экранов (Отклик 1, Отлик 2)
        when (modalState) {
            is ModalState.BottomSheet -> {
                BottomSheetContent(
                    onDismiss = { modalState = ModalState.Closed },
                    onAddCoverLetter = { modalState = ModalState.CoverLetter() }
                )
            }
            is ModalState.CoverLetter -> {
                ResponseModalScreen(
                    initialQuestion = (modalState as ModalState.CoverLetter).initialText,
                    onDismiss = { modalState = ModalState.Closed }
                )
            }
            ModalState.Closed -> {}
        }
    }
}

