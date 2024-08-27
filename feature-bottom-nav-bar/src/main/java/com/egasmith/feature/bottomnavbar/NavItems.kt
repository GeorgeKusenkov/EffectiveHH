package com.egasmith.feature.bottomnavbar

import com.egasmith.core.ui.R
import com.egasmith.feature.navigation.BottomNavScreen

object NavItems {
    val items = listOf(
        BottomNavigationItem(
            title = "Поиск",
            icon = R.drawable.ic_search,
            route = BottomNavScreen.Search.route
        ),
        BottomNavigationItem(
            title = "Избранное",
            icon = R.drawable.ic_is_favorite,
            route = BottomNavScreen.Favorites.route
        ),
        BottomNavigationItem(
            title = "Отклики",
            icon = R.drawable.ic_email,
            route = BottomNavScreen.Responses.route
        ),
        BottomNavigationItem(
            title = "Сообщения",
            icon = R.drawable.ic_messages,
            route = BottomNavScreen.Messages.route
        ),
        BottomNavigationItem(
            title = "Профиль",
            icon = R.drawable.ic_profile,
            route = BottomNavScreen.Profile.route
        )
    )
}