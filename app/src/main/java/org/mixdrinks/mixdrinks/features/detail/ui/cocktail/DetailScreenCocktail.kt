package org.mixdrinks.mixdrinks.features.detail.ui.cocktail

import android.util.Log
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf
import org.mixdrinks.domain.ImageUrlCreators
import org.mixdrinks.mixdrinks.R
import org.mixdrinks.mixdrinks.features.common.ui.ErrorLoadingScreen
import org.mixdrinks.mixdrinks.features.common.ui.LoaderIndicatorScreen
import org.mixdrinks.mixdrinks.features.data.CocktailFull
import org.mixdrinks.mixdrinks.features.detail.ui.Header

@Suppress("LongParameterList")
@Composable
fun DetailScreen(
    modifier: Modifier,
    cocktailId: Int,
    onNavigateToDetailGood: (id: Int) -> Unit,
    onNavigateToDetailTool: (id: Int) -> Unit,
    onBack: () -> Unit,
    onNavigateToStart: () -> Unit,
    viewModel: DetailScreenCocktailViewModel = koinViewModel { parametersOf(cocktailId) },
) {
    val cocktail by viewModel.uiState.collectAsState()

    when (cocktail) {
        is DetailScreenCocktailViewModel.DetailUiState.Loaded -> {
            val data = (cocktail as DetailScreenCocktailViewModel.DetailUiState.Loaded).itemState
            DetailsScreenData(
                modifier = modifier,
                data = data,
                onNavigateToDetailTool = onNavigateToDetailTool,
                onNavigateToDetailGood = onNavigateToDetailGood,
                onBack = onBack,
                viewModel = viewModel,
                onClickTagAction = onNavigateToStart
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

@Suppress("LongParameterList")
@Composable
fun DetailsScreenData(
    modifier: Modifier,
    data: DetailItemUiState,
    onNavigateToDetailGood: (id: Int) -> Unit,
    onNavigateToDetailTool: (id: Int) -> Unit,
    onBack: () -> Unit,
    viewModel: DetailScreenCocktailViewModel,
    onClickTagAction: () -> Unit,
) {
    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
            .fillMaxWidth(1f)
            .fillMaxHeight(1f)
            .padding(10.dp)
    ) {
        Header(
            modifier = modifier,
            text = data.cocktail.name,
            onClick = onBack
        )
        Spacer(modifier = modifier.padding(5.dp))

        TagListItem(
            modifier = modifier,
            listTags = data.cocktail.tags,
            onClickAction = { tagId ->
                viewModel.onClickTag(tagId)
                onClickTagAction()
            }
        )
        Spacer(modifier = modifier.padding(5.dp))

        AsyncImage(
            model = ImageUrlCreators.createUrl(
                data.cocktail.id,
                ImageUrlCreators.Size.SIZE_320
            ),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth(1f)
                .size(width = 300.dp, height = 200.dp),
        )
        Spacer(modifier = modifier.padding(top = 20.dp))

        CocktailRecipeContent(
            modifier = modifier,
            cocktailReceipt = data.cocktail.receipt
        )
        Spacer(modifier = modifier.padding(top = 10.dp))

        CocktailIngredientsContent(
            modifier = modifier,
            onClick = onNavigateToDetailGood,
            viewModel = viewModel,
            data = data
        )
        Spacer(modifier = modifier.padding(top = 15.dp))

        CocktailToolsContent(
            modifier = modifier,
            cocktailTools = data.cocktail.tools,
            glassware = data.cocktail.glassware,
            onClick = onNavigateToDetailTool
        )
    }
}

@Composable
private fun CocktailIngredientsContent(
    modifier: Modifier,
    onClick: (id: Int) -> Unit,
    viewModel: DetailScreenCocktailViewModel,
    data: DetailItemUiState
) {
    Row(
        modifier = modifier
            .fillMaxWidth(1f),
        horizontalArrangement = Arrangement.Start
    ) {
        Text(
            style = MaterialTheme.typography.h2,
            text = stringResource(R.string.cocktail_ingredients)
        )
    }

    Spacer(modifier = modifier.padding(top = 15.dp))
    CocktailPortions(modifier = modifier, viewModel = viewModel, data = data)
    Spacer(modifier = modifier.padding(bottom = 15.dp))
    GoodsListItems(
        modifier = modifier,
        onClick = onClick,
        data = data
    )
}

@Composable
private fun CocktailPortions(
    modifier: Modifier,
    viewModel: DetailScreenCocktailViewModel,
    data: DetailItemUiState
) {
    Row {
        SquareMarker(
            modifier = modifier
                .clickable {
                    viewModel.decPortion()
                },
            text = "-",
        )
        Spacer(modifier = modifier.padding(5.dp))
        SquareMarker(
            modifier = modifier,
            text = data.portions.toString(),
            isBackground = false,
            textColor = MaterialTheme.colors.primary
        )
        Spacer(modifier = modifier.padding(5.dp))
        SquareMarker(
            modifier = modifier
                .clickable {
                    viewModel.addPortion()
                },
            text = "+"
        )
    }
}

@Composable
fun CocktailToolsContent(
    modifier: Modifier,
    cocktailTools: List<CocktailFull.Tool>,
    glassware: CocktailFull.Glassware,
    onClick: (id: Int) -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth(1f),
        horizontalArrangement = Arrangement.Start
    ) {
        Text(
            style = MaterialTheme.typography.h2,
            text = stringResource(R.string.need_tools)
        )
    }
    Spacer(modifier = modifier.padding(bottom = 15.dp))
    ToolsListItems(
        modifier = modifier,
        tools = cocktailTools,
        glassware = glassware,
        onClick = onClick
    )
}

