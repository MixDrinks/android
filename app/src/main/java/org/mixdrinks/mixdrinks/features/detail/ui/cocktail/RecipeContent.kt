package org.mixdrinks.mixdrinks.features.detail.ui.cocktail

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import org.mixdrinks.mixdrinks.R
import org.mixdrinks.mixdrinks.app.ui.theme.Green700
import org.mixdrinks.mixdrinks.features.detail.ui.HeaderDescription

@Composable
fun CocktailRecipeContent(modifier: Modifier, cocktailName: String, cocktailReceipt: List<String>) {
    HeaderDescription(
        modifier = modifier,
        text = "${stringResource(R.string.cocktail_recipe)} $cocktailName",
    )
    Spacer(modifier = modifier.padding(top = 5.dp))
    ListCocktailRecipe(modifier = modifier, receipt = cocktailReceipt)
}

@Composable
private fun ListCocktailRecipe(modifier: Modifier, receipt: List<String>) {
    receipt.forEachIndexed { index, item ->
        Row(
            modifier = modifier.padding(1.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            SquareMarker(modifier = modifier, text = (index + 1).toString())
            Text(
                modifier = modifier.padding(start = 10.dp),
                text = item,
                style = MaterialTheme.typography.h3
            )
        }
        if (item != receipt.last()) {
            TabRowDefaults.Divider(
                color = MaterialTheme.colors.primary,
                thickness = 1.dp,
                modifier = modifier.padding(4.dp)
            )
        }
    }
}

@Composable
fun SquareMarker(
    modifier: Modifier,
    text: String,
    isBackground: Boolean = true,
    textColor: Color = Color.White
) {
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
            modifier = modifier
                .wrapContentHeight()
                .wrapContentWidth(),
        )
    }
}
