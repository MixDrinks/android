package org.mixdrinks.mixdrinks.features.filter.ui

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import org.koin.androidx.compose.koinViewModel
import org.mixdrinks.mixdrinks.R
import org.mixdrinks.mixdrinks.features.common.ui.ErrorLoadingScreen
import org.mixdrinks.mixdrinks.features.common.ui.LoaderIndicatorScreen
import org.mixdrinks.mixdrinks.features.data.FilterGroupFull


@Composable
fun FilterScreen(
    modifier: Modifier,
    viewModel: FilterScreenViewModel = koinViewModel(),
) {
    val filters by viewModel.uiState.collectAsState()
    when(filters) {
        is FilterScreenViewModel.FilterUiState.Loaded -> {
            val data = (filters as FilterScreenViewModel.FilterUiState.Loaded).itemState
            FilterScreenData(
                modifier = modifier,
                filters = data.filters,
                viewModel = viewModel
            )
        }
        is FilterScreenViewModel.FilterUiState.Loading -> {
            LoaderIndicatorScreen(modifier = modifier)
        }
        else -> {
            val error = filters as FilterScreenViewModel.FilterUiState.Error
            Log.d("Exception", error.message)
            ErrorLoadingScreen(modifier = modifier)
        }
    }
}

@Composable
fun FilterScreenData(
    modifier: Modifier,
    filters: List<FilterGroupFull>,
    viewModel: FilterScreenViewModel,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .height(40.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                modifier = modifier,
                text = stringResource(id = R.string.filter),
                style = MaterialTheme.typography.h1.copy(fontWeight = FontWeight.W700,),
            )
            OutlinedButton(
                onClick = { viewModel.clearFilters() }
            ) {
                Text(
                    text = stringResource(id = R.string.clear),
                    style = MaterialTheme.typography.body1,
                    color = Color.Black
                )
            }
        }
        Spacer(modifier = modifier.padding(top = 10.dp))
        Box(
            modifier = modifier.weight(1f)
        ) {
            LazyColumn {
                items(
                    items = filters,
                    itemContent = {
                        Text(
                            text = it.name,
                            style = MaterialTheme.typography.h2
                        )
                        FilterCategoryItems(
                            modifier = modifier,
                            items = it.filters,
                            viewModel = viewModel
                        )
                    }
                )
            }
        }
        ApplyButton(modifier = modifier)
    }
}

@Composable
fun ApplyButton(modifier: Modifier) {
    Box(
        modifier = modifier
            .background(Color.White)
            .fillMaxWidth()
    ) {
        Button(
            onClick = {  },
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primary),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .height(40.dp)
                .align(Alignment.Center)
        ) {
            Text(
                text = stringResource(id = R.string.apply),
                style = MaterialTheme.typography.h4,
                color = Color.White
            )
        }
    }
}

@Suppress("MagicNumber")
@Composable
fun FilterCategoryItems(
    modifier: Modifier,
    items: List<FilterGroupFull.Filters>,
    viewModel: FilterScreenViewModel
) {
    //val listCheckedFilter by viewModel.listCheckedFilter

    val countRow = if(items.size < 5) 1 else 2
    val heightRow = if(countRow == 1) 40 else 80 // dp
    LazyVerticalGrid (
        columns = GridCells.Fixed(4),
        verticalArrangement = Arrangement.spacedBy(2.dp),
        modifier = modifier
            .height(heightRow.dp)
            .fillMaxWidth(1f),

    ) {
        items(
            items = items,
            itemContent = { item ->
                var isSelected by remember { mutableStateOf(false) }
                OutlinedButton(
                    border = BorderStroke(1.dp, MaterialTheme.colors.primary),
                    shape = RoundedCornerShape(18.dp),
                    onClick = {
                        isSelected = !isSelected
                        viewModel.checkedAction(item.id)
                    },
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = if(isSelected) MaterialTheme.colors.primary else Color.Transparent,
                    )
                ) {
                    Text(
                        text = item.name,
                        style = MaterialTheme.typography.h4,
                        color = if(isSelected) Color.White else MaterialTheme.colors.primary
                    )
                }
            }
        )
    }
}


