package org.mixdrinks.mixdrinks.features.common.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import org.mixdrinks.mixdrinks.R

@Composable
fun NotFoundScreen(modifier: Modifier, onNavigateToStart: () -> Unit) {
    Column(
        modifier = modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painterResource(id = R.drawable.found_off),
            contentDescription = null,
            contentScale = ContentScale.Inside,
            modifier = modifier.size(200.dp),
        )
        Spacer(modifier = modifier.padding(5.dp))
        Text(
            text = stringResource(id = R.string.nothing_found),
            style = MaterialTheme.typography.h2,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = modifier.padding(15.dp))
        OutlinedButton(onClick = { onNavigateToStart() }) {
            Text(
                text = stringResource(id = R.string.back_to_main),
                style = MaterialTheme.typography.h2,
                textAlign = TextAlign.Center
            )
        }
    }
}
