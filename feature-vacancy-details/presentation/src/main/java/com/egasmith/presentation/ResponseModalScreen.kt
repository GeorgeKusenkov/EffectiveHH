package com.egasmith.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.egasmith.core.ui.buttons.GreenConfirmButton
import com.egasmith.core.ui.text.ColoredText
import com.egasmith.core.ui.text.GrayText
import com.egasmith.core.ui.theme.EffectiveMobileProjectHHTheme

@Composable
fun ResponseModalScreen() {
    var isTextFieldVisible by remember { mutableStateOf(false) }
    var userInput by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.padding(0.dp, 18.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(18.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.img_rectangle),
            contentDescription = null
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Image(
                modifier = Modifier.size(50.dp),
                painter = painterResource(id = R.drawable.img_resume_response),
                contentDescription = null
            )
            Spacer(Modifier.size(16.dp))
            Column {
                GrayText("Резюме для отклика")
                Spacer(Modifier.size(4.dp))
                Text("Дизайнер")
            }
        }

        HorizontalDivider(thickness = 2.dp)

        if (!isTextFieldVisible) {
            ColoredText(
                text = "Добавить сопроводительное",
                modifier = Modifier.clickable {
                    isTextFieldVisible = true
                }
            )
        } else {
            BasicTextField(
                value = userInput,
                onValueChange = { userInput = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .height(100.dp),
                decorationBox = { innerTextField ->
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color.LightGray.copy(alpha = 0.1f)),
                        contentAlignment = Alignment.TopStart
                    ) {
                        if (userInput.isEmpty()) {
                            Text(
                                text = "Ваше сопроводительное",
                                color = Color.Gray,
                                modifier = Modifier.padding(8.dp)
                            )
                        }
                        innerTextField()
                    }
                },
                textStyle = androidx.compose.ui.text.TextStyle(color = Color.Gray)
            )
        }

        GreenConfirmButton("Откликнуться")
    }
}

@Preview(showBackground = true)
@Composable
fun ResponseModalScreenPreview() {
    EffectiveMobileProjectHHTheme {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            containerColor = Color(0xFF0C0C0C),
        ) { innerPadding ->
            ResponseModalScreen()
        }

    }
}
