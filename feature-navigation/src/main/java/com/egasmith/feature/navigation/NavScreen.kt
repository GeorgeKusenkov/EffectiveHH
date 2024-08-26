package com.egasmith.feature.navigation

sealed class NavScreen(val route: String) {
    data object Login : NavScreen("login")
    data object Register : NavScreen("register/{email}") {
        fun createRoute(email: String) = "register/$email"
    }
    data object Main : NavScreen("main")
    data object VacancyDetails : NavScreen("vacancy_details/{vacancyId}") {
        fun createRoute(vacancyId: String) = "vacancy_details/$vacancyId"
    }
}