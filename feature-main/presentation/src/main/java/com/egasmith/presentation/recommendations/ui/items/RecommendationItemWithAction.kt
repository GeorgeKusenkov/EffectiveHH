package com.egasmith.presentation.recommendations.ui.items

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.egasmith.core.ui.items.InfoBlock
import com.egasmith.core.ui.text.ColoredText
import com.egasmith.core.ui.theme.EffectiveMobileProjectHHTheme
import com.egasmith.presentation.R
import com.egasmith.presentation.recommendations.ui.text.RecommendationText

@Composable
fun SimpleRecommendationItemWithAction(
    text: String,
    icon: Int,
    description: String
) {
    InfoBlock(
        modifier = Modifier.size(132.dp, 120.dp),
        contentPadding = PaddingValues(6.dp, 8.dp),
        content = {
            Column {
                Icon(
                    modifier = Modifier.size(32.dp),
                    painter = painterResource(icon),
                    contentDescription = description,
                    tint = Color.Unspecified
                )

                Spacer(Modifier.size(12.dp))
                RecommendationText(text)
                ColoredText("Поднять")
            }
        })
}

@Preview(showBackground = true)
@Composable
fun SimpleRecommendationItemWithActionPreview() {
    EffectiveMobileProjectHHTheme {
        SimpleRecommendationItemWithAction(
            text = "Поднять резюме в поиске",
            icon = R.drawable.ic_resume_up,
            description = "location icon"
        )
    }
}