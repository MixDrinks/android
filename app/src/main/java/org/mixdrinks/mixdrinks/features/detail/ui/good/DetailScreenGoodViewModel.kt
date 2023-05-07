package org.mixdrinks.mixdrinks.features.detail.ui.good

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.mixdrinks.dto.GoodId
import org.mixdrinks.mixdrinks.database.AppDatabase
import org.mixdrinks.mixdrinks.features.data.DetailGood
import java.io.IOException

@Suppress("TooGenericExceptionCaught")
class DetailScreenGoodViewModel(
    private val goodId: Int,
    private val roomDatabase: AppDatabase,
) : ViewModel() {

    private val _uiState = MutableStateFlow<DetailGoodUiState>(DetailGoodUiState.Loading)
    val uiState: StateFlow<DetailGoodUiState> = _uiState

    init {
        _uiState.value = DetailGoodUiState.Loading

        viewModelScope.launch {
            try {
                val result = roomDatabase.goodDao().getGoodById(goodId)

                _uiState.value = DetailGoodUiState.Loaded(
                    DetailGoodItemUiState(
                        DetailGood(
                            id = GoodId(result.goodId),
                            name = result.name,
                            about = result.about
                        )
                    )
                )
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
