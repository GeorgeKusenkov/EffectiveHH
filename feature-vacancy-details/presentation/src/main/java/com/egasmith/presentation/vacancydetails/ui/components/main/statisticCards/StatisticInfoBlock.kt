package com.egasmith.presentation.vacancydetails.ui.components.main.statisticCards

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
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
fun StatisticInfoBlock(
    number: Int,
    text: String,
    contentDescription: String,
    icon: Int,
) {
    InfoBlock(
        modifier = Modifier.size(180.dp, 60.dp),
        cardColor = DarkGreen,
        content = {
            Box(
                modifier = Modifier.fillMaxSize()
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.Center)
                        .padding(end = 32.dp)
                ) {
                    StandardText(
                        text = "$number $text",
                        lineHeight = 18.sp
                    )
                }
                Icon(
                    painter = painterResource(icon),
                    contentDescription = contentDescription,
                    tint = Color.Unspecified,
                    modifier = Modifier
                        .size(32.dp)
                        .align(Alignment.TopEnd)
                        .padding(top = 8.dp)
                )
            }
        },
        contentPadding = PaddingValues(8.dp, 0.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun StatisticInfoBlock() {
    EffectiveMobileProjectHHTheme {
        StatisticInfoBlock(
            11,
            "человек уже откликнулось",
            "", R.drawable.ic_loocking
        )
    }
}