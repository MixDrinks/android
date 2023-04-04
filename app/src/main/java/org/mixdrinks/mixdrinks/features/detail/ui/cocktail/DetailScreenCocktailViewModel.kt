package org.mixdrinks.mixdrinks.features.detail.ui.cocktail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.mixdrinks.mixdrinks.database.AppDatabase
import org.mixdrinks.mixdrinks.features.data.CocktailFull
import java.io.IOException

@Suppress("TooGenericExceptionCaught")
class DetailScreenCocktailViewModel(
    private val cocktailId: Int,
    private val roomDatabase: AppDatabase,
) : ViewModel() {

    private val _uiState = MutableStateFlow<DetailUiState>(DetailUiState.Loading)
    val uiState: StateFlow<DetailUiState> = _uiState

    init {
        _uiState.value = DetailUiState.Loading
        viewModelScope.launch {
            try {
                val result = roomDatabase.cocktailDao().getById(cocktailId)
                _uiState.value = DetailUiState.Loaded(DetailItemUiState(result.toCocktailFull()))
            } catch (error: IOException) {
                _uiState.value = DetailUiState.Error(error.toString())
            } catch (error: Exception) {
                _uiState.value = DetailUiState.Error(error.toString())
            }
        }
    }

    sealed class DetailUiState {
        object Loading : DetailUiState()
        class Loaded(val itemState: DetailItemUiState) : DetailUiState()
        class Error(val message: String) : DetailUiState()
    }
}

data class DetailItemUiState(
    val cocktail: CocktailFull
)
