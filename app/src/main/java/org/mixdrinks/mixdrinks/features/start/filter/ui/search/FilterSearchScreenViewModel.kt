package org.mixdrinks.mixdrinks.features.start.filter.ui.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.mixdrinks.mixdrinks.features.data.FilterGroupFull
import org.mixdrinks.mixdrinks.features.data.SelectedFilter
import org.mixdrinks.mixdrinks.features.start.filter.FilterRepository
import org.mixdrinks.mixdrinks.features.start.filter.SelectedFilterStorage

class FilterSearchScreenViewModel(
    private val groupId: Int,
    private val filterRepository: FilterRepository,
    private val filterStorage: SelectedFilterStorage
) : ViewModel() {
    private val _uiState = MutableStateFlow<FilterUiState>(
        FilterUiState.Loading
    )
    val uiState: StateFlow<FilterUiState> = _uiState
    private var searchText = ""

    init {
        viewModelScope.launch {
            filterStorage.selectedFilters.collect {
                updateFilters()
            }
        }
    }

    private fun updateFilters() {
        viewModelScope.launch {
            _uiState.update {
                FilterUiState.Loaded(FilterSearchItemUiState(filterRepository.getFiltersByGroupId(groupId,searchText)))
            }
        }
    }

    fun searchAction(search: String) {
        searchText = search
        updateFilters()
    }


    fun checkedAction(selectedFilter: SelectedFilter) {
        filterStorage.add(selectedFilter)
    }

    sealed class FilterUiState {
        object Loading : FilterUiState()
        class Loaded(val itemState: FilterSearchItemUiState) : FilterUiState()
        class Error(val message: String) : FilterUiState()
    }
}

data class FilterSearchItemUiState(
    val filters: List<FilterGroupFull.Filter>
)

