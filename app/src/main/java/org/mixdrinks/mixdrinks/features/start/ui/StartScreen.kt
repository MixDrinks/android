package org.mixdrinks.mixdrinks.features.start.ui

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.koin.androidx.compose.koinViewModel
import org.mixdrinks.mixdrinks.database.dao.CocktailShort
import org.mixdrinks.mixdrinks.features.common.ui.ErrorLoadingScreen
import org.mixdrinks.mixdrinks.features.common.ui.LoaderIndicatorScreen
import org.mixdrinks.mixdrinks.features.header.ui.HeaderScreen

@Composable
fun StartScreen(
    modifier: Modifier,
    onNavigateToDetail: (id: Int) -> Unit,
    onNavigateToFilter: () -> Unit,
    viewModel: StartScreenViewModel = koinViewModel()
) {
    val cocktail by viewModel.uiState.collectAsState()
    when(cocktail) {
        is StartScreenViewModel.StartUiState.Loaded -> {
            val data = (cocktail as StartScreenViewModel.StartUiState.Loaded).itemState
            StartScreenData(
                modifier = modifier,
                cocktails = data.cocktails,
                onNavigateToDetail = onNavigateToDetail,
                onNavigateToFilter = onNavigateToFilter,
            )
        }
        is StartScreenViewModel.StartUiState.Loading -> {
            LoaderIndicatorScreen(modifier = modifier)
        }
        is StartScreenViewModel.StartUiState.Error -> {
            val error = cocktail as StartScreenViewModel.StartUiState.Error
            Log.d("Exception", error.message)
            ErrorLoadingScreen(modifier = modifier)
        }
    }
}
@Suppress("UnusedPrivateMember")
@Composable
fun StartScreenData(
    modifier: Modifier,
    cocktails: List<CocktailShort>,
    onNavigateToDetail: (id: Int) -> Unit,
    onNavigateToFilter: () -> Unit,
) {
    Column {
        HeaderScreen(modifier = modifier, onNavigateToFilter = onNavigateToFilter)
        LazyColumn(
            contentPadding = PaddingValues(horizontal = 8.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            items(
                items = cocktails,
                itemContent = {
                    CocktailListItem(item = it, modifier = modifier, onClickAction =  onNavigateToDetail )
                }
            )
        }
    }

}

