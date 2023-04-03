package org.mixdrinks.mixdrinks.features.detail.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import org.mixdrinks.mixdrinks.features.data.CocktailFull
import org.mixdrinks.mixdrinks.utils.ImageUrlCreators

@Suppress("MagicNumber")
@Composable
fun GoodsListItem(modifier: Modifier, goods: List<CocktailFull.Good>, onCLick: () -> Unit) {
    LazyHorizontalGrid(
        rows = GridCells.Fixed(1),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier.height(240.dp)
    ) {
        items(goods) { item ->
            Card(
                modifier = modifier
                    .clickable { onCLick() },
            ) {
                Column(
                    modifier = modifier
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    imageItem(modifier = modifier,
                        ImageUrlCreators.createUrl(item.id, ImageUrlCreators.SizeConverter.getSizeForImage(190))
                    )
                    HeaderText(
                        modifier = modifier,
                        text = item.name,
                        textStyle = MaterialTheme.typography.body1
                    )
                    HeaderText(
                        modifier = modifier,
                        text = "${item.amount} ${item.unit}",
                        textStyle = MaterialTheme.typography.h4
                    )

                }
            }
        }
    }
}

@Composable
fun ToolsListItem(modifier: Modifier, tools: List<CocktailFull.Tool>, onCLick: () -> Unit) {
    LazyHorizontalGrid(
        rows = GridCells.Fixed(1),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier.height(240.dp)
    ) {
        items(tools) { item ->
            Card(
                modifier = modifier
                    .clickable { onCLick() },
            ) {
                Column(
                    modifier = modifier
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    imageItem(modifier = modifier,
                        ImageUrlCreators.createUrl(item.id, ImageUrlCreators.SizeConverter.getSizeForImage(190))
                    )
                    HeaderText(
                        modifier = modifier,
                        text = item.name,
                        textStyle = MaterialTheme.typography.body1
                    )
                }
            }
        }
    }
}

@Composable
fun imageItem(modifier:Modifier, url: String) {
    AsyncImage(
        modifier = modifier
            .border(
                BorderStroke(2.dp, MaterialTheme.colors.primaryVariant),
                shape = RoundedCornerShape(16.dp),
            )
            .size(190.dp)
            .padding(5.dp),
        model = url,
        contentDescription = null,
        contentScale = ContentScale.Inside,
    )
}