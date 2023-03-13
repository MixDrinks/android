package org.mixdrinks.mixdrinks.features.start.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.mixdrinks.mixdrinks.features.data.cocktail.Cocktail
import org.mixdrinks.mixdrinks.features.data.cocktail.CocktailProvider
import java.io.IOException

@Suppress("TooGenericExceptionCaught")
class StartScreenViewModel(
    private val cocktailProvider: CocktailProvider
) : ViewModel() {
    private val _uiState = MutableStateFlow<StartUiState>(StartUiState.Loading)
    val uiState: StateFlow<StartUiState> = _uiState

    init {
        getCocktail(0)
    }

    fun getCocktail(page: Int = 0) {
        _uiState.value = StartUiState.Loading

        viewModelScope.launch {
            try {
                val result = cocktailProvider.getCocktails(page = page)
                _uiState.value = StartUiState.Loaded(StartItemUiState(result.cocktails))
            } catch (error: IOException) {
                _uiState.value = StartUiState.Error(error.toString())
            } catch (error: Exception) {
                _uiState.value = StartUiState.Error(error.toString())
            }
        }
    }
    sealed class StartUiState {
        object Loading : StartUiState()
        class Loaded(val itemState: StartItemUiState) : StartUiState()
        class Error(val message: String) : StartUiState()
    }
}

data class StartItemUiState(
    var cocktails: List<Cocktail>
)






