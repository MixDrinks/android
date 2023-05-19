package org.mixdrinks.mixdrinks.features.start.ui.filter.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.mixdrinks.mixdrinks.features.data.FilterGroupFull
import org.mixdrinks.mixdrinks.features.start.ui.filter.FilterRepository
import org.mixdrinks.mixdrinks.features.start.ui.filter.SelectedFilterStorage
import java.io.IOException

@Suppress("TooGenericExceptionCaught")
class FilterScreenViewModel(
    private val filterStorage: SelectedFilterStorage,
    private val filterRepository: FilterRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow<FilterUiState>(FilterUiState.Loading)
    val uiState: StateFlow<FilterUiState> = _uiState

    init {
        _uiState.value = FilterUiState.Loading

        viewModelScope.launch {
            filterStorage.selectedFilters.collect {
                updateFilters()
            }
        }
        viewModelScope.launch {
            try {
                updateFilters()
            } catch (error: IOException) {
                _uiState.value = FilterUiState.Error(error.toString())
            } catch (error: Exception) {
                _uiState.value = FilterUiState.Error(error.toString())
            }
        }
    }

    private suspend fun updateFilters() {
        _uiState.update {
            FilterUiState.Loaded(FilterItemUiState(filterRepository.getFilters()))
        }
    }

    sealed class FilterUiState {
        object Loading : FilterUiState()
        class Loaded(val itemState: FilterItemUiState) : FilterUiState()
        class Error(val message: String) : FilterUiState()
    }

    fun checkedAction(id: Int) {
        filterStorage.add(id)
    }

    fun clearFilters() {
        filterStorage.clear()
    }
}

data class FilterItemUiState(
    val filters: List<FilterGroupFull>
)


