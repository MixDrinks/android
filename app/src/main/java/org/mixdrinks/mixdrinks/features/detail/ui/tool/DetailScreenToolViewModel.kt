package org.mixdrinks.mixdrinks.features.detail.ui.tool

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.mixdrinks.dto.ToolId
import org.mixdrinks.mixdrinks.database.AppDatabase
import org.mixdrinks.mixdrinks.features.data.DetailTool
import java.io.IOException

@Suppress("TooGenericExceptionCaught")
class DetailScreenToolViewModel(
    private val toolId: Int,
    private val roomDatabase: AppDatabase,
) : ViewModel() {

    private val _uiState = MutableStateFlow<DetailToolUiState>(DetailToolUiState.Loading)
    val uiState: StateFlow<DetailToolUiState> = _uiState

    init {
        _uiState.value = DetailToolUiState.Loading

        viewModelScope.launch {
            try {
                val result = roomDatabase.toolDao().getToolById(toolId)

                _uiState.value = DetailToolUiState.Loaded(
                    DetailToolItemUiState(
                        DetailTool(
                            id = ToolId(result.toolId),
                            name = result.name,
                            about = result.about
                        )
                    )
                )
            } catch (error: IOException) {
                _uiState.value = DetailToolUiState.Error(error.toString())
            } catch (error: Exception) {
                _uiState.value = DetailToolUiState.Error(error.toString())
            }
        }
    }

    sealed class DetailToolUiState {
        object Loading : DetailToolUiState()
        class Loaded(val itemState: DetailToolItemUiState) : DetailToolUiState()
        class Error(val message: String) : DetailToolUiState()
    }
}

data class DetailToolItemUiState(
    val tool: DetailTool
)
