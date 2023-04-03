package org.mixdrinks.mixdrinks.features.start.ui


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import org.mixdrinks.dto.CocktailDto
import org.mixdrinks.dto.CocktailId
import org.mixdrinks.mixdrinks.utils.ImageUrlCreators
import org.mixdrinks.mixdrinks.utils.SizeConverter


@Composable
fun CocktailListItem(modifier: Modifier, item: CocktailDto, onClickAction: (id: Int) -> Unit) {
    Card(
        modifier = modifier
            .clickable { onClickAction(item.id.id) }
    ) {
        Row(
            modifier = modifier.padding(10.dp),
        ) {
            ListItemImage(item.id)
            ListItemInfo(modifier = modifier, item = item)
        }
    }
}

@Suppress("MagicNumber")
@Composable
private fun ListItemImage(id: CocktailId) {
    val size = 200;
    AsyncImage(
        model = ImageUrlCreators.createUrl(id, SizeConverter.getSizeForImage(size)),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .clip(RoundedCornerShape(corner = CornerSize(16.dp)))
            .size(size.dp),
    )
}

@Composable
private fun ListItemInfo(modifier: Modifier, item: CocktailDto) {
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
    }
}

