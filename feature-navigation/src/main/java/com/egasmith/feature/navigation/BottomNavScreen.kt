package com.egasmith.feature.navigation

sealed class BottomNavScreen(val route: String) {
    data object Search: BottomNavScreen("search")
    data object Favorites: BottomNavScreen("favorites")
    data object Responses: BottomNavScreen("responses")
    data object Messages: BottomNavScreen("messages")
    data object Profile: BottomNavScreen("profile")
}