package com.egasmith.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.egasmith.core.ui.buttons.GreenConfirmButton
import com.egasmith.core.ui.text.GrayText
import com.egasmith.core.ui.text.StandardText
import com.egasmith.core.ui.theme.EffectiveMobileProjectHHTheme
import com.egasmith.core.ui.theme.LightGray

@Composable
fun Questions() {
    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        StandardText("Задайте вопрос работодателю")
        GrayText("Он получит его с откликом на вакансию")
        Question("Где распологается место работы?")
        Question("Какой график работы?")
        Question("Вакансия открыта?")
        Question("Какая оплата труда?")
        Spacer(Modifier.size(6.dp))
        GreenConfirmButton(text = "Откликнуться")
    }
}

@Composable
fun Question(text: String) {
    SpecialInfoBlock(
        content = {
            Text(
                text = text,
                fontSize = 14.sp,
                fontWeight = FontWeight.W500
            )
        }
    )
}

@Composable
fun SpecialInfoBlock(
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

@Preview(showBackground = true)
@Composable
fun QuestionsPreview() {
    EffectiveMobileProjectHHTheme {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            containerColor = Color(0xFF0C0C0C),
        ) { innerPadding ->
            Questions()
        }
    }
}