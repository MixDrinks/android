package org.mixdrinks.mixdrinks.features.start.filter.ui.main

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
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
import org.mixdrinks.mixdrinks.features.data.SelectedFilter
import java.util.Locale

@Composable
fun FilterScreen(
    modifier: Modifier,
    viewModel: FilterScreenViewModel = koinViewModel(),
    onNavigateToStart: () -> Unit,
    onNavigateToFilterSearch: (groupId: Int) -> Unit
) {
    val filters by viewModel.uiState.collectAsState()
    when (filters) {
        is FilterScreenViewModel.FilterUiState.Loaded -> {
            val data = (filters as FilterScreenViewModel.FilterUiState.Loaded).itemState
            FilterScreenData(
                modifier = modifier,
                filters = data.filters,
                viewModel = viewModel,
                onClickButtonApplyAction = onNavigateToStart,
                onClickButtonAddAction = onNavigateToFilterSearch
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

@OptIn(ExperimentalLayoutApi::class)
@Suppress("LongMethod", "MagicNumber")
@Composable
fun FilterScreenData(
    modifier: Modifier,
    filters: List<FilterGroupFull>,
    viewModel: FilterScreenViewModel,
    onClickButtonApplyAction: () -> Unit,
    onClickButtonAddAction: (groupId: Int) -> Unit
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
                style = MaterialTheme.typography.h1.copy(fontWeight = FontWeight.W700),
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

        Row(
            modifier = modifier.weight(1f)
        ) {
            LazyColumn {
                items(
                    items = filters.sortedBy { it.filters.size },
                    itemContent = { filterGroup ->
                        Text(
                            text = filterGroup.name,
                            style = MaterialTheme.typography.h2
                        )
                        FiltersItem(
                            modifier = modifier,
                            filtersGroup = filterGroup,
                            viewModel = viewModel,
                            onClickButtonAddAction = onClickButtonAddAction
                        )
                    }
                )
            }
        }
        ApplyButton(modifier = modifier, onClick = onClickButtonApplyAction)
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun FiltersItem(
    modifier: Modifier,
    filtersGroup: FilterGroupFull,
    viewModel: FilterScreenViewModel,
    onClickButtonAddAction: (groupId: Int) -> Unit
) {
    FlowRow(modifier = modifier) {
        when {
            (filtersGroup.filters.size < 20) -> {
                filtersGroup.filters.forEach { item ->
                    ItemFlowRow(
                        item,
                        onClick = { filterId ->
                            viewModel.checkedAction(
                                SelectedFilter(
                                    filterId = filterId,
                                    filterGroupId = filtersGroup.id,
                                )
                            )
                        }
                    )
                }
            }

            else -> {
                filtersGroup.filters.filter { it.checked }.forEach { item ->
                    ItemFlowRow(
                        item,
                        onClick = { filterId ->
                            viewModel.checkedAction(
                                SelectedFilter(
                                    filterId = filterId,
                                    filterGroupId = filtersGroup.id,
                                )
                            )
                        }
                    )
                }
                AddButton(
                    modifier = modifier,
                    text = filtersGroup.name,
                    onClick = { onClickButtonAddAction(filtersGroup.id) }
                )
            }
        }
    }
}


@Composable
private fun ItemFlowRow(item: FilterGroupFull.Filter, onClick: (id: Int) -> Unit) {
    OutlinedButton(
        border = BorderStroke(1.dp, MaterialTheme.colors.primary),
        shape = RoundedCornerShape(18.dp),
        onClick = {
            onClick(item.id)
        },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = if (item.checked) MaterialTheme.colors.primary else Color.Transparent,
        )
    ) {
        Text(
            text = item.name,
            style = MaterialTheme.typography.h4,
            color = if (item.checked) Color.White else MaterialTheme.colors.primary
        )
    }
}

@Composable
fun ApplyButton(modifier: Modifier, onClick: () -> Unit) {
    Box(
        modifier = modifier
            .background(Color.White)
            .fillMaxWidth()
    ) {
        Button(
            onClick = { onClick() },
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

@Composable
fun AddButton(modifier: Modifier, text: String, onClick: () -> Unit) {
    Box(
        modifier = modifier
            .background(Color.White)
            .fillMaxWidth()
    ) {
        OutlinedButton(
            onClick = { onClick() },
            border = BorderStroke(1.dp, MaterialTheme.colors.primary),
            shape = RoundedCornerShape(18.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .height(40.dp)
                .align(Alignment.Center)
        ) {
            Text(
                text = "${stringResource(id = R.string.add)} ${text.lowercase(Locale.ROOT)} ${
                    stringResource(
                        id = R.string.to_filter
                    ).lowercase()
                }",
                style = MaterialTheme.typography.h5,
                color = Color.Black
            )
        }
    }
}


