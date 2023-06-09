package org.mixdrinks.mixdrinks.app

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.mixdrinks.mixdrinks.app.ui.theme.MixDrinksTheme
import org.mixdrinks.mixdrinks.features.common.ui.NotFoundScreen
import org.mixdrinks.mixdrinks.features.data.GoodType
import org.mixdrinks.mixdrinks.features.detail.ui.cocktail.DetailScreen
import org.mixdrinks.mixdrinks.features.detail.ui.good.DetailScreenGood
import org.mixdrinks.mixdrinks.features.start.filter.ui.main.FilterScreen
import org.mixdrinks.mixdrinks.features.start.filter.ui.search.FilterSearchScreen
import org.mixdrinks.mixdrinks.features.start.main.ui.StartScreen

@Suppress("LongMethod")
@Composable
fun MixDrinksApp(modifier: Modifier = Modifier) {
    MixDrinksTheme {
        val navController = rememberNavController()
        NavHost(
            navController = navController, startDestination = Routes.start
        ) {
            composable(Routes.start) {
                StartScreen(modifier = modifier,
                    onNavigateToDetail = { navController.navigate("${Routes.cocktail}/$it") },
                    onNavigateToFilter = { navController.navigate(Routes.filter) },
                    onNavigateToStart = { navController.navigate(Routes.start) })
            }
            composable("${Routes.cocktail}/{${Routes.cocktailId}}") { backStackEntry ->
                val cocktailId = backStackEntry.arguments?.getString(Routes.cocktailId)
                cocktailId?.toInt()?.let { id ->
                    DetailScreen(modifier = modifier,
                        cocktailId = id,
                        onNavigateToStart = { navController.navigate(Routes.start) },
                        onNavigateToDetailGood = { goodType ->
                            navController.navigate("${Routes.good}/${goodType.id}/${goodType.type}")
                        },
                        onBack = { navController.popBackStack() })
                }
            }
            composable("${Routes.good}/{${Routes.goodId}}/{${Routes.goodType}}") { backStackEntry ->
                val goodId = backStackEntry.arguments?.getString(Routes.goodId)
                val goodType = backStackEntry.arguments?.getString(Routes.goodType)

                if (goodId != null && goodType != null)
                    DetailScreenGood(
                        modifier = modifier,
                        goodType = GoodType(id = goodId.toInt(), GoodType.Type.fromString(goodType)),
                        onBack = { navController.popBackStack() })
            }
            composable(Routes.filter) {
                FilterScreen(modifier = modifier,
                    onNavigateToStart = { navController.navigate(Routes.start) },
                    onNavigateToFilterSearch = { navController.navigate("${Routes.filterSearch}/${it}") }
                )
            }
            composable("${Routes.filterSearch}/{${Routes.groupFilterId}}") { backStackEntry ->
                val groupId = backStackEntry.arguments?.getString(Routes.groupFilterId)
                groupId?.toInt()?.let {
                    FilterSearchScreen(
                        modifier = modifier,
                        groupId = it,
                        onNavigateToFilter = { navController.navigate(Routes.filter) },
                    )
                }
            }
            composable(Routes.notFound) {
                NotFoundScreen(modifier = modifier,
                    onNavigateToStart = { navController.navigate(Routes.start) })
            }
        }
    }
}

