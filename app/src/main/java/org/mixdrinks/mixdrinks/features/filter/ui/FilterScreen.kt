package org.mixdrinks.mixdrinks.features.filter.ui

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import org.mixdrinks.mixdrinks.R
import org.mixdrinks.mixdrinks.features.data.filters.FilterProviderMock
import org.mixdrinks.mixdrinks.features.data.filters.Item


@Composable
fun FilterScreen(modifier: Modifier, onNavigateBackStack: () -> Unit ) {
    val filters = FilterProviderMock().getFilters()

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
            Image(
                painter = painterResource(id = R.drawable.baseline_close_24),
                contentDescription = null,
                modifier = modifier
                    .clickable {
                        onNavigateBackStack()
                    }
                    .size(36.dp)
            )
            OutlinedButton(
                onClick = { Log.d("MyLog", "FilterScreen -> Clear") }
            ) {
                Text(
                    text = stringResource(id = R.string.clear ),
                    style = MaterialTheme.typography.body1,
                    color = Color.Black
                )
            }
        }
        Text(
            modifier = modifier,
            text = stringResource(id = R.string.filter),
            style = MaterialTheme.typography.h1.copy(fontWeight = FontWeight.W600,),
        )
        LazyColumn() {
            items(
                items = filters,
                itemContent = {
                    Text(
                        text = it.name,
                        style = MaterialTheme.typography.h2
                    )
                    FilterCategoryItem(modifier = modifier, items = it.items)
                }
            )
        }
    }
}

@Suppress("MagicNumber")
@Composable
fun FilterCategoryItem(modifier: Modifier, items: List<Item>) {
    val countRow = if(items.size < 5) 1 else 2
    val heightRow = if(countRow == 1) 40 else 80 // dp
    LazyHorizontalGrid(
        rows = GridCells.Fixed(countRow),
        horizontalArrangement = Arrangement.spacedBy(2.dp),
        verticalArrangement = Arrangement.spacedBy(2.dp),
        modifier = modifier.height(heightRow.dp)
    ) {
        items(
            items = items,
            itemContent = {
                var isBackground by remember { mutableStateOf(false) }

                OutlinedButton(
                    border = BorderStroke(1.dp, MaterialTheme.colors.primaryVariant),
                    shape = RoundedCornerShape(18.dp),
                    onClick = { isBackground = !isBackground },
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = if(isBackground) MaterialTheme.colors.primaryVariant else Color.Transparent,
                    )
                ) {
                    Text(
                        text = it.name,
                        style = MaterialTheme.typography.h4,
                        color = if(isBackground) Color.White else MaterialTheme.colors.primaryVariant
                    )
                }
            }
        )
    }
}

