package org.mixdrinks.mixdrinks.features.start.filter

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import org.mixdrinks.mixdrinks.features.data.SelectedFilter

class SelectedFilterStorage {
    private val _selectedFilters = MutableStateFlow(mutableListOf<SelectedFilter>())
    val selectedFilters: StateFlow<MutableList<SelectedFilter>> = _selectedFilters

    fun add(selectedFilter: SelectedFilter) {
        val list = mutableListOf<SelectedFilter>()
        list.addAll((_selectedFilters.value))
        if (list.find {
                it.filterId == selectedFilter.filterId && it.filterGroupId == selectedFilter.filterGroupId
            } == null
        ) {
            list.add(selectedFilter)
        } else {
            list.remove(selectedFilter)
        }

        _selectedFilters.update {
            list.toMutableList()
        }
    }

    fun clear() {
        _selectedFilters.update {
            mutableListOf()
        }
    }

    fun onClickTag(selectedFilter: SelectedFilter) {
        _selectedFilters.update {
            mutableListOf(selectedFilter)
        }
    }

}

