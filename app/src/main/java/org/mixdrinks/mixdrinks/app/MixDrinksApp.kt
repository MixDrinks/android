package org.mixdrinks.mixdrinks.app

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.koin.androidx.compose.getKoin
import org.mixdrinks.mixdrinks.features.fetcher.Fetcher
import org.mixdrinks.mixdrinks.app.ui.theme.MixDrinksTheme
import org.mixdrinks.mixdrinks.features.common.ui.NotFoundScreen
import org.mixdrinks.mixdrinks.features.detail.ui.DetailScreen
import org.mixdrinks.mixdrinks.features.filter.ui.FilterScreen
import org.mixdrinks.mixdrinks.features.start.ui.StartScreen

@Composable
fun MixDrinksApp(modifier: Modifier = Modifier) {
    Fetcher(getKoin().get(), getKoin().get())

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
                    onNavigateToDetail = { navController.navigate("cocktail/$it") },
                    onNavigateToFilter = { navController.navigate("filter") }
                )
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

