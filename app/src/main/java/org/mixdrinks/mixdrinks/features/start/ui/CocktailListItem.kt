package org.mixdrinks.mixdrinks.features.start.ui

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme.typography
import org.mixdrinks.mixdrinks.R
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import org.mixdrinks.mixdrinks.features.start.data.Cocktail
import org.mixdrinks.mixdrinks.features.start.data.DataImage
import coil.compose.AsyncImage

@Composable
fun CocktailListItem(item: Cocktail) {
    Card(
        modifier = Modifier.padding(5.dp)
    ) {
        Column {
            ItemHeader(item.rating, item.visitCount)
            ItemImage(item.images.first())
            item.name?.let {
                Text(text = it, style = typography.h6, modifier = Modifier.align(Alignment.CenterHorizontally))
            }
        }
    }
}

@Composable
private fun ItemImage(image: DataImage) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        AsyncImage(
            model = image.srcset,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(8.dp)
                .clip(RoundedCornerShape(corner = CornerSize(16.dp)))
                .size(200.dp),
            )
    }

}

@Composable
private fun ItemHeader(rating: Float? = null, visitCount: Int? = null) {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .height(30.dp)
            .padding(end = 5.dp),
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.CenterVertically
    ) {
        rating?.let {
            ItemHeaderImage(R.drawable.ic_baseline_star_24, it.toString().substring(0, 3))
            Spacer(modifier = Modifier.width(10.dp))
        }
        visitCount?.let {
            ItemHeaderImage(R.drawable.ic_baseline_remove_red_eye_24, it.toString())
        }
    }
}

@Composable
private fun ItemHeaderImage(imageId: Int, text: String) {
    Image(
        painter = painterResource(id = imageId),
        contentDescription = null,
        modifier = Modifier.size(20.dp)
    )
    Text(
        text = text,
        modifier = Modifier.padding(start = 5.dp)
    )
}