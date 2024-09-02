package com.egasmith.presentation.recommendations.ui.items

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.egasmith.core.ui.items.InfoBlock
import com.egasmith.core.ui.theme.Green
import com.egasmith.presentation.recommendations.ui.text.RecommendationText

@Composable
fun RecommendationItemWithButton(
    text: String,
    buttonText: String,
    icon: Int,
    link: String,
    description: String
) {
    val uriHandler = LocalUriHandler.current

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
                RecommendationText(text = text)
                Text(
                    text = buttonText,
                    modifier = Modifier.clickable {
                        uriHandler.openUri(link)
                    },
                    fontSize = 12.sp,
                    color = Green
                )
            }
        })
}