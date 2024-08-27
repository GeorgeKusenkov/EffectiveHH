package com.egasmith.effectivemobileprojecthh

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.rememberNavController
import com.egasmith.core.ui.theme.EffectiveMobileProjectHHTheme
import dagger.hilt.android.AndroidEntryPoint
import com.egasmith.feature.bottomnavbar.BottomNavigationBar
import com.egasmith.feature.bottomnavbar.NavItems.items

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EffectiveMobileProjectHHTheme {
                var selectedItemIndex by rememberSaveable { mutableStateOf(0) }
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    containerColor = Color(0xFF0C0C0C),
                    bottomBar = {
                        BottomNavigationBar(
                            items = items,
                            selectedItemIndex = selectedItemIndex,
                            onItemSelected = { index ->
                                selectedItemIndex = index
                            }
                        )
                    }
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