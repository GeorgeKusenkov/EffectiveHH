package com.egasmith.feature.bottomnavbar

import com.egasmith.core.ui.R

object NavItems {
    val items = listOf(
        BottomNavigationItem(
            title = "Поиск",
            icon = R.drawable.ic_search,
            selected = true
        ),
        BottomNavigationItem(
            title = "Избранное",
            icon = R.drawable.ic_is_favorite,
            selected = false
        ),
        BottomNavigationItem(
            title = "Отклики",
            icon = R.drawable.ic_email,
            selected = false
        ),
        BottomNavigationItem(
            title = "Сообщения",
            icon =R.drawable.ic_profile,
            selected = false
        ),
        BottomNavigationItem(
            title = "Профиль",
            icon = R.drawable.ic_messages,
            selected = false
        )
    )
}