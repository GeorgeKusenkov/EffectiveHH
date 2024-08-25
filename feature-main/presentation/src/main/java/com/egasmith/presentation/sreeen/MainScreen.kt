package com.egasmith.presentation.sreeen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.egasmith.core.ui.theme.EffectiveMobileProjectHHTheme
import com.egasmith.presentation.recommendations.RecommendationsScreen
import com.egasmith.presentation.searchbar.SearchBar
import com.egasmith.presentation.vacancies.VacanciesScreen
import com.egasmith.presentation.vacancies.VacancyItem

@Composable
fun MainScreen(modifier: Modifier = Modifier, paddingValues: PaddingValues) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(paddingValues)
    ) {
        SearchBar()
        RecommendationsScreen()
        VacanciesScreen(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    EffectiveMobileProjectHHTheme {
        Scaffold(
            containerColor = Color(0xFF0C0C0C),
            modifier = Modifier.fillMaxSize(),
        ) { innerPadding ->
            MainScreen(paddingValues = innerPadding)
        }
    }
}