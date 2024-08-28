package com.egasmith.presentation.searchbar

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.egasmith.core.common.vacanciesWord
import com.egasmith.core.ui.R
import com.egasmith.core.ui.text.ColoredText
import com.egasmith.core.ui.text.StandardText

@Composable
fun ActiveSearchBar(
    vacancyNum: Int,
    onBackClick: () -> Unit,
    icon: Int = R.drawable.ic_arrow_back,
    placeholderText: String = "Должность, о подходящим вакансиям"
) {
    Column {
        SearchBar(
            icon = icon,
            placeholderText = placeholderText,
            onLeadingIconClick = onBackClick
        )
        Row(
            Modifier
                .fillMaxWidth()
                .padding(0.dp, 8.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            StandardText(
                text = vacancyNum.vacanciesWord(),
                fontSize = 14.sp,
            )
            Spacer(Modifier.weight(1f))
            ColoredText(
                fontSize = 14.sp,
                text = "По соответствию",
                isGreen = false
            )
            Icon(
                painterResource(com.egasmith.presentation.R.drawable.ic_bar),
                tint = Color.Unspecified,
                contentDescription = "Filter"
            )
        }
    }
}