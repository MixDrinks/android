package org.mixdrinks.mixdrinks.app

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.koin.androidx.compose.get
import org.mixdrinks.mixdrinks.features.fetcher.Fetcher
import org.mixdrinks.mixdrinks.app.ui.theme.MixDrinksTheme
import org.mixdrinks.mixdrinks.features.common.ui.NotFoundScreen
import org.mixdrinks.mixdrinks.features.detail.ui.cocktail.DetailScreen
import org.mixdrinks.mixdrinks.features.detail.ui.good.DetailScreenGood
import org.mixdrinks.mixdrinks.features.detail.ui.tool.DetailScreenTool
import org.mixdrinks.mixdrinks.features.filter.ui.FilterScreen
import org.mixdrinks.mixdrinks.features.start.ui.StartScreen
@Suppress("LongMethod")
@Composable
fun MixDrinksApp(modifier: Modifier = Modifier) {
    Fetcher(get(), get())

    MixDrinksTheme {
        val navController = rememberNavController()
        NavHost(
            navController = navController,
            startDestination = Routes.start
        ) {
            composable(Routes.start) {
                StartScreen(
                    modifier = modifier,
                    onNavigateToDetail = { navController.navigate("${Routes.cocktail}/$it") },
                    onNavigateToFilter = { navController.navigate(Routes.filter) },
                )
            }
            composable("${Routes.cocktail}/{${Routes.cocktailId}}") {
                    backStackEntry ->
                val cocktailId = backStackEntry.arguments?.getString(Routes.cocktailId)
                cocktailId?.toInt()?.let {
                    DetailScreen(
                        modifier = modifier,
                        cocktailId = it,
                        onNavigateToDetailGood = { navController.navigate("${Routes.good}/$it")},
                        onNavigateToDetailTool = { navController.navigate("${Routes.tool}/$it")},
                        onBack = { navController.popBackStack() }
                    )
                }
            }
            composable("${Routes.good}/{${Routes.goodId}}") {
                    backStackEntry ->
                val goodId = backStackEntry.arguments?.getString(Routes.goodId)
                goodId?.toInt()?.let {
                    DetailScreenGood(
                        modifier = modifier,
                        goodId = it,
                        onBack = { navController.popBackStack() }
                    )
                }
            }
            composable("${Routes.tool}/{${Routes.toolId}}") {
                    backStackEntry ->
                val toolId = backStackEntry.arguments?.getString(Routes.toolId)
                toolId?.toInt()?.let {
                    DetailScreenTool(
                        modifier = modifier,
                        toolId = it,
                        onBack = { navController.popBackStack() }
                    )
                }
            }
            composable(Routes.filter) {
                FilterScreen(
                    modifier = modifier,
                )
            }
            composable(Routes.notFound) {
                NotFoundScreen(
                    modifier = modifier,
                    onNavigateToStart = { navController.navigate(Routes.start) }
                )
            }
        }
    }
}

