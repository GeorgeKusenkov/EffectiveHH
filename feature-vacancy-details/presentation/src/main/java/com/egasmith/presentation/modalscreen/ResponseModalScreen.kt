package com.egasmith.presentation.modalscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.egasmith.core.ui.text.ColoredText
import com.egasmith.core.ui.theme.Black

@Composable
fun ResponseModalScreen(
    initialQuestion: String?,
    onDismiss: () -> Unit
) {
    var userInput by remember { mutableStateOf(initialQuestion ?: "") }

    Dialog(onDismissRequest = onDismiss) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = Black,
                    shape = RoundedCornerShape(16.dp)
                )
                .padding(16.dp)
        ) {
            ModalHeader()

            CoverLetterInputField(
                userInput = userInput,
                onInputChange = { userInput = it }
            )

            Spacer(modifier = Modifier.height(16.dp))

            ConfirmButton(
                text = "Откликнуться",
                onClick = onDismiss
            )
        }
    }
}


@Composable
fun CoverLetterInputField(userInput: String, onInputChange: (String) -> Unit) {
    BasicTextField(
        value = userInput,
        onValueChange = onInputChange,
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp),
        textStyle = TextStyle(color = Color.White),
        cursorBrush = SolidColor(Color.White),
        decorationBox = { innerTextField ->
            Box {
                if (userInput.isEmpty()) {
                    Text("Введите текст сопроводительного письма", color = Color.Gray)
                }
                innerTextField()
            }
        }
    )
}

@Composable
fun BottomSheetContent(
    onDismiss: () -> Unit,
    onAddCoverLetter: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black.copy(alpha = 0.5f))
            .clickable(onClick = onDismiss) // Закрываем при клике на фон
    ) {
        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .background(Black, shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
                .padding(16.dp)
                .clickable(onClick = {})
        ) {
            ModalHeader()

            ColoredText(
                text = "Добавить сопроводительное",
                modifier = Modifier.clickable(onClick = onAddCoverLetter)
            )

            Spacer(modifier = Modifier.height(16.dp))

            ConfirmButton(
                text = "Откликнуться",
                onClick = onDismiss
            )
        }
    }
}

