package org.mixdrinks.mixdrinks.features.detail.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.mixdrinks.mixdrinks.app.RetrofitClient
import org.mixdrinks.mixdrinks.features.data.CocktailProvider
import org.mixdrinks.mixdrinks.features.data.DetailCocktailResponse

class DetailScreenViewModel(
    private val cocktailProvider: CocktailProvider = RetrofitClient.retrofit.create(CocktailProvider::class.java)
) : ViewModel() {

    private val _uiState = MutableStateFlow<DetailUiState>(DetailUiState.Loading)
    val uiState: StateFlow<DetailUiState> = _uiState

    fun getCocktail(id: Int) {
        _uiState.value = DetailUiState.Loading

        viewModelScope.launch {
            try {
                val result = cocktailProvider.getCoktail(id)

                _uiState.value = DetailUiState.Loaded(DetailItemUiState(result))
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
    val cocktail: DetailCocktailResponse
)