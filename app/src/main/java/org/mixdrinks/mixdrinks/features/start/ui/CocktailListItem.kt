package org.mixdrinks.mixdrinks.features.start.ui


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import org.mixdrinks.mixdrinks.R
import org.mixdrinks.mixdrinks.features.data.Cocktail
import org.mixdrinks.mixdrinks.features.data.DataImage


@Composable
fun CocktailListItem(modifier: Modifier, item: Cocktail, onClickAction: (id: Int) -> Unit) {
    Card(
        modifier = modifier
            .clickable { item.id?.let { onClickAction(it) } }
    ) {
        Row(
            modifier = modifier.padding(10.dp),
        ) {
            ListItemImage(item.images.first())
            ListItemInfo(modifier = modifier, item = item)
        }
    }
}

@Composable
private fun ListItemImage(image: DataImage) {
    AsyncImage(
        model = image.srcset,
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .clip(RoundedCornerShape(corner = CornerSize(16.dp)))
            .size(200.dp),
    )
}

@Composable
private fun ListItemInfo(modifier: Modifier, item: Cocktail) {
    Box {
        UserInfo(item.rating, item.visitCount)
        Box(
            contentAlignment = Alignment.Center,
            modifier = modifier
                .height(200.dp)
                .padding(start = 10.dp)
        ) {
            item.name?.let {
                Text(
                    text = it,
                    fontWeight = FontWeight.W700,
                    fontSize = 18.sp,
                    color = MaterialTheme.colors.primaryVariant,
                )
            }
        }
    }
}

@Composable
fun UserInfo(rating: Float? = null, visitCount: Int? = null) {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .height(30.dp)
            .padding(end = 5.dp),
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.CenterVertically
    ) {
        rating?.let {
            UserInfoImage(R.drawable.ic_baseline_star_24, it.toString().substring(0, 3))
            Spacer(modifier = Modifier.width(12.dp))
        }
        visitCount?.let {
            UserInfoImage(R.drawable.ic_baseline_eye_24, it.toString())
        }
    }
}

@Composable
private fun UserInfoImage(imageId: Int, text: String) {
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