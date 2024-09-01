package com.egasmith.effectivemobileprojecthh.ui.main

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
//import com.egasmith.effectivemobileprojecthh.navigation.AppNavHost
import com.egasmith.feature.bottomnavbar.BottomNavigationBar
import com.egasmith.feature.navigation.AppNavHost
import com.egasmith.feature.navigation.Navigator

@Composable
fun MainScreen(navigator: Navigator) {
    val navController = rememberNavController()
    val viewModel: MainViewModel = hiltViewModel()

    LaunchedEffect(navController) {
        navigator.setNavController(navController)
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = Color(0xFF0C0C0C),
        bottomBar = {
            BottomNavigationBar(
                navController = navController,
                viewModel = viewModel
            )
        }
    ) { innerPadding ->
        AppContent(
            navController = navController,
            innerPadding = innerPadding,
            navigator = navigator
        )
    }
}


@Composable
fun AppContent(
    navController: NavHostController,
    innerPadding: PaddingValues,
    navigator: Navigator
) {
    AppNavHost(
        navController = navController,
        innerPadding = innerPadding,
        navigator = navigator
    )
}