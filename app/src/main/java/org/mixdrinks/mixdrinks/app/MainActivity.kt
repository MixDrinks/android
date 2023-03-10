package org.mixdrinks.mixdrinks.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.mixdrinks.mixdrinks.app.ui.theme.MixDrinksTheme
import org.mixdrinks.mixdrinks.features.common.ui.NotFoundScreen
import org.mixdrinks.mixdrinks.features.detail.ui.DetailScreen
import org.mixdrinks.mixdrinks.features.filter.ui.FilterScreen
import org.mixdrinks.mixdrinks.features.start.ui.StartScreen
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
@Composable
fun MixDrinksApp(
    modifier: Modifier = Modifier,
    mainViewModel: StartScreenViewModel = StartScreenViewModel(),
) {
    MixDrinksTheme {
        val navController = rememberNavController()
        NavHost(
            navController = navController,
            startDestination = "start"
        ) {
            composable("start")
            {
                StartScreen(
                    modifier = modifier,
                    mainViewModel.cocktailListResponse,
                    onNavigateToDetail = { navController.navigate("cocktail/$it") },
                    onNavigateToFilter = { navController.navigate("filter") }
                )
                mainViewModel.getCocktail(0)
            }
            composable("cocktail/{cocktailId}") {
                backStackEntry ->
                    val cocktailId = backStackEntry.arguments?.getString("cocktailId")
                    cocktailId?.toInt()?.let {
                        DetailScreen(
                            modifier = modifier,
                            cocktailId = it,
                        )
                    }
            }
            composable("filter") {
                FilterScreen(
                    modifier = modifier,
                    onNavigateBackStack = { navController.popBackStack() }
                )
            }
            composable("not_found") {
                NotFoundScreen(
                    modifier = modifier,
                    onNavigateToStart = { navController.navigate("start") }
                )
            }
        }
    }
}

