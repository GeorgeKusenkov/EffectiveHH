package com.egasmith.presentation.vacancies

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.egasmith.core.ui.R
import com.egasmith.core.ui.R.drawable.ic_is_favorite
import com.egasmith.core.ui.R.drawable.ic_is_favorite_filled
import com.egasmith.core.ui.buttons.GreenConfirmButton
import com.egasmith.core.ui.items.InfoBlock
import com.egasmith.core.ui.text.ColoredText
import com.egasmith.core.ui.text.GrayText
import com.egasmith.core.ui.text.SalaryText
import com.egasmith.core.ui.text.StandardText
import com.egasmith.core.ui.text.VacancyText
import com.egasmith.domain.model.Vacancy

@Composable
fun VacancyItem(vacancy: Vacancy, onVacancyClick: (String) -> Unit) {
    InfoBlock(
        modifier = Modifier.clickable { onVacancyClick(vacancy.id) },
        content = {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                HeaderItem(vacancy)
                VacancyText(text = vacancy.title)
                SalaryText(text = vacancy.salary)
                CompanyCityAndName(vacancy)
                ExperienceItem(vacancy)
                GrayText(text = vacancy.publishedDate)
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable(enabled = false) {}
                ) {
                    GreenConfirmButton("Откликнуться") {}
                }
            }
        },
        contentPadding = PaddingValues(18.dp, 16.dp)
    )
}

@Composable
private fun CompanyCityAndName(vacancy: Vacancy) {
    Column(
        verticalArrangement = Arrangement.Top,
        modifier = Modifier.fillMaxWidth()
    ) {
        StandardText(text = vacancy.town)
        CompanyItem(vacancy)
    }
}

@Composable
private fun ExperienceItem(vacancy: Vacancy) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Icon(
            painter = painterResource(R.drawable.ic_suitcase),
            contentDescription = "Experience",
            tint = Color.Unspecified
        )
        Spacer(modifier = Modifier.size(8.dp))
        StandardText(text = "Опыт ${vacancy.experience}")
    }
}

@Composable
private fun CompanyItem(vacancy: Vacancy) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        StandardText(text = vacancy.company)
        Spacer(modifier = Modifier.size(8.dp))
        Icon(
            painter = painterResource(R.drawable.ic_ok),
            contentDescription = "Verified",
            tint = Color.Unspecified
        )
    }
}

@Composable
private fun HeaderItem(vacancy: Vacancy) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        // Не показываем если вакансию никто не сомтрит
        if (vacancy.lookingNumber > 0)  {
            ColoredText(text = "Сейчас просматривает ${vacancy.lookingNumber} человек")
        } else Spacer(Modifier.weight(1f))

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