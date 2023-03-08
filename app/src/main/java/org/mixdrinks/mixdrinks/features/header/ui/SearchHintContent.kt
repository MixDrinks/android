package org.mixdrinks.mixdrinks.features.header.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun SearchHintContent(modifier: Modifier, listHints: List<String> = listItems, onClickAction: (item: String) -> Unit) {
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 8.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(listHints) { item ->
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .clickable {
                    onClickAction(item)
                }
            ) {
                Text(
                    color = MaterialTheme.colors.primaryVariant,
                    style = MaterialTheme.typography.h3,
                    text = item
                )
            }

        }
    }
}

private val listItems = listOf(
    "Джин тонік",
    "Джин тонік 2",
    "Джин тонік 3",
)
