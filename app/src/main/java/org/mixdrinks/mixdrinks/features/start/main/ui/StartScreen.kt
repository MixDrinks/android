package org.mixdrinks.mixdrinks.features.start.main.ui

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
import org.mixdrinks.mixdrinks.features.common.ui.ErrorLoadingScreen
import org.mixdrinks.mixdrinks.features.common.ui.LoaderIndicatorScreen
import org.mixdrinks.mixdrinks.features.common.ui.NotFoundScreen
import org.mixdrinks.mixdrinks.features.start.main.ui.header.HeaderScreen

@Composable
fun StartScreen(
    modifier: Modifier,
    onNavigateToDetail: (id: Int) -> Unit,
    onNavigateToFilter: () -> Unit,
    onNavigateToStart: () -> Unit,
    viewModel: StartScreenViewModel = koinViewModel()
) {
    val cocktail by viewModel.uiState.collectAsState()
    when (cocktail) {
        is StartScreenViewModel.StartUiState.Loaded -> {
            val data = (cocktail as StartScreenViewModel.StartUiState.Loaded).itemState
            StartScreenData(
                modifier = modifier,
                data = data,
                onNavigateToDetail = onNavigateToDetail,
                onNavigateToFilter = onNavigateToFilter,
                onNavigateToStart = onNavigateToStart,
                viewModel = viewModel
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
@Suppress("LongParameterList")
@Composable
fun StartScreenData(
    modifier: Modifier,
    data: StartItemUiState,
    onNavigateToDetail: (id: Int) -> Unit,
    onNavigateToFilter: () -> Unit,
    onNavigateToStart: () -> Unit,
    viewModel: StartScreenViewModel,
) {
    Column {
        HeaderScreen(
            modifier = modifier,
            onNavigateToFilter = onNavigateToFilter,
            viewModel = viewModel,
            searchText = data.searchText
        )
        if (data.cocktails.isEmpty()) NotFoundScreen(
            modifier = modifier,
            onNavigateToStart = onNavigateToStart
        )
        else {
            LazyColumn(
                contentPadding = PaddingValues(horizontal = 8.dp, vertical = 8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                items(
                    items = data.cocktails,
                    itemContent = {
                        CocktailListItem(
                            item = it,
                            modifier = modifier,
                            onClickAction = onNavigateToDetail
                        )
                    }
                )
            }
        }
    }
}
