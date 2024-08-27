package com.egasmith.presentation.vacancydetails.ui.components.main.statisticCards

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.egasmith.core.ui.items.InfoBlock
import com.egasmith.core.ui.text.StandardText
import com.egasmith.core.ui.theme.DarkGreen
import com.egasmith.core.ui.theme.EffectiveMobileProjectHHTheme
import com.egasmith.presentation.R

@Composable
fun VacancyStatisticCards(appliedNumber: Int, lookingNumber: Int) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        StatisticInfoBlock(
            appliedNumber,
            "человек уже откликнулось",
            "applied number",
            R.drawable.ic_applied_number
        )

        StatisticInfoBlock(
            lookingNumber,
            "человека сейчас смотрят",
            "loocking number",
            R.drawable.ic_loocking
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ApplicantsInfoPreview() {
    EffectiveMobileProjectHHTheme {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            containerColor = Color(0xFF0C0C0C),
        ) { innerPadding ->
            VacancyStatisticCards(10, 132)
        }

    }
}