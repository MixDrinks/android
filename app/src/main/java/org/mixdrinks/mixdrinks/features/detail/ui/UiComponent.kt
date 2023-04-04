package org.mixdrinks.mixdrinks.features.detail.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import org.mixdrinks.mixdrinks.R

@Composable
fun HeaderScreen(modifier: Modifier, text: String, onClick: () -> Unit) {
    Row(
        modifier = modifier
            .fillMaxWidth(1f),
        horizontalArrangement = Arrangement.Start
    ) {
        IconButton(
            modifier = modifier.height(24.dp),
            onClick = { onClick() }
        ) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_arrow_back_ios_24),
                tint = Color.Black,
                contentDescription = null
            )
        }
        Spacer(modifier = modifier.padding(start = 15.dp))
        Text(
            text = text,
            style = MaterialTheme.typography.h1
        )
    }
}

@Composable
fun HeaderDescription(modifier: Modifier, text: String) {
    Row(
        modifier = modifier
            .fillMaxWidth(1f),
        horizontalArrangement = Arrangement.Start
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.h2
        )
    }
}

@Composable
fun HeaderDescriptionH3(modifier: Modifier, text: String) {
    Row(
        modifier = modifier
            .fillMaxWidth(1f),
        horizontalArrangement = Arrangement.Start
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.h3
        )
    }
}

@Composable
fun HeaderDescriptionItem(modifier: Modifier, text: String) {
    Row(
        modifier = modifier
            .fillMaxWidth(1f),
        horizontalArrangement = Arrangement.Start
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.h4
        )
    }
}

@Composable
fun HeaderDescriptionItemBody1(modifier: Modifier, text: String) {
    Row(
        modifier = modifier
            .fillMaxWidth(1f),
        horizontalArrangement = Arrangement.Start
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.body1
        )
    }
}




