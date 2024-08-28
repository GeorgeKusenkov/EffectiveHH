package com.egasmith.presentation.searchbar

import androidx.compose.runtime.Composable
import com.egasmith.core.ui.R

@Composable
fun InActiveSearchBar(
    icon: Int = R.drawable.ic_search,
    placeholderText: String = "Должность, ключевые слова"
) {
    SearchBar(icon, placeholderText)
}