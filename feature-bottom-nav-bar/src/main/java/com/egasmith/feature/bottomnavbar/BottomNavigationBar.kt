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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.egasmith.core.common.BottomNavViewModel
import com.egasmith.core.ui.theme.Black
import com.egasmith.core.ui.theme.Blue
import com.egasmith.core.ui.theme.Gray
import com.egasmith.core.ui.theme.LightGray
import com.egasmith.feature.navigation.NavScreen

@Composable
fun BottomNavigationBar(
    navController: NavController,
    viewModel: BottomNavViewModel
) {
    val selectedItemIndex by viewModel.selectedItemIndex.collectAsState()
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route

    Column(modifier = Modifier.fillMaxWidth()) {
        HorizontalDivider(color = LightGray)
        NavigationBar(containerColor = Black) {
            NavItems.items.forEachIndexed { index, item ->
                NavigationBarItem(
                    selected = selectedItemIndex == index,
                    onClick = {
                        if (currentRoute != NavScreen.Login.route && currentRoute != NavScreen.Register.route) {
                            viewModel.updateSelectedItemIndex(index)
                            navController.navigate(item.route) {
                                // Очищаем бэкстек, чтобы избежать возврата на предыдущие экраны
                                popUpTo(navController.graph.startDestinationId) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    },
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




