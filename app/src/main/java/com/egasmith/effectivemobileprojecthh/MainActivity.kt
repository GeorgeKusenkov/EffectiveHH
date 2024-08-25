package com.egasmith.effectivemobileprojecthh

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.egasmith.core.ui.theme.EffectiveMobileProjectHHTheme
import com.egasmith.login.presentation.ui.screen.LoginScreen
import com.egasmith.presentation.vacancies.VacanciesScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EffectiveMobileProjectHHTheme {
                Scaffold(
                    containerColor = Color(0xFF0C0C0C),
                    modifier = Modifier.fillMaxSize(),
                ) { innerPadding ->
                    VacanciesScreen(modifier = Modifier.padding(innerPadding))
//                    LoginScreen(modifier = Modifier.padding(innerPadding))
//                    OffersList(
//                        viewModel = viewModel,
//                        modifier = Modifier.padding(innerPadding)
//                    )
                }
            }
        }
        viewModel.loadOffers()
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )

}

@Composable
fun OffersList(viewModel: MainViewModel, modifier: Modifier = Modifier) {
    val offers by viewModel.offers.observeAsState()
    Text(text = offers.toString())

}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    EffectiveMobileProjectHHTheme {
        Greeting("Android")
    }
}