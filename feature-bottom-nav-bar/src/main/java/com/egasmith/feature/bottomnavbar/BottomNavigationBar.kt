package com.egasmith.feature.bottomnavbar

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.egasmith.core.ui.theme.Black
import com.egasmith.core.ui.theme.Blue
import com.egasmith.core.ui.theme.Gray
import com.egasmith.core.ui.theme.LightGray

@Composable
fun BottomNavigationBar(
    items: List<BottomNavigationItem>,
    selectedItemIndex: Int,
    onItemSelected: (Int) -> Unit
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        HorizontalDivider(color = LightGray)
        NavigationBar(containerColor = Black) {
            items.forEachIndexed { index, item ->
                NavigationBarItem(
                    selected = selectedItemIndex == index,
                    onClick = { onItemSelected(index) },
                    label = {
                        Text(item.title, style = MaterialTheme.typography.labelSmall)
                    },
                    icon = {
                        Icon(
                            painter = painterResource(item.icon),
                            contentDescription = item.title
                        )
                    },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = Blue,
                        unselectedIconColor = Gray,
                        selectedTextColor = Blue,
                        unselectedTextColor = Gray,
                        indicatorColor = Color.Transparent
                    )
                )
            }
        }
    }
}




