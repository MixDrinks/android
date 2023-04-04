package org.mixdrinks.mixdrinks.features.header.ui

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import org.mixdrinks.mixdrinks.R


@Composable
fun HeaderScreen(modifier: Modifier, onNavigateToFilter: () -> Unit) {
    var isFocusedSearchTextField by remember { mutableStateOf(false) }

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
            FilterAction(modifier = modifier, onNavigateToFilter = onNavigateToFilter)
        }
        if(isFocusedSearchTextField)
            SearchHintContent(modifier = modifier, onClickAction = { Log.d("MyLog", it) })
    }
}
@Composable
private fun FilterAction(modifier: Modifier, onNavigateToFilter: () -> Unit) {
    IconButton(
        modifier = modifier.height(24.dp),
        onClick = { onNavigateToFilter() }
    ) {
        Icon(
            painter = painterResource(id = R.drawable.baseline_tune_24),
            tint = Color.White,
            contentDescription = null
        )
    }
}





