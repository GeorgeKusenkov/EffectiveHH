package com.egasmith.feature.navigation

import androidx.navigation.NavController
import javax.inject.Inject

interface Navigator {
    fun setNavController(navController: NavController)
    fun navigateTo(route: String)
    fun navigateToBottomNavScreen(screen: BottomNavScreen)
}

class NavigatorImpl @Inject constructor() : Navigator {
    private lateinit var navController: NavController

    override fun setNavController(navController: NavController) {
        this.navController = navController
    }

    override fun navigateTo(route: String) {
        navController.navigate(route)
    }

    override fun navigateToBottomNavScreen(screen: BottomNavScreen) {
        navController.navigate(screen.route)
    }
}

sealed class BottomNavScreen(val route: String) {
    data object Search: BottomNavScreen("search")
    data object Favorites: BottomNavScreen("favorites")
    data object Responses: BottomNavScreen("responses")
    data object Messages: BottomNavScreen("messages")
    data object Profile: BottomNavScreen("profile")
}