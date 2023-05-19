package org.mixdrinks.mixdrinks.features.start.ui.filter

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class SelectedFilterStorage {
    private val _selectedFilters = MutableStateFlow(mutableListOf<Int>())
    val selectedFilters: StateFlow<MutableList<Int>> = _selectedFilters

    fun add(id: Int) {
        val list = mutableListOf<Int>()
        list.addAll((_selectedFilters.value))
        if(list.find { it == id } == null) {
            list.add(id)
        } else {
            list.remove(id)
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

    fun onClickTag(id: Int) {
        _selectedFilters.update {
            mutableListOf(id)
        }
    }
}

