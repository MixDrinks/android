package org.mixdrinks.mixdrinks.features.start.ui.filter.ui.search

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import org.koin.androidx.compose.koinViewModel
import org.mixdrinks.domain.ImageUrlCreators
import org.mixdrinks.dto.CocktailId
import org.mixdrinks.mixdrinks.app.ui.theme.GreenAlfa
import org.mixdrinks.mixdrinks.features.common.ui.ErrorLoadingScreen
import org.mixdrinks.mixdrinks.features.common.ui.LoaderIndicatorScreen
import org.mixdrinks.mixdrinks.features.common.ui.widgets.IconTextFieldIcon
import org.mixdrinks.mixdrinks.features.data.FilterGroupFull
import org.mixdrinks.mixdrinks.features.start.ui.filter.ui.main.ApplyButton

@Composable
fun FilterSearchScreen(
    modifier: Modifier,
    viewModel: FilterSearchViewModel = koinViewModel(),
    groupId: Int,
    onNavigateToFilter: () -> Unit
) {
    val filters by viewModel.uiState.collectAsState()
    when (filters) {
        is FilterSearchViewModel.FilterUiState.Loaded -> {
            val data = (filters as FilterSearchViewModel.FilterUiState.Loaded).itemState
            FilterSearchScreenData(
                modifier = modifier,
                filters = data.filters.first { it.id == groupId }.filters,
                onNavigateToFilter = onNavigateToFilter,
                viewModel = viewModel
            )
        }

        is FilterSearchViewModel.FilterUiState.Loading -> {
            LoaderIndicatorScreen(modifier = modifier)
        }

        else -> {
            val error = filters as FilterSearchViewModel.FilterUiState.Error
            Log.d("Exception", error.message)
            ErrorLoadingScreen(modifier = modifier)
        }
    }
}

@Composable
fun FilterSearchScreenData(
    modifier: Modifier,
    onNavigateToFilter: () -> Unit,
    filters: List<FilterGroupFull.Filter>,
    viewModel: FilterSearchViewModel
) {
    Box(
        modifier = modifier
            .background(Color.Gray)
            .padding(top = 23.dp)
            .clip(RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp))

    ) {
        Column(
            modifier = modifier
                .background(Color.White)
                .fillMaxSize()
                .padding(horizontal = 12.dp),
        ) {
            SearchTextField(modifier = modifier)

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

            }
            Box(
                modifier = Modifier
                    .weight(1f)
                    .padding(vertical = 10.dp)
            ) {
                LazyColumn {
                    items(
                        items = filters,
                        itemContent = { filters ->
                            FilterItem(
                                modifier = modifier, filter = filters,
                                onClick = { viewModel.checkedAction(it) }
                            )
                        })
                }
            }
            ApplyButton(modifier = modifier, onClick = { onNavigateToFilter() })
        }
    }
}

@Composable
fun SearchTextField(modifier: Modifier) {
    var textState by rememberSaveable { mutableStateOf("") }

    TextField(
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.White,
            textColor = Color.Black,
            cursorColor = MaterialTheme.colors.primary,
            focusedIndicatorColor = MaterialTheme.colors.primary,
            unfocusedIndicatorColor = MaterialTheme.colors.primary,
            focusedLabelColor = MaterialTheme.colors.primary,
        ),
        value = textState,
        onValueChange = {
            textState = it
        },
        modifier = modifier
            .fillMaxWidth()
            .height(50.dp),
        singleLine = true,
        trailingIcon = {
            IconTextFieldIcon(text = textState, onClick = {
                textState = ""
            })
        },
    )
}

@Composable
private fun FilterItem(
    modifier: Modifier, filter: FilterGroupFull.Filter, onClick: (id: Int) -> Unit
) {
    OutlinedButton(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 5.dp),
        contentPadding = PaddingValues(0.dp),
        border = BorderStroke(1.dp, MaterialTheme.colors.primary),
        shape = RoundedCornerShape(8.dp),
        onClick = {
            onClick(filter.id)
        },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = if (filter.checked) GreenAlfa else Color.Transparent,
        )
    ) {
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = ImageUrlCreators.createUrl(
                    CocktailId(filter.id), ImageUrlCreators.Size.SIZE_320
                ),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clip(RoundedCornerShape(corner = CornerSize(8.dp)))
                    .size(70.dp),
            )
            Spacer(modifier = modifier.width(10.dp))
            Text(
                modifier = modifier.weight(1f),
                text = filter.name,
                style = MaterialTheme.typography.h3,
            )
            Box(
                modifier = modifier
                    .height(24.dp)
                    .widthIn(min = 48.dp)
                    .padding(end = 8.dp)
                    .clip(shape = RoundedCornerShape(size = 16.dp))
                    .background(MaterialTheme.colors.primary), contentAlignment = Alignment.Center
            ) {
                Text(
                    modifier = modifier.padding(horizontal = 2.dp),
                    text = filter.cocktailIds.size.toString(),
                    style = MaterialTheme.typography.h3,
                    color = Color.White,
                )
            }
        }
    }
}
