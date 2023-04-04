package org.mixdrinks.mixdrinks.features.detail.ui

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf
import org.mixdrinks.mixdrinks.R
import org.mixdrinks.mixdrinks.features.common.ui.ErrorLoadingScreen
import org.mixdrinks.mixdrinks.features.common.ui.LoaderIndicatorScreen
import org.mixdrinks.mixdrinks.features.data.CocktailFull
import org.mixdrinks.mixdrinks.utils.ImageUrlCreators

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
            val error = cocktail as DetailScreenViewModel.DetailUiState.Error
            Log.d("Exception", error.message)
            ErrorLoadingScreen(modifier = modifier)
        }
    }
}

@Composable
fun DetailsScreenData(modifier: Modifier, cocktail: CocktailFull) {
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

        TagListItem(
            modifier = modifier,
            listTags = cocktail.tags,
            onClickAction = { Log.d("MyLog", it.toString()) }
        )
        Spacer(modifier = modifier.padding(5.dp))

        AsyncImage(
            model = ImageUrlCreators.createUrl(cocktail.id, ImageUrlCreators.SizeConverter.getSizeForImage(300)),
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
fun HeaderText(modifier: Modifier, text: String, textStyle: TextStyle) {
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
private fun CocktailIngredientsContent(modifier: Modifier, cocktailName: String, cocktailGoods: List<CocktailFull.Good>) {
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
fun CocktailNeedToolsContent(modifier: Modifier, cocktailName: String, cocktailTools: List<CocktailFull.Tool>) {
    HeaderText(
        modifier = modifier,
        text = "${stringResource(R.string.need_tools)} $cocktailName",
        textStyle = MaterialTheme.typography.h2
    )
    Spacer(modifier = modifier.padding(bottom = 15.dp))
    ToolsListItem(
        modifier = modifier,
        tools = cocktailTools,
        onCLick = { }
    )
}

