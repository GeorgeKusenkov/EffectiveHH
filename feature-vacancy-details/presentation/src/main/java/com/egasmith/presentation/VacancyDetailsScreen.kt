package com.egasmith.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.egasmith.core.ui.theme.EffectiveMobileProjectHHTheme
import com.egasmith.presentation.components.CompanyInfo
import com.egasmith.presentation.components.Questions
import com.egasmith.presentation.components.Responsibilities
import com.egasmith.presentation.components.TopAppBar
import com.egasmith.presentation.components.VacancyHeader
import com.egasmith.presentation.components.VacancyStatistic

@Composable
fun VacancyDetailsScreen() {

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(22.dp)
    ) {
        item { TopAppBar() }
        item { VacancyHeader("Designer", "100", "10 лет", "Полная") }
        item { VacancyStatistic(14, 132) }
        item {
            CompanyInfo(
                "Мобирикс",
                "Минск",
                "Бирюзова, 5"
            )
        }
        item {
            Responsibilities(
                "MOBYRIX - динамично развивающаяся продуктовая IT-компания, специализирующаяся на разработке мобильных приложений для iOS и Android. Наша команда работает над собственными продуктами в разнообразных сферах: от утилит до развлечений и бизнес-приложений.\u2028Мы ценим талант и стремление к инновациям и в данный момент в поиске талантливого UX/UI Designer, готового присоединиться к нашей команде и внести значимый вклад в развитие наших проектов.",
                "-Проектировать пользовательский опыт, проводить UX исследования;\u2028-Разрабатывать адаптивный дизайн интерфейса для мобильных приложений;\u2028-Разрабатывать быстрые прототипы для тестирования идеи дизайна и их последующая; интеграция на основе обратной связи от команды и пользователей;\u2028-Взаимодействовать с командой разработчиков для обеспечения точной реализации ваших дизайнов;\u2028-Анализ пользовательского опыта и адаптация под тренды."
            )
        }
        item { Questions() }
    }


}

@Preview(showBackground = true)
@Composable
fun VacancyDetailsScreenPreview() {
    EffectiveMobileProjectHHTheme {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            containerColor = Color(0xFF0C0C0C),
        ) { innerPadding ->
            VacancyDetailsScreen()
        }

    }
}