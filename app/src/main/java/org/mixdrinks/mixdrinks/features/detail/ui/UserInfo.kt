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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.mixdrinks.mixdrinks.R
import kotlin.math.roundToInt

@Preview(
    name = "UserInfoPreview",
    showBackground = true,
    showSystemUi = true
)
@Composable
fun UserInfoPreview() {
    UserInfo(Modifier, 3.0, 30)
}

@Composable
fun UserInfo(modifier: Modifier, rating: Double? = null, visitCount: Int? = null) {
    Row {
        Row(modifier = modifier
            .fillMaxWidth(0.7f)
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
                RatingBar(rating = rating)
            }
        }
    }
}

@Composable
fun ItemRatingStar() {
    Image(
        painter = painterResource(id = R.drawable.ic_baseline_star_24),
        contentDescription = null,
        modifier = Modifier.size(20.dp)
    )
}

@Composable
private fun RatingBar(rating: Double? = null) {
    if (rating != null) {
        for (i in 0 until rating.roundToInt())
            ItemRatingStar()
    }
}

