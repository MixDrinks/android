package org.mixdrinks.mixdrinks.app

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import kotlinx.coroutines.runBlocking
import org.mixdrinks.mixdrinks.app.ui.theme.MixDrinksTheme
import org.mixdrinks.mixdrinks.features.start.ui.StartScreen
import org.mixdrinks.mixdrinks.features.start.data.CocktailProvider
import org.mixdrinks.mixdrinks.features.start.data.CocktailsResponse
import org.mixdrinks.mixdrinks.features.start.ui.MainViewModel

class MainActivity : ComponentActivity() {
    private val mainViewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            MixDrinksTheme {
                StartScreen(mainViewModel.cocktailResponse.cocktails)
                mainViewModel.getCocktail(0)
            }

        }
    }

}