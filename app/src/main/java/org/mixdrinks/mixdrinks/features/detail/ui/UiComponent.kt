package org.mixdrinks.mixdrinks.features.detail.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import org.mixdrinks.mixdrinks.R

@Composable
fun Header(modifier: Modifier, text: String, onClick: () -> Unit) {
    Column {
        Row(
            modifier = modifier
                .background(MaterialTheme.colors.primary)
                .fillMaxWidth()
                .height(52.dp),
        ) {
            Box(
                modifier = modifier.size(52.dp)
                    .clickable {
                        onClick()
                    }
            ) {
                Image(
                    modifier = modifier
                        .align(Alignment.Center)
                        .size(32.dp)
                        .padding(start = 12.dp),
                    painter = painterResource(R.drawable.baseline_arrow_back_ios_24),
                    contentDescription = "Test"
                )
            }
            Text(
                modifier = modifier.padding(start = 4.dp)
                    .align(Alignment.CenterVertically),
                color = Color.White,
                text = text,
                style = MaterialTheme.typography.h2,
                softWrap = false,
                maxLines = 1,
            )
        }
    }
}



