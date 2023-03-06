package org.mixdrinks.mixdrinks.features.header.ui

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Close
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.mixdrinks.mixdrinks.R


@Preview(showBackground = true)
@Composable
fun HeaderScreenPreview() {
    HeaderScreen(modifier = Modifier)
}

@Composable
fun HeaderScreen(modifier: Modifier) {
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
            SortableAction(modifier = modifier)
            FilterAction(modifier = modifier)
        }
        if(isFocusedSearchTextField)
            SearchHintContent(modifier = modifier, onClickAction = { Log.d("MyLog", it) })
    }

}

@Composable
fun SearchTextField(modifier: Modifier, onFocusChanged: (isFocused: Boolean) -> Unit) {
    var textState by remember { mutableStateOf("") }
    var isFocused by remember { mutableStateOf(false) }

    TextField (
        modifier = modifier
            .height(50.dp)
            .fillMaxWidth(if (isFocused) 1.0f else 0.8f)
            .padding(all = 0.dp)
            .onFocusChanged { it ->
                onFocusChanged(it.isFocused)
                isFocused = it.isFocused
            },
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.White,
        ),
        textStyle = MaterialTheme.typography.h4,
        singleLine = true,
        value = textState,
        placeholder = { Text(text = stringResource(R.string.search_hint)) },
        shape = RoundedCornerShape(10.dp),
        onValueChange = { textState = it },
        trailingIcon = {
            IconTextFieldIcon(
                text = textState,
                onClick = { textState = "" }
            )
        }
    )
}

@Composable
private fun IconTextFieldIcon(text: String, onClick: () -> Unit) {
    if (text.isNotEmpty()) {
        IconButton(
            onClick = { onClick() }
        ) {
            Icon(
                imageVector = Icons.Outlined.Close,
                tint = MaterialTheme.colors.secondary,
                contentDescription = null
            )
        }
    }
}

@Composable
private fun SortableAction(modifier: Modifier) {
    IconButton(
        modifier = modifier.height(24.dp),
        onClick = { Log.d("MyLog", "onClickIconButton") }
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




