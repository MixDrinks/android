package org.mixdrinks.mixdrinks.features.header.ui

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.mixdrinks.mixdrinks.R


@Composable
fun HeaderScreen(modifier: Modifier) {
    var isFocusedSearchTextField by remember { mutableStateOf(false) }
    var isSortableOpenContent by remember { mutableStateOf(false) }

    Column {
        Row(
            modifier = modifier
                .background(MaterialTheme.colors.primaryVariant)
                .fillMaxWidth(1f)
                .height(62.dp)
                .padding(start = 8.dp, end = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            SearchTextField(modifier = modifier) { isFocusedSearchTextField = it }
            SortableAction(modifier = modifier, onClick = { isSortableOpenContent = !isSortableOpenContent })
            FilterAction(modifier = modifier)
        }
        if(isFocusedSearchTextField)
            SearchHintContent(modifier = modifier, onClickAction = { Log.d("MyLog", it) })
    }

    if(isSortableOpenContent)
        SortableContent(modifier = modifier)
}

@Preview(showBackground = true)
@Composable
fun SortableContentPreview() {
    SortableContent(Modifier)
}

@Composable
fun SortableContent(modifier: Modifier) {
    Box(modifier = modifier
        .size(width = 200.dp, height = 100.dp)
        .background(Color.Green)
        .clip(RoundedCornerShape(12.dp))

    )
}

@Composable
private fun SortableAction(modifier: Modifier, onClick: () -> Unit) {
    IconButton(
        modifier = modifier.height(24.dp),
        onClick = { onClick() }
    ) {
        Icon(
            painter = painterResource(id = R.drawable.baseline_sort_24),
            tint = Color.White,
            contentDescription = null
        )
    }
}

@Composable
private fun FilterAction(modifier: Modifier) {
    IconButton(
        modifier = modifier.height(24.dp),
        onClick = { Log.d("MyLog", "onClickIconButton") }
    ) {
        Icon(
            painter = painterResource(id = R.drawable.baseline_tune_24),
            tint = Color.White,
            contentDescription = null
        )
    }
}





