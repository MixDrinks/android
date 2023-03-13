package org.mixdrinks.mixdrinks.features.start.ui


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import org.mixdrinks.mixdrinks.features.data.cocktail.Cocktail
import org.mixdrinks.mixdrinks.features.data.cocktail.DataImage


@Composable
fun CocktailListItem(modifier: Modifier, item: Cocktail, onClickAction: (id: Int) -> Unit) {
    Card(
        modifier = modifier
            .clickable { onClickAction(item.id) }
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
    Column(
        modifier = modifier
            .fillMaxWidth(1f)
            .height(200.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            modifier = modifier
                .padding(start = 10.dp)
        ) {
            Text(
                text =  item.name,
                fontWeight = FontWeight.W700,
                fontSize = 18.sp,
                color = MaterialTheme.colors.primaryVariant,
            )
        }
        UserInfo(item.rating, item.visitCount)
    }
}

@Suppress("MagicNumber")
@Composable
private fun UserInfo(rating: Float, visitCount: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth(1f)
            .padding(end = 5.dp),
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.CenterVertically
    ) {
        if(rating > 0) {
            UserInfoImage(R.drawable.ic_baseline_star_24, rating.toString().substring(0, 3))
            Spacer(modifier = Modifier.width(12.dp))
        }
        UserInfoImage(R.drawable.ic_baseline_eye_24, visitCount.toString())
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


