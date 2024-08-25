package com.egasmith.presentation.vacancies


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.egasmith.core.ui.GreenConfirmButton
import com.egasmith.core.ui.InfoBlock
import com.egasmith.effectivemobileprojecthh.ui.theme.Green
import com.egasmith.core.ui.R
import com.egasmith.core.ui.R.drawable.ic_is_favorite
import com.egasmith.core.ui.R.drawable.ic_is_favorite_filled
import com.egasmith.core.ui.theme.EffectiveMobileProjectHHTheme
import com.egasmith.effectivemobileprojecthh.ui.theme.Gray


@Composable
fun VacanciesScreen(viewModel: VacanciesViewModel = hiltViewModel()) {
    val vacancies by viewModel.vacancies.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    val error by viewModel.error.collectAsState()

    when {
        isLoading -> {
            CircularProgressIndicator(
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.Center)
            )
        }

        error != null -> {
            Text(
                text = error ?: "Unknown error",
                color = Color.Red,
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.Center)
            )
        }

        else -> {
            VacancyList(vacancies = vacancies)
        }
    }
}

@Composable
fun VacancyList(vacancies: List<VacancyUI>) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(vacancies) { vacancy ->
            VacancyItem(vacancy)
        }
    }
}

@Composable
fun VacancyItem(vacancy: VacancyUI) {

    InfoBlock(content = {
        Column(modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Сейчас просматривает ${vacancy.lookingNumber} человек", color = Green)

                FavoriteIcon(isFavorite = vacancy.isFavorite)
            }
            
            SimpleText(text = vacancy.title)
            SimpleText(text = vacancy.salary, textSize = 20.sp)
            SimpleText(text = vacancy.town)

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                SimpleText(text = vacancy.company)
                Spacer(modifier = Modifier.size(10.dp))
                Icon(
                    painter = painterResource(R.drawable.ic_ok),
                    contentDescription = "Not Favorite",
                    tint = Color.Unspecified
                )
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_suitcase),
                    contentDescription = "Not Favorite",
                    tint = Color.Unspecified
                )
                Spacer(modifier = Modifier.size(10.dp))
                SimpleText(text = "Опыт ${vacancy.experience}")
            }

            SimpleText(text = "Опубликовано ${vacancy.publishedDate}", color = Gray)

            GreenConfirmButton("Откликнуться")
        }
    }
    )

}

@Composable
fun SimpleText(
    text: String,
    color: Color = Color.White,
    textSize: TextUnit = 14.sp
) {
    Text(text, color = color, fontSize = textSize)
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
        VacancyItem(vacancy)
    }
}