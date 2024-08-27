package com.egasmith.presentation.vacancydetails.ui.components.main.questions

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.egasmith.core.ui.theme.LightGray

@Composable
fun QuestionsInfoBlock(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
    cardColor: Color = LightGray,
    cornerRadius: Dp = 20.dp,
    contentPadding: PaddingValues = PaddingValues(10.dp, 8.dp)
) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(containerColor = cardColor),
        shape = RoundedCornerShape(cornerRadius)
    ) {
        Box(modifier = Modifier
            .padding(contentPadding)
        ) {
            content()
        }
    }
}