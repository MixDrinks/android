package org.mixdrinks.mixdrinks.features.start.ui.filter

import org.mixdrinks.mixdrinks.database.AppDatabase
import org.mixdrinks.mixdrinks.database.dao.FilterGroups
import org.mixdrinks.mixdrinks.features.data.FilterGroupFull

class FilterRepository(
    private val roomDatabase: AppDatabase,
    private val filterStorage: SelectedFilterStorage

) {
    private var filters: List<FilterGroups> = listOf()

    suspend fun getFilters(): List<FilterGroupFull> {
        if (filters.isEmpty()) {
            filters = getFiltersFromDatabase()
        }
        return filters.map {
            FilterGroupFull(
                id = it.filterGroup.id,
                name = it.filterGroup.name,
                selectionType = it.filterGroup.selectionType,
                filters = it.filters.map { filter ->
                    FilterGroupFull.Filter(
                        id = filter.filterId,
                        name = filter.name,
                        cocktailIds = setOf(),
                        checked = (filterStorage.selectedFilters.value.find { f -> f == filter.filterId } != null),
                        enabled = true
                    )
                }
            )
        }
    }

    private suspend fun getFiltersFromDatabase(): List<FilterGroups> {
        return roomDatabase.filterGroupDao().getAllFilterGroups()
    }

}