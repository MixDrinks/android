package org.mixdrinks.mixdrinks.features.filter.ui

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.mixdrinks.mixdrinks.features.data.filter.FilterProvider
import org.mixdrinks.mixdrinks.features.data.filter.FilterResponse
import java.io.IOException

class FilterScreenViewModel(
    private val filterProvider: FilterProvider) : ViewModel() {

    private val _listCheckedFilter: MutableState<MutableList<Int>> = mutableStateOf(mutableListOf<Int>())
    val listCheckedFilter: State<List<Int>> = _listCheckedFilter

    private val _uiState = MutableStateFlow<FilterUiState>(
        FilterUiState.Loading)
    val uiState: StateFlow<FilterUiState> = _uiState

    init {
        _uiState.value = FilterUiState.Loading

        viewModelScope.launch {
            try {
                val result = filterProvider.getFilters()
                _uiState.value = FilterUiState.Loaded(FilterItemUiState(result))
            } catch (error: IOException) {
                _uiState.value = FilterUiState.Error(error.toString())
            } catch (error: Exception) {
                _uiState.value = FilterUiState.Error(error.toString())
            }
        }
    }

    sealed class FilterUiState {
        object Loading : FilterUiState()
        class Loaded(val itemState: FilterItemUiState) : FilterUiState()
        class Error(val message: String) : FilterUiState()
    }

    fun checkedAction(id: Int) {
        if(_listCheckedFilter.value.find { it == id } == null) {
            _listCheckedFilter.value.add(id)
        } else {
            _listCheckedFilter.value.remove(id)
        }
        Log.d("MyLog", _listCheckedFilter.value.toString())
    }

    fun clearFilters() {
        _listCheckedFilter.value.clear()
    }
}

data class FilterItemUiState(
    val filters: FilterResponse
)

