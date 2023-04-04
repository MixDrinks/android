package org.mixdrinks.mixdrinks.features.detail.ui.good

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
import org.mixdrinks.mixdrinks.features.data.DetailGood
import org.mixdrinks.mixdrinks.features.detail.ui.HeaderDescription
import org.mixdrinks.mixdrinks.features.detail.ui.HeaderDescriptionH3
import org.mixdrinks.mixdrinks.features.detail.ui.HeaderScreen
import org.mixdrinks.mixdrinks.utils.ImageUrlCreators

@Composable
fun DetailScreenGood(
    modifier: Modifier,
    goodId: Int,
    onBack: () -> Unit,
    viewModel: DetailScreenGoodViewModel = koinViewModel { parametersOf(goodId) },
) {
    val cocktail by viewModel.uiState.collectAsState()

    when(cocktail) {
        is DetailScreenGoodViewModel.DetailGoodUiState.Loaded -> {
            val data = (cocktail as DetailScreenGoodViewModel.DetailGoodUiState.Loaded).itemState
            DetailScreenGoodData(modifier = modifier, data.good, onBack = onBack)
        }
        is DetailScreenGoodViewModel.DetailGoodUiState.Loading -> {
            LoaderIndicatorScreen(modifier = modifier)
        }
        else -> {
            val error = cocktail as DetailScreenGoodViewModel.DetailGoodUiState.Error
            Log.d("Exception", error.message)
            ErrorLoadingScreen(modifier = modifier)
        }
    }
}

@Composable
fun DetailScreenGoodData(modifier: Modifier, good: DetailGood, onBack: () -> Unit) {
    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
            .fillMaxWidth(1f)
            .fillMaxHeight(1f)
            .padding(10.dp)
    ) {
        HeaderScreen(
            modifier = modifier,
            text = good.name,
            onClick = onBack
        )
        Spacer(modifier = modifier.padding(5.dp))

        AsyncImage(
            model = ImageUrlCreators.createUrl(goodId = good.id, ImageUrlCreators.SizeConverter.getSizeForImage(300)),
            contentDescription = null,
            contentScale = ContentScale.FillHeight,
            modifier = Modifier
                .fillMaxWidth(1f)
                .height(300.dp),
        )
        Spacer(modifier = modifier.padding(top = 20.dp))

        HeaderDescription(
            modifier = modifier,
            text = "${stringResource(R.string.description)} ${good.name}",
        )
        Spacer(modifier = modifier.padding(15.dp))

        HeaderDescriptionH3(
            modifier = modifier,
            text = good.about,
        )
    }
}
