package com.egasmith.presentation.vacancydetails.ui.components.main.questions

import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun Question(text: String, onClick: (String) -> Unit) {
    QuestionsInfoBlock(
        modifier = Modifier.clickable { onClick(text) },
        content = {
            Text(
                text = text,
                fontSize = 14.sp,
                fontWeight = FontWeight.W500
            )
        }
    )
}
