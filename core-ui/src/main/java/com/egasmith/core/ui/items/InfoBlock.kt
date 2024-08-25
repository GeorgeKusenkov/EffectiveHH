package com.egasmith.core.ui.items

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.egasmith.core.ui.pxToDp
import com.egasmith.core.ui.theme.EffectiveMobileProjectHHTheme
import com.egasmith.core.ui.theme.DarkGray

@Composable
fun InfoBlock(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
    cardColor: Color = DarkGray,
    cornerRadius: Dp = 8.dp,
    contentPadding: PaddingValues = PaddingValues(24.pxToDp(), 16.pxToDp())
) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(containerColor = cardColor),
        shape = RoundedCornerShape(cornerRadius)
    ) {
        Box(modifier = Modifier
            .fillMaxWidth()
            .padding(contentPadding)
        ) {
            content()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun InfoBlockPreview() {
    EffectiveMobileProjectHHTheme {
        InfoBlock(content = {
            Column {
                Text("text")
            }
        })
    }
}