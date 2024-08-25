package com.egasmith.presentation.searchbar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.egasmith.core.ui.theme.EffectiveMobileProjectHHTheme
import com.egasmith.core.ui.theme.LightGray
import com.egasmith.core.ui.theme.TintGray
import com.egasmith.presentation.R


@Composable
fun SearchBar() {

    var text by remember { mutableStateOf("") }

    TextField(
        value = text,
        onValueChange = { newText ->
            text = newText
        },
        placeholder = {
            Text(
                text = "Должность, ключевые слова",
                fontSize = 13.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Gray
            )
        },
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = LightGray,
                shape = RoundedCornerShape(14.dp)
            ),

        leadingIcon = {
            Icon(
                painter = painterResource(R.drawable.ic_search), // Используем лямбда-функцию для Icon
                contentDescription = "Search Icon"
            )
        },
        colors = textFieldColors(),
        shape = RoundedCornerShape(14.dp),
    )
}

@Composable
private fun textFieldColors() = OutlinedTextFieldDefaults.colors(
    disabledBorderColor = Color.Transparent,
    cursorColor = Color.White,
    focusedTextColor = Color.White,
    unfocusedTextColor = TintGray,
    unfocusedLabelColor = TintGray,
    focusedLabelColor = TintGray,
)

@Preview(showBackground = true)
@Composable
fun SearchBarPreview() {
    EffectiveMobileProjectHHTheme {
        SearchBar()
    }
}