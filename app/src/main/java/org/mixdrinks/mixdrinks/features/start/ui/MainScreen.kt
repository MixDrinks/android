package org.mixdrinks.mixdrinks.features.start.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp
import org.mixdrinks.mixdrinks.features.start.data.Cocktail

@Composable
fun StartScreen(cocktail: List<Cocktail>) {
    val scope = rememberCoroutineScope()


    val cocktailMutableList by remember { mutableStateOf(cocktail) }
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {
        items(
            items = cocktailMutableList,
            itemContent = {
                CocktailListItem(item = it)
            }
        )
    }
}
