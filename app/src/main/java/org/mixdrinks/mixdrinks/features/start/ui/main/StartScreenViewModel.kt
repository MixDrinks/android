package org.mixdrinks.mixdrinks.features.start.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.mixdrinks.mixdrinks.features.data.CocktailShort
import org.mixdrinks.mixdrinks.features.start.StartRepository
import java.io.IOException

@Suppress("TooGenericExceptionCaught", "MagicNumber")
class StartScreenViewModel(
    private val startRepository: StartRepository,
) : ViewModel() {
    private val _uiState = MutableStateFlow<StartUiState>(StartUiState.Loading)
    val uiState: StateFlow<StartUiState> = _uiState

    init {
        getCocktail()
    }

    private fun getCocktail() {
        _uiState.value = StartUiState.Loading

        viewModelScope.launch {
            try {
                _uiState.value =
                    StartUiState.Loaded(StartItemUiState("", startRepository.getCocktails()))
            } catch (error: IOException) {
                _uiState.value = StartUiState.Error(error.toString())
            } catch (error: Exception) {
                _uiState.value = StartUiState.Error(error.toString())
            }
        }
    }

    fun searchAction(search: String) {
        val result = startRepository.searchCocktail(search)
        _uiState.update {
            StartUiState.Loaded(StartItemUiState(search, result))
        }
    }

    sealed class StartUiState {
        object Loading : StartUiState()
        class Loaded(val itemState: StartItemUiState) : StartUiState()
        class Error(val message: String) : StartUiState()
    }
}

data class StartItemUiState(
    val searchText: String, var cocktails: List<CocktailShort>
)







