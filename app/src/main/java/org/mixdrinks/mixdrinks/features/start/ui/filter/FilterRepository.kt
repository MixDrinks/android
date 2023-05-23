package org.mixdrinks.mixdrinks.features.start.ui.filter

import org.mixdrinks.mixdrinks.database.AppDatabase
import org.mixdrinks.mixdrinks.database.dao.FilterGroups
import org.mixdrinks.mixdrinks.features.data.FilterGroupFull

class FilterRepository(
    private val roomDatabase: AppDatabase,
    private val filterStorage: SelectedFilterStorage

) {
    private var filters: List<FilterGroups> = listOf()

    suspend fun getFilters(groupId: Int? = null): List<FilterGroupFull> {
        if (filters.isEmpty()) {
            filters = getFiltersFromDatabase()
        }
        return filters.map { item ->
            FilterGroupFull(
                id = item.filterGroup.id,
                name = item.filterGroup.name,
                selectionType = item.filterGroup.selectionType,
                filters = item.filters.map { filter ->
                    FilterGroupFull.Filter(
                        id = filter.filterId,
                        name = filter.name,
                        cocktailIds = item.cocktailIds.filter{ it.filterId == filter.filterId }.map { it.cocktailId },
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