package org.mixdrinks.mixdrinks.features.start.ui

import android.content.res.Resources
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.mixdrinks.mixdrinks.database.AppDatabase
import org.mixdrinks.mixdrinks.database.dao.CocktailShort
import java.io.IOException

@Suppress("TooGenericExceptionCaught", "MagicNumber")
class StartScreenViewModel(
    private val roomDatabase: AppDatabase
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
                Log.d("PX",     Resources.getSystem().displayMetrics.density.toString())
                val result = roomDatabase.cocktailDao().getAllShortCocktail()
                _uiState.value = StartUiState.Loaded(StartItemUiState(result))
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
    var cocktails: List<CocktailShort>
)







