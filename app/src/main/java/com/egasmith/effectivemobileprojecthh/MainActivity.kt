package com.egasmith.effectivemobileprojecthh

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.rememberNavController
import com.egasmith.core.ui.theme.EffectiveMobileProjectHHTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EffectiveMobileProjectHHTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    containerColor = Color(0xFF0C0C0C),
                ) { innerPadding ->
                    AppContent(innerPadding = innerPadding)
                }
            }
        }
    }
}

@Composable
fun AppContent(innerPadding: PaddingValues) {
    val navController = rememberNavController()
    AppNavHost(navController = navController, innerPadding = innerPadding)
}