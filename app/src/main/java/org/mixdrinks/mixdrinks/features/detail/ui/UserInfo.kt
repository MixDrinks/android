package org.mixdrinks.mixdrinks.features.detail.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import org.mixdrinks.mixdrinks.R
import kotlin.math.roundToInt

@Suppress("MagicNumber")
@Composable
fun UserInfo(modifier: Modifier, rating: Float?, visitCount: Int) {
    Row {
        Row(modifier = modifier
            .fillMaxWidth(0.7F)
        ) {
            Text(
                modifier = modifier,
                text = "${stringResource(R.string.visit_count)}: $visitCount",
                style = MaterialTheme.typography.h4,
                color = Color.Black
            )
        }
        Spacer(Modifier.weight(1f))
        Row {
            Row {
                rating?.let {rating ->
                    RatingSelector(rating = rating)
                }
            }
        }
    }
}

@Composable
fun ItemRatingSelector() {
    Image(
        painter = painterResource(id = R.drawable.ic_baseline_star_24),
        contentDescription = null,
        modifier = Modifier.size(20.dp)
    )
}

@Composable
private fun RatingSelector(rating: Float) {
    if (rating > 0) {
        repeat(rating.roundToInt()) {
            ItemRatingSelector()
        }
    }
}



