package com.egasmith.presentation.vacancydetails.ui.components.main.questions

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.egasmith.core.ui.buttons.GreenConfirmButton
import com.egasmith.core.ui.text.GrayText
import com.egasmith.core.ui.text.StandardText
import com.egasmith.core.ui.theme.LightGray

@Composable
fun Questions(
    onQuestionClick: (String) -> Unit,
    onConfirmClick: () -> Unit
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        StandardText("Задайте вопрос работодателю")
        GrayText("Он получит его с откликом на вакансию")

        // Блок с вопросами
        Question("Где располагается место работы?", onQuestionClick)
        Question("Какой график работы?", onQuestionClick)
        Question("Вакансия открыта?", onQuestionClick)
        Question("Какая оплата труда?", onQuestionClick)

        Spacer(Modifier.size(6.dp))

        // Нижнее модальное меню (Отклик  1)
        GreenConfirmButton(
            text = "Откликнуться",
            onClick = onConfirmClick
        )
    }
}


