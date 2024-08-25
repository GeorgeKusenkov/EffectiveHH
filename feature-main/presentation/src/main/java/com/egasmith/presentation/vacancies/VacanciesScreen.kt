package com.egasmith.presentation.vacancies

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.egasmith.core.common.UiState
import com.egasmith.core.ui.buttons.BlueConfirmButton
import com.egasmith.core.ui.buttons.GreenConfirmButton
import com.egasmith.core.ui.items.InfoBlock
import com.egasmith.core.ui.R
import com.egasmith.core.ui.R.drawable.ic_is_favorite
import com.egasmith.core.ui.R.drawable.ic_is_favorite_filled
import com.egasmith.core.ui.text.ColoredText
import com.egasmith.core.ui.text.GrayText
import com.egasmith.core.ui.text.HeaderText
import com.egasmith.core.ui.text.SalaryText
import com.egasmith.core.ui.text.StandardText
import com.egasmith.core.ui.text.VacancyText
import com.egasmith.core.ui.theme.EffectiveMobileProjectHHTheme

@Composable
fun VacanciesScreen(modifier: Modifier, viewModel: VacanciesViewModel = hiltViewModel()) {
    val vacanciesState by viewModel.vacanciesState.collectAsState()

    when (val state = vacanciesState) {
        is UiState.Loading -> ShowCircularIndicator()
        is UiState.Success -> VacancyList(modifier = modifier, vacancies = state.data)
        is UiState.Error -> ErrorText(state)
    }
}

@Composable
fun VacancyList(modifier: Modifier = Modifier, vacancies: List<VacancyUI>) {
    Column(
        modifier = modifier
            .fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            contentPadding = PaddingValues(vertical = 10.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            item {
                HeaderText(text = "Вакансии для вас")
            }

            items(vacancies.take(3)) { vacancy ->
                VacancyItem(vacancy)
            }
        }

        BlueConfirmButton(
            text = "Ещё 143 вакансии",
            isActive = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp)
        )
    }
}

@Composable
fun VacancyItem(vacancy: VacancyUI) {
    InfoBlock(content = {
        Column(
            modifier = Modifier
                .padding(8.dp, 16.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            HeaderItem(vacancy)
            VacancyText(text = vacancy.title)
            SalaryText(text = vacancy.salary)
            CompanyCityAndName(vacancy)
            ExperienceItem(vacancy)
            GrayText(text = "Опубликовано ${vacancy.publishedDate}")
            GreenConfirmButton("Откликнуться")
        }
    }
    )
}

@Composable
private fun CompanyCityAndName(vacancy: VacancyUI) {
    Column(
        verticalArrangement = Arrangement.Top,
        modifier = Modifier.fillMaxWidth()
    ) {
        StandardText(text = vacancy.town)
        CompanyItem(vacancy)
    }
}

@Composable
private fun ExperienceItem(vacancy: VacancyUI) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Icon(
            painter = painterResource(R.drawable.ic_suitcase),
            contentDescription = "Not Favorite",
            tint = Color.Unspecified
        )
        Spacer(modifier = Modifier.size(8.dp))
        StandardText(text = "Опыт ${vacancy.experience}")
    }
}

@Composable
private fun CompanyItem(vacancy: VacancyUI) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        StandardText(text = vacancy.company)
        Spacer(modifier = Modifier.size(8.dp))
        Icon(
            painter = painterResource(R.drawable.ic_ok),
            contentDescription = "Not Favorite",
            tint = Color.Unspecified
        )
    }
}

@Composable
private fun HeaderItem(vacancy: VacancyUI) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        ColoredText(text = "Сейчас просматривает ${vacancy.lookingNumber} человек")
        FavoriteIcon(isFavorite = vacancy.isFavorite)
    }
}

@Composable
fun FavoriteIcon(isFavorite: Boolean) {
    val iconResId = if (isFavorite) ic_is_favorite_filled else ic_is_favorite
    val contentDescription = if (isFavorite) "Favorite" else "Not Favorite"

    Icon(
        painter = painterResource(id = iconResId),
        contentDescription = contentDescription,
        tint = Color.Unspecified
    )
}

@Composable
private fun ShowCircularIndicator() {
    CircularProgressIndicator(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    )
}

@Composable
private fun ErrorText(state: UiState.Error) {
    Text(
        text = state.message ?: "Ошибка при загрузке данных",
        color = Color.Red,
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    )
}

@Preview(showBackground = true)
@Composable
fun VacancyItemPreview() {
    EffectiveMobileProjectHHTheme {
        val vacancy = VacancyUI(
            1,
            "UI/UX Designer",
            "Минск",
            "Мобирикс",
            " от 1 года до 3 лет",
            "20 февраля",
            true,
            "1500-2900",
        )
        Scaffold(
            containerColor = Color(0xFF0C0C0C),
            modifier = Modifier.fillMaxSize(),
        ) { innerPadding ->
            Column {
                HeaderText(text = "Вакансии для вас",)
                VacancyItem(vacancy)
            }
        }

    }
}