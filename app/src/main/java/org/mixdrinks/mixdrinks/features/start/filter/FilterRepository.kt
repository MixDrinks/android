package org.mixdrinks.mixdrinks.features.start.filter

import org.mixdrinks.mixdrinks.database.AppDatabase
import org.mixdrinks.mixdrinks.database.dao.FilterGroups
import org.mixdrinks.mixdrinks.features.data.FilterGroupFull

class FilterRepository(
    private val roomDatabase: AppDatabase,
    private val filterStorage: SelectedFilterStorage

) {
    private var filterGroups: List<FilterGroups> = listOf()

    suspend fun getFiltersByGroupId(groupId: Int, search: String): List<FilterGroupFull.Filter> {
        return getFilters().first { it.id == groupId }.filters.filter {
            it.name.lowercase().contains(search.lowercase())
        }
    }

    suspend fun getFilters(): List<FilterGroupFull> {
        if (filterGroups.isEmpty()) {
            filterGroups = getFiltersFromDatabase()
        }
        return filterGroups.map { item ->
            FilterGroupFull(
                id = item.filterGroup.id,
                name = item.filterGroup.name,
                selectionType = item.filterGroup.selectionType,
                filters = item.filters.map { filter ->
                    FilterGroupFull.Filter(
                        id = filter.filterId,
                        name = filter.name,
                        cocktailIds = item.cocktailIds.filter {
                            it.filterId == filter.filterId && it.filterGroupId == filter.filterGroupId
                        }.map { it.cocktailId },
                        checked = (filterStorage.selectedFilters.value.find { item ->
                            item.filterId == filter.filterId && item.filterGroupId == filter.filterGroupId
                        } != null),
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

