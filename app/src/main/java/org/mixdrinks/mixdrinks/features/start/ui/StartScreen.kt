package org.mixdrinks.mixdrinks.features.start.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.mixdrinks.mixdrinks.features.data.Cocktail

@Composable
fun StartScreen(modifier: Modifier, cocktail: List<Cocktail>, onNavigateToDetail: (id: Int) -> Unit) {
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 8.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
        items(
            items = cocktail,
            itemContent = {
                CocktailListItem(item = it, modifier = modifier, onClickAction =  onNavigateToDetail )
            }
        )
    }
}
