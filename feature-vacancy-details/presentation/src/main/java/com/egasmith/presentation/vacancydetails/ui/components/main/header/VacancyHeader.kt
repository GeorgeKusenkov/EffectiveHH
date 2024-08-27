package com.egasmith.presentation.vacancydetails.ui.components.main.header

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.egasmith.core.ui.text.ProfessionTitleText
import com.egasmith.core.ui.text.StandardText
import com.egasmith.core.ui.theme.EffectiveMobileProjectHHTheme

@Composable
fun VacancyHeader(
    title: String,
    salary: String,
    experience: String,
    schedules: String,
) {
    Column {
        ProfessionTitleText(title)
        Spacer(Modifier.size(8.dp))
        StandardText(salary)
        Spacer(Modifier.size(8.dp))
        StandardText(experience)
        StandardText(schedules)
    }
}


@Preview(showBackground = true)
@Composable
fun VacancyHeaderPreview() {
    EffectiveMobileProjectHHTheme {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            containerColor = Color(0xFF0C0C0C),
        ) { innerPadding ->
            VacancyHeader(
                "Designer",
                "100",
                "10 лет",
                "Полная"
            )
        }

    }
}