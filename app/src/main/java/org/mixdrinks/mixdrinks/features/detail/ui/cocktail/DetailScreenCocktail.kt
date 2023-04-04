package org.mixdrinks.mixdrinks.features.detail.ui.cocktail

import android.util.Log
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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf
import org.mixdrinks.mixdrinks.R
import org.mixdrinks.mixdrinks.features.common.ui.ErrorLoadingScreen
import org.mixdrinks.mixdrinks.features.common.ui.LoaderIndicatorScreen
import org.mixdrinks.mixdrinks.features.data.CocktailFull
import org.mixdrinks.mixdrinks.features.detail.ui.HeaderDescription
import org.mixdrinks.mixdrinks.features.detail.ui.HeaderScreen
import org.mixdrinks.mixdrinks.utils.ImageUrlCreators

@Suppress("LongParameterList")
@Composable
fun DetailScreen(
    modifier: Modifier,
    cocktailId: Int,
    onNavigateToDetailGood: (id: Int) -> Unit,
    onNavigateToDetailTool: (id: Int) -> Unit,
    onBack: () -> Unit,
    viewModel: DetailScreenCocktailViewModel = koinViewModel { parametersOf(cocktailId) },
) {
    val cocktail by viewModel.uiState.collectAsState()

    when(cocktail) {
        is DetailScreenCocktailViewModel.DetailUiState.Loaded -> {
            val data = (cocktail as DetailScreenCocktailViewModel.DetailUiState.Loaded).itemState
            DetailsScreenData(
                modifier = modifier,
                data.cocktail,
                onNavigateToDetailTool = onNavigateToDetailTool,
                onNavigateToDetailGood = onNavigateToDetailGood,
                onBack = onBack
            )
        }
        is DetailScreenCocktailViewModel.DetailUiState.Loading -> {
            LoaderIndicatorScreen(modifier = modifier)
        }
        else -> {
            val error = cocktail as DetailScreenCocktailViewModel.DetailUiState.Error
            Log.d("Exception", error.message)
            ErrorLoadingScreen(modifier = modifier)
        }
    }
}

@Suppress("MagicNumber")
@Composable
fun DetailsScreenData(
    modifier: Modifier,
    cocktail: CocktailFull,
    onNavigateToDetailGood: (id: Int) -> Unit,
    onNavigateToDetailTool: (id: Int) -> Unit,
    onBack: () -> Unit,
    ) {
    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
            .fillMaxWidth(1f)
            .fillMaxHeight(1f)
            .padding(10.dp)
    ) {
        HeaderScreen(
            modifier = modifier,
            text = cocktail.name,
            onClick = onBack
        )
        Spacer(modifier = modifier.padding(5.dp))

        TagListItem(
            modifier = modifier,
            listTags = cocktail.tags,
            onClickAction = { Log.d("MyLog", it.toString()) }
        )
        Spacer(modifier = modifier.padding(5.dp))

        val sizeBoxImage = 300
        AsyncImage(
            model = ImageUrlCreators.createUrl(
                cocktail.id,
                ImageUrlCreators.SizeConverter.getSizeForImage(sizeBoxImage)
            ),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth(1f)
                .size(width = sizeBoxImage.dp, height = 200.dp),
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
            cocktailGoods = cocktail.goods,
            onClick = onNavigateToDetailGood
        )
        Spacer(modifier = modifier.padding(top = 15.dp))

        CocktailNeedToolsContent(
            modifier = modifier,
            cocktailName = cocktail.name,
            cocktailTools = cocktail.tools,
            onClick = onNavigateToDetailTool
        )
    }
}

@Composable
private fun CocktailIngredientsContent(
    modifier: Modifier,
    cocktailName: String,
    cocktailGoods: List<CocktailFull.Good>,
    onClick: (id: Int) -> Unit
) {
    HeaderDescription(
        modifier = modifier,
        text = "${stringResource(R.string.cocktail_ingredients)} $cocktailName",
    )
    Spacer(modifier = modifier.padding(top = 15.dp))
    CocktailPortions(modifier = modifier)
    Spacer(modifier = modifier.padding(bottom = 15.dp))
    GoodsListItem(
        modifier = modifier,
        goods = cocktailGoods,
        onClick = onClick
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
fun CocktailNeedToolsContent(
    modifier: Modifier,
    cocktailName: String,
    cocktailTools: List<CocktailFull.Tool>,
    onClick: (id: Int) -> Unit
) {
    HeaderDescription(
        modifier = modifier,
        text = "${stringResource(R.string.need_tools)} $cocktailName",
    )
    Spacer(modifier = modifier.padding(bottom = 15.dp))
    ToolsListItem(
        modifier = modifier,
        tools = cocktailTools,
        onCLick = onClick
    )
}

