package org.mixdrinks.mixdrinks.features.detail.ui.goods

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.mixdrinks.mixdrinks.database.AppDatabase
import org.mixdrinks.mixdrinks.features.data.DetailGood
import org.mixdrinks.mixdrinks.features.data.GoodType
import java.io.IOException

@Suppress("TooGenericExceptionCaught")
class DetailScreenGoodsViewModel(
    private val goodType: GoodType,
    private val roomDatabase: AppDatabase,
) : ViewModel() {

    private val _uiState = MutableStateFlow<DetailGoodUiState>(DetailGoodUiState.Loading)
    val uiState: StateFlow<DetailGoodUiState> = _uiState

    init {
        _uiState.value = DetailGoodUiState.Loading

        viewModelScope.launch {
            try {
                val result = when (goodType.type) {
                    GoodType.Type.GOOD -> {
                        val good = roomDatabase.goodDao().getGoodById(goodType.id)
                        DetailGood(id = good.goodId, name = good.name, about = good.about)
                    }

                    GoodType.Type.TOOL -> {
                        val tool = roomDatabase.toolDao().getToolById(goodType.id)
                        DetailGood(id = tool.toolId, name = tool.name, about = tool.about)
                    }

                    GoodType.Type.GLASSWARE -> {
                        val glassware = roomDatabase.glasswareDao().getById(goodType.id)
                        DetailGood(
                            id = glassware.glasswareId, name = glassware.name,
                            about = glassware.about
                        )
                    }
                }
                _uiState.value = DetailGoodUiState.Loaded(DetailGoodItemUiState(result))
            } catch (error: IOException) {
                _uiState.value = DetailGoodUiState.Error(error.toString())
            } catch (error: Exception) {
                _uiState.value = DetailGoodUiState.Error(error.toString())
            }
        }
    }

    sealed class DetailGoodUiState {
        object Loading : DetailGoodUiState()
        class Loaded(val itemState: DetailGoodItemUiState) : DetailGoodUiState()
        class Error(val message: String) : DetailGoodUiState()
    }
}

data class DetailGoodItemUiState(
    val good: DetailGood
)
