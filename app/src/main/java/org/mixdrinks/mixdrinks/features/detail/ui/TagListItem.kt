package org.mixdrinks.mixdrinks.features.detail.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.mixdrinks.mixdrinks.features.data.CocktailFull

@Composable
fun TagListItem(modifier: Modifier, listTags: List<CocktailFull.Tag>, onClickAction: (id: Int) -> Unit) {
    LazyHorizontalGrid(
        rows = GridCells.Fixed(1),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier.height(50.dp)
    ) {
        items(listTags) { item ->
            Button(
                onClick = { onClickAction(item.id.id) },
                colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primaryVariant),
            ) {
                Text(item.name)
            }
        }
    }
}

