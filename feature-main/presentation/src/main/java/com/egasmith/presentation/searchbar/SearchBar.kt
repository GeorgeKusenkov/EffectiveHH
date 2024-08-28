package com.egasmith.presentation.searchbar

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.egasmith.core.ui.theme.EffectiveMobileProjectHHTheme
import com.egasmith.core.ui.theme.LightGray
import com.egasmith.core.ui.theme.TintGray
import com.egasmith.core.ui.theme.Black

@Composable
fun SearchBar(
    icon: Int,
    placeholderText: String,
    onLeadingIconClick: () -> Unit = {}
) {
    var text by remember { mutableStateOf("") }

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        TextField(
            value = text,
            onValueChange = { newText ->
                text = newText
            },
            placeholder = {
                Text(
                    text = placeholderText,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.Gray
                )
            },
            modifier = Modifier
                .background(
                    color = LightGray,
                    shape = RoundedCornerShape(14.dp)
                )
                .height(50.dp)
                .weight(1f),
            leadingIcon = {
                Icon(
                    modifier = Modifier.clickable { onLeadingIconClick() },
                    painter = painterResource(icon),
                    contentDescription = "Search Icon"
                )
            },
            textStyle = TextStyle(
                fontSize = 13.sp,
                fontWeight = FontWeight.Normal,
                lineHeight = 50.sp
            ),
            colors = textFieldColors(),
            shape = RoundedCornerShape(14.dp),
        )
        Filter()
    }
}

@Composable
private fun textFieldColors() = TextFieldDefaults.colors(
    cursorColor = Color.White,
    focusedTextColor = Color.White,
    unfocusedTextColor = TintGray,
    focusedPlaceholderColor = TintGray,
    unfocusedPlaceholderColor = TintGray,
    focusedContainerColor = Color.Transparent,
    unfocusedContainerColor = Color.Transparent,
    disabledContainerColor = Color.Transparent,
    focusedIndicatorColor = Color.Transparent,
    unfocusedIndicatorColor = Color.Transparent,
    disabledIndicatorColor = Color.Transparent
)

@Preview(showBackground = true)
@Composable
fun ActiveSearchBarPreview() {
    EffectiveMobileProjectHHTheme {
        Column(Modifier.background(Black)) {
//            ActiveSearchBar(vacancyNum = 3)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun InActiveSearchBarPreview() {
    EffectiveMobileProjectHHTheme {
        Column(Modifier.background(Black)) {
            InActiveSearchBar()
        }
    }
}