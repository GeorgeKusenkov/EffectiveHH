package com.egasmith.effectivemobileprojecthh.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.egasmith.core.ui.theme.EffectiveMobileProjectHHTheme
import dagger.hilt.android.AndroidEntryPoint
import com.egasmith.feature.navigation.Navigator
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var navigator: Navigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Включаем Edge-to-Edge режим
        WindowCompat.setDecorFitsSystemWindows(window, false)

        // Делаем иконки статус бара светлыми
        WindowInsetsControllerCompat(window, window.decorView).isAppearanceLightStatusBars = false

        setContent {
            EffectiveMobileProjectHHTheme {
                MainScreen(navigator)
            }
        }
    }
}
