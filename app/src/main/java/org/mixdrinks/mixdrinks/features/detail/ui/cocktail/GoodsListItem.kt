package org.mixdrinks.mixdrinks.features.detail.ui.cocktail

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import org.mixdrinks.domain.ImageUrlCreators
import org.mixdrinks.mixdrinks.features.data.CocktailFull

@Suppress("MagicNumber")
@Composable
fun GoodsListItem(
    modifier: Modifier,
    data: DetailItemUiState,
    onClick: (id: Int) -> Unit
) {
    LazyHorizontalGrid(
        rows = GridCells.Fixed(1),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier.height(200.dp)
    ) {
        items(data.cocktail.goods) { item ->
            Card(
                modifier = modifier
                    .clickable { onClick(item.id.id) },
            ) {
                Column(
                    modifier = modifier
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    ImageItem(
                        modifier = modifier,
                        ImageUrlCreators.createUrl(item.id, ImageUrlCreators.Size.SIZE_320)
                    )
                    Row(
                        modifier = modifier
                            .fillMaxWidth(1f),
                        horizontalArrangement = Arrangement.Start
                    ) {
                        Text(
                            style = MaterialTheme.typography.body1,
                            text = item.name
                        )
                    }
                    Row(
                        modifier = modifier
                            .fillMaxWidth(1f),
                        horizontalArrangement = Arrangement.Start
                    ) {
                        Text(
                            text = "${item.amount * data.portions} ${item.unit}",
                            style = MaterialTheme.typography.h4
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun ToolsListItem(
    modifier: Modifier,
    tools: List<CocktailFull.Tool>,
    glassware: CocktailFull.Glassware,
    onClick: (id: Int) -> Unit
) {
    LazyHorizontalGrid(
        rows = GridCells.Fixed(1),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier.height(180.dp)
    ) {
        items(tools) { item ->
            Card(
                modifier = modifier
                    .clickable { onClick(item.id.id) },
            ) {
                Column(
                    modifier = modifier
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    ImageItem(
                        modifier = modifier,
                        ImageUrlCreators.createUrl(
                            item.id,
                            ImageUrlCreators.Size.SIZE_320
                        )
                    )
                    Row(
                        modifier = modifier
                            .fillMaxWidth(1f),
                        horizontalArrangement = Arrangement.Start
                    ) {
                        Text(
                            style = MaterialTheme.typography.body1,
                            text = item.name,
                        )
                    }
                }
            }
        }
    }
}


@Composable
fun ImageItem(modifier: Modifier, url: String) {
    AsyncImage(
        modifier = modifier
            .border(
                BorderStroke(2.dp, MaterialTheme.colors.primary),
                shape = RoundedCornerShape(16.dp),
            )
            .size(150.dp)
            .padding(5.dp),
        model = url,
        contentDescription = null,
        contentScale = ContentScale.Inside,
    )
}

