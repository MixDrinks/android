package org.mixdrinks.mixdrinks.features.start.ui.filter.ui.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.mixdrinks.mixdrinks.features.start.ui.filter.FilterRepository
import org.mixdrinks.mixdrinks.features.start.ui.filter.SelectedFilterStorage
import org.mixdrinks.mixdrinks.features.start.ui.filter.ui.main.FilterItemUiState

class FilterSearchViewModel(
    private val filterRepository: FilterRepository,
    private val filterStorage: SelectedFilterStorage
) : ViewModel() {
    private val _uiState = MutableStateFlow<FilterUiState>(
        FilterUiState.Loading)
    val uiState: StateFlow<FilterUiState> = _uiState


    init {
        viewModelScope.launch {
            filterStorage.selectedFilters.collect {
                updateFilters()
            }
        }
    }

    private suspend fun updateFilters() {
        _uiState.update {
            FilterUiState.Loaded(FilterItemUiState(filterRepository.getFilters()))
        }
    }

    fun checkedAction(id: Int) {
        filterStorage.add(id)
    }

    sealed class FilterUiState {
        object Loading : FilterUiState()
        class Loaded(val itemState: FilterItemUiState) : FilterUiState()
        class Error(val message: String) : FilterUiState()
    }

}