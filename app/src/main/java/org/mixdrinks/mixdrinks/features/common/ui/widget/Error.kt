package org.mixdrinks.mixdrinks.features.common.ui.widget

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ErrorWidget(modifier: Modifier, text: String) {
    Row(modifier = modifier
        .fillMaxWidth()
        .fillMaxHeight()
    ) {
        Text(
            text = text
        )
    }
}