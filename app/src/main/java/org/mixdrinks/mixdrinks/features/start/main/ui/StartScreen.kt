package org.mixdrinks.mixdrinks.features.start.main.ui

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import org.koin.androidx.compose.koinViewModel
import org.mixdrinks.domain.ImageUrlCreators
import org.mixdrinks.dto.CocktailId
import org.mixdrinks.mixdrinks.features.common.ui.ErrorLoadingScreen
import org.mixdrinks.mixdrinks.features.common.ui.LoaderIndicatorScreen
import org.mixdrinks.mixdrinks.features.common.ui.NotFoundScreen
import org.mixdrinks.mixdrinks.features.data.CocktailShort
import org.mixdrinks.mixdrinks.features.start.main.ui.header.Header

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
        Header(
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

@Composable
fun CocktailListItem(modifier: Modifier, item: CocktailShort, onClickAction: (id: Int) -> Unit) {
    Card(
        modifier = modifier
            .clickable { onClickAction(item.cocktailId) }
    ) {
        Row(
            modifier = modifier.padding(10.dp),
        ) {
            AsyncImage(
                model = ImageUrlCreators.createUrl(
                    CocktailId(item.cocktailId), ImageUrlCreators.Size.SIZE_320
                ),
                contentDescription = item.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clip(RoundedCornerShape(corner = CornerSize(16.dp)))
                    .size(100.dp),
            )
            Column(
                modifier = modifier
                    .fillMaxWidth(1f), verticalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    modifier = modifier
                        .padding(start = 10.dp)
                ) {
                    Text(
                        text = item.name,
                        fontWeight = FontWeight.W700,
                        fontSize = 18.sp,
                        color = MaterialTheme.colors.primary,
                    )
                }
            }
        }
    }
}
