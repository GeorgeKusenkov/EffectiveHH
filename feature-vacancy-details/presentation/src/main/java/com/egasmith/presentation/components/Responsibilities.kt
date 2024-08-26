package com.egasmith.presentation.components

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
import com.egasmith.core.ui.text.SalaryText
import com.egasmith.core.ui.text.StandardText
import com.egasmith.core.ui.theme.EffectiveMobileProjectHHTheme

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

@Preview(showBackground = true)
@Composable
fun ResponsibilitiesPreview() {
    EffectiveMobileProjectHHTheme {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            containerColor = Color(0xFF0C0C0C),
        ) { innerPadding ->
            Responsibilities(
"MOBYRIX - динамично развивающаяся продуктовая IT-компания, специализирующаяся на разработке мобильных приложений для iOS и Android. Наша команда работает над собственными продуктами в разнообразных сферах: от утилит до развлечений и бизнес-приложений.\u2028Мы ценим талант и стремление к инновациям и в данный момент в поиске талантливого UX/UI Designer, готового присоединиться к нашей команде и внести значимый вклад в развитие наших проектов.",
                "-Проектировать пользовательский опыт, проводить UX исследования;\u2028-Разрабатывать адаптивный дизайн интерфейса для мобильных приложений;\u2028-Разрабатывать быстрые прототипы для тестирования идеи дизайна и их последующая; интеграция на основе обратной связи от команды и пользователей;\u2028-Взаимодействовать с командой разработчиков для обеспечения точной реализации ваших дизайнов;\u2028-Анализ пользовательского опыта и адаптация под тренды."
            )
        }

    }
}