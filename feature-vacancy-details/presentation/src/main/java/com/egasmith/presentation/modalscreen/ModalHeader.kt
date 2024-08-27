package com.egasmith.presentation.modalscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.egasmith.core.ui.text.GrayText
import com.egasmith.presentation.R

@Composable
fun ModalHeader() {
    Column {
        Image(
            painter = painterResource(id = R.drawable.img_rectangle),
            contentDescription = null,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier.size(50.dp),
                painter = painterResource(id = R.drawable.img_resume_response),
                contentDescription = null
            )
            Spacer(Modifier.width(16.dp))
            Column {
                GrayText("Резюме для отклика")
                Spacer(Modifier.height(4.dp))
                Text("Дизайнер")
            }
        }
        HorizontalDivider(modifier = Modifier.padding(vertical = 16.dp))
    }
}