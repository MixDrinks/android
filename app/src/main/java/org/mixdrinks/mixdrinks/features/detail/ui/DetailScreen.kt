package org.mixdrinks.mixdrinks.features.detail.ui

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TabRowDefaults.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import org.mixdrinks.mixdrinks.features.data.CocktailProviderMock
import org.mixdrinks.mixdrinks.features.data.DetailCocktailResponse
import org.mixdrinks.mixdrinks.features.start.ui.UserInfo
import org.mixdrinks.mixdrinks.R
import org.mixdrinks.mixdrinks.app.ui.theme.Green700
import org.mixdrinks.mixdrinks.features.data.Goods


@Preview(showBackground = true)
@Composable
fun DetailScreenPreview() {
    DetailScreen(modifier = Modifier)
}

@Composable
fun DetailScreen(modifier: Modifier, cocktail: DetailCocktailResponse = CocktailProviderMock.get()) {
    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
            .fillMaxWidth(1f)
            .fillMaxHeight(1f)
            .padding(10.dp)

    ) {
        cocktail.name?.let {
            HeaderText(
                modifier = modifier,
                text = it,
                textStyle = MaterialTheme.typography.h1
            )
        }
        UserInfo(visitCount = 300, rating = 5f)
        AsyncImage(
            model = cocktail.images.first().srcset,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth(1f)
                .size(width = 300.dp, height = 200.dp),
        )
        Spacer(modifier = modifier.padding(top = 20.dp))
        HeaderText(
            modifier = modifier,
            text = "${stringResource(R.string.cocktail_recipe)} ${cocktail.name}",
            textStyle = MaterialTheme.typography.h2
        )
        Spacer(modifier = modifier.padding(top = 5.dp))
        cocktail.receipt?.let {
            RecipeContent(
                modifier = modifier,
                receipt = it
            )
        }

        Spacer(modifier = modifier.padding(top = 10.dp))
        HeaderText(
            modifier = modifier,
            text = "${stringResource(R.string.cocktail_ingredients)} ${cocktail.name}",
            textStyle = MaterialTheme.typography.h2
        )
        Spacer(modifier = modifier.padding(top = 15.dp))
        CocktailPortions(modifier = modifier, {}, {})
        Spacer(modifier = modifier.padding(bottom = 15.dp))
        ListItems(
            modifier = modifier,
            goods = cocktail.goods,
            onCLick = { }
        )

        Spacer(modifier = modifier.padding(top = 15.dp))
        HeaderText(
            modifier = modifier,
            text = "${stringResource(R.string.need_tools)} ${cocktail.name}",
            textStyle = MaterialTheme.typography.h2
        )
        Spacer(modifier = modifier.padding(bottom = 15.dp))
        ListItems(
            modifier = modifier,
            goods = cocktail.tools,
            visibleUnit = false,
            onCLick = { }
        )
    }

}

@Composable
fun HeaderText(
    modifier: Modifier,
    text: String,
    textStyle: TextStyle,
) {
    Row(
        modifier = modifier
            .fillMaxWidth(1f),
        horizontalArrangement = Arrangement.Start
    ) {
        Text(
            text = text,
            style = textStyle
        )
    }
}

@Composable
fun RecipeContent(modifier: Modifier, receipt: List<String>) {
    receipt.forEachIndexed { index, it ->
        Row(
            modifier = modifier.padding(1.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            SquareMarker(modifier = modifier, text = (index + 1).toString())
            Text(
                modifier = modifier.padding(start = 10.dp),
                text = it,
                style = MaterialTheme.typography.h3
            )
        }
        if(it != receipt.last()) {
            Divider(
                color = Color(0xFF2b4718),
                thickness = 1.dp,
                modifier = modifier.padding(4.dp)
            )
        }

    }
}

@Composable
private fun SquareMarker(modifier: Modifier, text: String, isBackground: Boolean = true, textColor: Color = Color.White) {
    Card(
        modifier = modifier
            .border(
                BorderStroke(2.dp, Green700),
                shape = RoundedCornerShape(3.dp),
            )
            .size(30.dp),
            backgroundColor = (if (isBackground) Green700 else Color.White)

    ) {
        Text(
            color = textColor,
            text = text,
            textAlign = TextAlign.Center,
            modifier = modifier.wrapContentHeight().wrapContentWidth(),
        )
    }


}
@Composable
fun CocktailPortions(modifier: Modifier, onClickMinus: () -> Unit, onClickPLus: () -> Unit) {
    Row {
        SquareMarker(
            modifier = modifier,
            text = "-"
        )
        Spacer(modifier = modifier.padding(5.dp))
        SquareMarker(
            modifier = modifier,
            text = "1",
            isBackground = false,
            textColor = Color(0xFF2B4718)
        )
        Spacer(modifier = modifier.padding(5.dp))
        SquareMarker(
            modifier = modifier,
            text = "+"
        )


    }
}

@Composable
fun ListItems(modifier: Modifier, visibleUnit: Boolean = true, goods: List<Goods>, onCLick: () -> Unit)
{
    LazyHorizontalGrid(
        rows = GridCells.Fixed(1),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier.height(240.dp)

    ) {
        items(goods) { item ->
            Card(
                modifier = modifier
                    .clickable { onCLick() },
            ) {
                Column(
                    modifier = modifier
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    AsyncImage(
                        modifier = modifier
                            .border(
                                BorderStroke(2.dp, Color(0xFF2b4718)),
                                shape = RoundedCornerShape(16.dp),
                            )
                            .size(190.dp)
                            .padding(5.dp),
                        model = item.images.first().srcset,
                        contentDescription = null,
                        contentScale = ContentScale.Inside,
                    )
                    item.name?.let {
                        HeaderText(
                            modifier = modifier,
                            text = it,
                            textStyle = MaterialTheme.typography.body1
                        )
                    }
                    if(visibleUnit)
                        HeaderText(
                            modifier = modifier,
                            text = "${item.amount} ${item.unit}",
                            textStyle = MaterialTheme.typography.h4
                        )
                }

            }
        }
    }
}

