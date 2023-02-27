package org.mixdrinks.mixdrinks.features.common.ui.widget

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun LoaderIndicator(modifier: Modifier) {
    Row(modifier = modifier
        .fillMaxWidth()
        .fillMaxHeight()
    ) {
        Text(
            text = "Loading..."
        )
    }
}

@Preview
@Composable
fun LoaderIndicatorPreview() {
    LoaderIndicator(Modifier)
}
