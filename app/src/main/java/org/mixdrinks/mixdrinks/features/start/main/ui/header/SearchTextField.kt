package org.mixdrinks.mixdrinks.features.start.main.ui.header

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import org.mixdrinks.mixdrinks.R
import org.mixdrinks.mixdrinks.features.common.ui.widgets.IconTextFieldIcon

@Suppress("MagicNumber")
@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SearchTextField(
    modifier: Modifier,
    onFocusChanged: (isFocused: Boolean) -> Unit,
    searchAction: (searchText: String) -> Unit,
    searchText: String
) {
    var textState by remember { mutableStateOf(searchText) }

    var isFocused by remember { mutableStateOf(false) }
    val keyboardController = LocalSoftwareKeyboardController.current

    TextField(
        modifier = modifier
            .height(50.dp)
            .fillMaxWidth(if (isFocused) 1.0f else 0.9f)
            .padding(all = 0.dp)
            .onFocusChanged { focusState ->
                onFocusChanged(focusState.isFocused)
                isFocused = focusState.isFocused
            },
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.White,
        ),
        textStyle = MaterialTheme.typography.h4,
        singleLine = true,
        value = textState,
        placeholder = { Text(text = stringResource(R.string.search_hint)) },
        shape = RoundedCornerShape(10.dp),
        onValueChange = {
            textState = it
            searchAction(textState)
        },
        trailingIcon = {
            IconTextFieldIcon(text = textState, onClick = {
                textState = ""
                searchAction(textState)
            })
        },
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
        keyboardActions = KeyboardActions(onDone = {
            keyboardController?.hide()
            onFocusChanged(false)
            isFocused = false
        }),
    )
}





