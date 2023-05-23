package org.mixdrinks.mixdrinks.features.start.main.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import org.mixdrinks.domain.ImageUrlCreators
import org.mixdrinks.dto.CocktailId
import org.mixdrinks.mixdrinks.features.data.CocktailShort

@Composable
fun CocktailListItem(modifier: Modifier, item: CocktailShort, onClickAction: (id: Int) -> Unit) {
    Card(
        modifier = modifier
            .clickable { onClickAction(item.cocktailId) }
    ) {
        Row(
            modifier = modifier.padding(10.dp),
        ) {
            ListItemImage(item.cocktailId)
            ListItemInfo(modifier = modifier, item = item)
        }
    }
}

@Composable
private fun ListItemImage(id: Int) {
    AsyncImage(
        model = ImageUrlCreators.createUrl(
            CocktailId(id),
            ImageUrlCreators.Size.SIZE_320
        ),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .clip(RoundedCornerShape(corner = CornerSize(16.dp)))
            .size(100.dp),
    )
}

@Composable
private fun ListItemInfo(modifier: Modifier, item: CocktailShort) {
    Column(
        modifier = modifier
            .fillMaxWidth(1f), verticalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            modifier = modifier
                .padding(start = 10.dp)
        ) {
            Text(
                text = item.name,
                fontWeight = FontWeight.W700,
                fontSize = 18.sp,
                color = MaterialTheme.colors.primary,
            )
        }
    }
}

