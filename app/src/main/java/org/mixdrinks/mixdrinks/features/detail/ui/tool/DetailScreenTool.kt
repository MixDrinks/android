package org.mixdrinks.mixdrinks.features.detail.ui.tool

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
import org.mixdrinks.mixdrinks.features.data.DetailTool
import org.mixdrinks.mixdrinks.features.detail.ui.HeaderDescription
import org.mixdrinks.mixdrinks.features.detail.ui.HeaderDescriptionH3
import org.mixdrinks.mixdrinks.features.detail.ui.HeaderScreen
import org.mixdrinks.mixdrinks.utils.ImageUrlCreators

@Composable
fun DetailScreenTool(
    modifier: Modifier,
    toolId: Int,
    onBack: () -> Unit,
    viewModel: DetailScreenToolViewModel = koinViewModel { parametersOf(toolId) },
) {
    val cocktail by viewModel.uiState.collectAsState()

    when(cocktail) {
        is DetailScreenToolViewModel.DetailToolUiState.Loaded -> {
            val data = (cocktail as DetailScreenToolViewModel.DetailToolUiState.Loaded).itemState
            DetailScreenToolData(modifier = modifier, data.tool, onBack = onBack)
        }
        is DetailScreenToolViewModel.DetailToolUiState.Loading -> {
            LoaderIndicatorScreen(modifier = modifier)
        }
        else -> {
            val error = cocktail as DetailScreenToolViewModel.DetailToolUiState.Error
            Log.d("Exception", error.message)
            ErrorLoadingScreen(modifier = modifier)
        }
    }
}

@Composable
fun DetailScreenToolData(modifier: Modifier, tool: DetailTool, onBack: () -> Unit) {
    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
            .fillMaxWidth(1f)
            .fillMaxHeight(1f)
            .padding(10.dp)
    ) {
        HeaderScreen(
            modifier = modifier,
            text = tool.name,
            onClick = onBack
        )
        Spacer(modifier = modifier.padding(5.dp))

        val sizeBoxImage = 300
        AsyncImage(
            model = ImageUrlCreators.createUrl(toolId = tool.id, ImageUrlCreators.SizeConverter.getSizeForImage(sizeBoxImage)),
            contentDescription = null,
            contentScale = ContentScale.FillHeight,
            modifier = Modifier
                .fillMaxWidth(1f)
                .height(sizeBoxImage.dp),
        )
        Spacer(modifier = modifier.padding(top = 20.dp))

        HeaderDescription(
            modifier = modifier,
            text = "${stringResource(R.string.description)} ${tool.name}",
        )
        Spacer(modifier = modifier.padding(15.dp))

        HeaderDescriptionH3(
            modifier = modifier,
            text = tool.about,
        )
    }
}
