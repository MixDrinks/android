package org.mixdrinks.mixdrinks.app

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import org.mixdrinks.mixdrinks.app.ui.theme.MixDrinksTheme
import org.mixdrinks.mixdrinks.features.start.ui.StartScreen
import org.mixdrinks.mixdrinks.features.start.ui.StartScreenViewModel

class MainActivity : ComponentActivity() {
    private val mainViewModel by viewModels<StartScreenViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MixDrinksTheme {
                Log.d("MyLog", "MixDrinksTheme")
                StartScreen(mainViewModel.cocktailListResponse)
                mainViewModel.getCocktail(0)
            }
        }
    }
}