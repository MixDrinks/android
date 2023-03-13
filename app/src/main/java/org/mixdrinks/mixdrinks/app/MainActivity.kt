package org.mixdrinks.mixdrinks.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.ui.Modifier
import org.mixdrinks.mixdrinks.features.start.ui.StartScreenViewModel

class MainActivity : ComponentActivity() {
    private val mainViewModel by viewModels<StartScreenViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MixDrinksApp(modifier = Modifier, mainViewModel = mainViewModel)
        }
    }
}


