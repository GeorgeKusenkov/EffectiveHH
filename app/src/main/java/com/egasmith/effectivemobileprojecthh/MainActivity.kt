package com.egasmith.effectivemobileprojecthh

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
        setContent {
            EffectiveMobileProjectHHTheme {
                MainScreen(navigator)
            }
        }
    }
}
