package com.egasmith.presentation.vacancydetails.ui.components.main.companyInfo

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.egasmith.core.ui.text.SalaryText
import com.egasmith.core.ui.text.StandardText

@Composable
fun Responsibilities(
    description: String,
    responsibilities: String
) {
    Column {
        StandardText(text = description)
        Spacer(Modifier.size(10.dp))
        SalaryText(text = "Ваши задачи")
        Spacer(Modifier.size(6.dp))
        StandardText(text = responsibilities)
    }
}