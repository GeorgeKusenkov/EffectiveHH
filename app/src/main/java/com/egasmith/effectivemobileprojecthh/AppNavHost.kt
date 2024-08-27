package com.egasmith.effectivemobileprojecthh

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.egasmith.feature.navigation.BottomNavScreen
import com.egasmith.feature.navigation.NavScreen
import com.egasmith.feature.navigation.Navigator
import com.egasmith.feature.navigation.NavigatorImpl
import com.egasmith.login.presentation.ui.screen.LoginScreen
import com.egasmith.presentation.vacancydetails.ui.screen.VacancyDetailsScreen
import com.egasmith.presentation.sreeen.MainScreen
import com.egasmith.register.presentation.ui.screen.RegisterScreen
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class) // Install this module in the SingletonComponent
abstract class NavigationModule {

    @Binds
    @Singleton
    abstract fun bindNavigator(
        navigatorImpl: NavigatorImpl
    ): Navigator
}


@Composable
fun AppNavHost(
    navController: NavHostController,
    innerPadding: PaddingValues,
    navigator: Navigator
) {
    NavHost(
        navController = navController,
        startDestination = NavScreen.Login.route,
        modifier = Modifier.padding(innerPadding).padding(16.dp, 0.dp)
    ) {
        loginNavGraph(navigator)
        mainNavGraph(navigator)
        bottomNavGraph(navigator)
    }
}

private fun NavGraphBuilder.loginNavGraph(navigator: Navigator) {
    composable(route = NavScreen.Login.route) {
        LoginScreen(
            onContinueClick = { email ->
                navigator.navigateTo(NavScreen.Register.createRoute(email))
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
                navigator.navigateTo(NavScreen.Main.route)
            }
        )
    }
}

private fun NavGraphBuilder.mainNavGraph(navigator: Navigator) {
    composable(NavScreen.Main.route) {
        MainScreen(
            onVacancyClick = { vacancyId ->
                navigator.navigateTo(NavScreen.VacancyDetails.createRoute(vacancyId))
            }
        )
    }
    composable(
        route = NavScreen.VacancyDetails.route,
        arguments = listOf(navArgument("vacancyId") { type = NavType.StringType })
    ) { backStackEntry ->
        val vacancyId = backStackEntry.arguments?.getString("vacancyId") ?: ""
        VacancyDetailsScreen(vacancyId = vacancyId)
    }
}

private fun NavGraphBuilder.bottomNavGraph(navigator: Navigator) {
    composable(BottomNavScreen.Search.route) {
        MainScreen(
            onVacancyClick = { vacancyId ->
                navigator.navigateTo(NavScreen.VacancyDetails.createRoute(vacancyId))
            }
        )
    }
    composable(BottomNavScreen.Favorites.route) {
        PlaceholderScreen("Избранное")
    }
    composable(BottomNavScreen.Responses.route) {
        PlaceholderScreen("Отклики")
    }
    composable(BottomNavScreen.Messages.route) {
        PlaceholderScreen("Сообщения")
    }
    composable(BottomNavScreen.Profile.route) {
        PlaceholderScreen("Профиль")
    }
}

@Composable
fun PlaceholderScreen(screenName: String) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = screenName, style = MaterialTheme.typography.titleMedium)
    }
}