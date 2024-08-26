package com.egasmith.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.egasmith.core.ui.items.InfoBlock
import com.egasmith.core.ui.text.StandardText
import com.egasmith.core.ui.text.VacancyText
import com.egasmith.core.ui.theme.EffectiveMobileProjectHHTheme
import com.egasmith.core.ui.theme.Gray
import com.egasmith.presentation.R

@Composable
fun CompanyInfo(
    companyTitle: String,
    city: String,
    street: String
) {
    InfoBlock(
        contentPadding = PaddingValues(20.dp, 10.dp),
        content = {
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    VacancyText(text = companyTitle)
                    Spacer(Modifier.size(10.dp))
                    Icon(
                        painter = painterResource(com.egasmith.core.ui.R.drawable.ic_ok),
                        contentDescription = null,
                        tint = Gray
                    )
                }

                Image(
                    modifier = Modifier.fillMaxWidth(),
                    painter = painterResource(R.drawable.img_company_map_location),
                    contentDescription = null,
                    contentScale = ContentScale.FillWidth
                )

                StandardText("$city, $street")
            }
        }
    )

}

@Preview(showBackground = true)
@Composable
fun CompanyInfoPreview() {
    EffectiveMobileProjectHHTheme {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            containerColor = Color(0xFF0C0C0C),
        ) { innerPadding ->
            CompanyInfo(
                "Мобирикс",
                "Минск",
                "Бирюзова, 5"
            )
        }

    }
}