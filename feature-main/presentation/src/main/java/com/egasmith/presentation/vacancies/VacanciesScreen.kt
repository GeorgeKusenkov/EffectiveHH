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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.egasmith.core.common.UiState
import com.egasmith.core.ui.BlueConfirmButton
import com.egasmith.core.ui.GreenConfirmButton
import com.egasmith.core.ui.InfoBlock
import com.egasmith.core.ui.MainTitle
import com.egasmith.effectivemobileprojecthh.ui.theme.Green
import com.egasmith.core.ui.R
import com.egasmith.core.ui.R.drawable.ic_is_favorite
import com.egasmith.core.ui.R.drawable.ic_is_favorite_filled
import com.egasmith.core.ui.theme.EffectiveMobileProjectHHTheme
import com.egasmith.effectivemobileprojecthh.ui.theme.Gray

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
                MainTitle(
                    modifier = Modifier.padding(0.dp, 10.dp),
                    text = "Вакансии для вас",
                    fontWeight = FontWeight.Bold
                )
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
            SimpleText(text = vacancy.title, fontWeight = FontWeight.Bold, textSize = 16.sp)
            SalaryItem(vacancy)
            CompanyCityAndName(vacancy)
            ExperienceItem(vacancy)
            SimpleText(text = "Опубликовано ${vacancy.publishedDate}", color = Gray)
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
        SimpleText(text = vacancy.town)
        CompanyItem(vacancy)
    }
}

@Composable
private fun SalaryItem(vacancy: VacancyUI) {
    SimpleText(text = vacancy.salary, textSize = 20.sp, modifier = Modifier.padding(top = 4.dp))
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
        SimpleText(text = "Опыт ${vacancy.experience}")
    }
}

@Composable
private fun CompanyItem(vacancy: VacancyUI) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        SimpleText(text = vacancy.company)
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
        Text(text = "Сейчас просматривает ${vacancy.lookingNumber} человек", color = Green)
        FavoriteIcon(isFavorite = vacancy.isFavorite)
    }
}

@Composable
fun SimpleText(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = Color.White,
    textSize: TextUnit = 14.sp,
    fontWeight: FontWeight = FontWeight.Normal
) {
    Text(
        modifier = modifier,
        text = text,
        color = color,
        fontSize = textSize,
        fontWeight = fontWeight
    )
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
//        VacanciesScreen()
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
                MainTitle(
                    modifier = Modifier.padding(0.dp, 10.dp),
                    text = "Вакансии для вас",
                    fontWeight = FontWeight.Bold
                )
                VacancyItem(vacancy)
            }
        }

    }
}