package org.mixdrinks.mixdrinks.features.detail.ui

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TabRowDefaults.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf
import org.mixdrinks.mixdrinks.R
import org.mixdrinks.mixdrinks.app.ui.theme.Green700
import org.mixdrinks.mixdrinks.features.common.ui.ErrorLoadingScreen
import org.mixdrinks.mixdrinks.features.common.ui.LoaderIndicatorScreen
import org.mixdrinks.mixdrinks.features.data.cocktail.DetailCocktailResponse
import org.mixdrinks.mixdrinks.features.data.cocktail.Goods

@Composable
fun DetailScreen(
    modifier: Modifier,
    cocktailId: Int,
    viewModel: DetailScreenViewModel = koinViewModel { parametersOf(cocktailId) },
) {
    val cocktail by viewModel.uiState.collectAsState()

    when(cocktail) {
        is DetailScreenViewModel.DetailUiState.Loaded -> {
            val data = (cocktail as DetailScreenViewModel.DetailUiState.Loaded).itemState
            DetailsScreenData(modifier = modifier, data.cocktail)
        }
        is DetailScreenViewModel.DetailUiState.Loading -> {
            LoaderIndicatorScreen(modifier = modifier)
        }
        else -> {
            val errorText = cocktail as DetailScreenViewModel.DetailUiState.Error
            Log.d("MyLog", errorText.message)
            ErrorLoadingScreen(modifier = modifier)
        }
    }
}

@Composable
fun DetailsScreenData(modifier: Modifier, cocktail: DetailCocktailResponse) {
    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
            .fillMaxWidth(1f)
            .fillMaxHeight(1f)
            .padding(10.dp)
    ) {
        HeaderText(
            modifier = modifier,
            text = cocktail.name,
            textStyle = MaterialTheme.typography.h1
        )
        Spacer(modifier = modifier.padding(5.dp))

        UserInfo(modifier = modifier, visitCount = cocktail.visitCount, rating = cocktail.rating)
        Spacer(modifier = modifier.padding(5.dp))

        TagListItem(
            modifier = modifier,
            listTags = cocktail.tags,
            onClickAction = { Log.d("MyLog", it.toString()) }
        )
        Spacer(modifier = modifier.padding(5.dp))

        AsyncImage(
            model = cocktail.images.first().srcset,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth(1f)
                .size(width = 300.dp, height = 200.dp),
        )
        Spacer(modifier = modifier.padding(top = 20.dp))

        CocktailRecipeContent(
            modifier = modifier,
            cocktailName = cocktail.name,
            cocktailReceipt = cocktail.receipt
        )
        Spacer(modifier = modifier.padding(top = 10.dp))

        CocktailIngredientsContent(
            modifier = modifier,
            cocktailName = cocktail.name,
            cocktailGoods = cocktail.goods
        )
        Spacer(modifier = modifier.padding(top = 15.dp))

        CocktailNeedToolsContent(
            modifier = modifier,
            cocktailName = cocktail.name,
            cocktailTools = cocktail.tools
        )
    }
}

@Composable
fun HeaderText(modifier: Modifier, text: String?, textStyle: TextStyle) {
  Row(
      modifier = modifier
          .fillMaxWidth(1f),
      horizontalArrangement = Arrangement.Start
  ) {
    Text(
        text = text ?: "",
        style = textStyle
    )
  }
}

@Composable
private fun CocktailRecipeContent(modifier: Modifier, cocktailName: String?, cocktailReceipt: List<String>?) {
    HeaderText(
        modifier = modifier,
        text = "${stringResource(R.string.cocktail_recipe)} $cocktailName",
        textStyle = MaterialTheme.typography.h2
    )
    Spacer(modifier = modifier.padding(top = 5.dp))
    cocktailReceipt?.let {
        ListCocktailRecipe(
            modifier = modifier,
            receipt = it
        )
    }
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
      Divider(
          color = MaterialTheme.colors.primaryVariant,
          thickness = 1.dp,
          modifier = modifier.padding(4.dp)
      )
    }
  }
}

@Composable
private fun SquareMarker(
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

@Composable
private fun CocktailIngredientsContent(modifier: Modifier, cocktailName: String?, cocktailGoods: List<Goods>) {
    HeaderText(
        modifier = modifier,
        text = "${stringResource(R.string.cocktail_ingredients)} $cocktailName",
        textStyle = MaterialTheme.typography.h2
    )
    Spacer(modifier = modifier.padding(top = 15.dp))
    CocktailPortions(modifier = modifier)
    Spacer(modifier = modifier.padding(bottom = 15.dp))
    GoodsListItem(
        modifier = modifier,
        goods = cocktailGoods,
        onCLick = {  }
    )
}

@Composable
private fun CocktailPortions(modifier: Modifier) {
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
        textColor = MaterialTheme.colors.primaryVariant
    )
    Spacer(modifier = modifier.padding(5.dp))
    SquareMarker(
        modifier = modifier,
        text = "+"
    )
  }
}

@Composable
fun CocktailNeedToolsContent(modifier: Modifier, cocktailName: String?, cocktailTools: List<Goods>) {
    HeaderText(
        modifier = modifier,
        text = "${stringResource(R.string.need_tools)} $cocktailName",
        textStyle = MaterialTheme.typography.h2
    )
    Spacer(modifier = modifier.padding(bottom = 15.dp))
    GoodsListItem(
        modifier = modifier,
        goods = cocktailTools,
        visibleUnit = false,
        onCLick = { }
    )
}
