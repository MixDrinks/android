package org.mixdrinks.mixdrinks.features.common.ui.widgets

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Close
import androidx.compose.runtime.Composable


@Composable
fun IconTextFieldIcon(text: String, onClick: () -> Unit) {
    if (text.isNotEmpty()) {
        IconButton(onClick = { onClick() }) {
            Icon(
                imageVector = Icons.Outlined.Close,
                tint = MaterialTheme.colors.secondary,
                contentDescription = null
            )
        }
    }
}

