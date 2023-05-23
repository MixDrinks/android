package org.mixdrinks.mixdrinks.features.detail.ui.cocktail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.mixdrinks.mixdrinks.database.AppDatabase
import org.mixdrinks.mixdrinks.features.data.CocktailFull
import org.mixdrinks.mixdrinks.features.start.filter.SelectedFilterStorage
import java.io.IOException

@Suppress("TooGenericExceptionCaught")
class DetailScreenCocktailViewModel(
    private val cocktailId: Int,
    private val roomDatabase: AppDatabase,
    private val filterStorage: SelectedFilterStorage
) : ViewModel() {

    private val _uiState = MutableStateFlow<DetailUiState>(DetailUiState.Loading)
    val uiState: StateFlow<DetailUiState> = _uiState

    private lateinit  var cocktail: CocktailFull
    private var portions: Int = 1

    init {
        _uiState.value = DetailUiState.Loading
        viewModelScope.launch {
            try {
                cocktail = roomDatabase.cocktailDao().getById(cocktailId).toCocktailFull()
                _uiState.value = DetailUiState.Loaded(DetailItemUiState(cocktail, portions))
            } catch (error: IOException) {
                _uiState.value = DetailUiState.Error(error.toString())
            } catch (error: Exception) {
                _uiState.value = DetailUiState.Error(error.toString())
            }
        }
    }

    fun addPortion() {
        portions++
        _uiState.value = DetailUiState.Loaded(DetailItemUiState(cocktail, portions))
    }

    fun decPortion() {
        if(portions > 1) portions--
        _uiState.value = DetailUiState.Loaded(DetailItemUiState(cocktail, portions))
    }

    fun onClickTag(id: Int) {
        filterStorage.onClickTag(id)
    }

    sealed class DetailUiState {
        object Loading : DetailUiState()
        class Loaded(val itemState: DetailItemUiState) : DetailUiState()
        class Error(val message: String) : DetailUiState()
    }
}

data class DetailItemUiState(
    val cocktail: CocktailFull,
    val portions: Int
)
