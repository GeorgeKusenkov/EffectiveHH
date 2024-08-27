package com.egasmith.effectivemobileprojecthh

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.egasmith.feature.navigation.NavScreen
import com.egasmith.login.presentation.ui.screen.LoginScreen
import com.egasmith.presentation.vacancydetails.ui.screen.VacancyDetailsScreen
import com.egasmith.presentation.sreeen.MainScreen
import com.egasmith.register.presentation.ui.screen.RegisterScreen

@Composable
fun AppNavHost(navController: NavHostController, innerPadding: PaddingValues) {
    NavHost(
        navController = navController,
        startDestination = NavScreen.Login.route,
        Modifier.padding(innerPadding).padding(16.dp, 0.dp)
    )
    {

        composable(route = NavScreen.Login.route) {
            LoginScreen(
                onContinueClick = { email ->
                    navController.navigate(NavScreen.Register.createRoute(email)) {
                        popUpTo(NavScreen.Login.route) { inclusive = true }
                    }
                }
            )
        }

        composable(
            route = NavScreen.Register.route,
            arguments = listOf(navArgument("email") { type = NavType.StringType })
        ) { backStackEntry ->
            val email = backStackEntry.arguments?.getString("email") ?: ""
            RegisterScreen(
                email = email,
                onConfirmClick = {
                    navController.navigate(NavScreen.Main.route) {
                        popUpTo(NavScreen.Login.route) { inclusive = true }
                    }
                }
            )
        }

        composable(NavScreen.Main.route) {
            MainScreen(
                onVacancyClick = { vacancyId ->
                    navController.navigate(NavScreen.VacancyDetails.createRoute(vacancyId))
                }
            )
        }

        composable(
            route = NavScreen.VacancyDetails.route,
            arguments = listOf(navArgument("vacancyId") { type = NavType.StringType })
        ) { backStackEntry ->
            val vacancyId = backStackEntry.arguments?.getString("vacancyId") ?: ""
            VacancyDetailsScreen(
                vacancyId = vacancyId,
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}