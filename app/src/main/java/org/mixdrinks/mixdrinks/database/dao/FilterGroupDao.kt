package org.mixdrinks.mixdrinks.database.dao

import androidx.room.Dao
import androidx.room.Embedded
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Relation
import androidx.room.Transaction
import org.mixdrinks.dto.FilterGroupDto
import org.mixdrinks.mixdrinks.database.entities.FilterGroup
import org.mixdrinks.mixdrinks.database.entities.FilterWithCocktailIds
import org.mixdrinks.mixdrinks.database.entities.Filters


@Dao
interface FilterGroupDao {
    suspend fun insertAllFilters(filterGroup: List<FilterGroupDto>) {
        addAllFilterGroups(
            filterGroup.map {
                FilterGroup(
                    id = it.id.value,
                    name = it.name,
                    selectionType = it.selectionType
                )
            }
        )
        filterGroup.map {
            addAllFilters(
                it.filters.map { filter ->
                    Filters(
                        filterId = filter.id.value,
                        filterGroupId = it.id.value,
                        name = filter.name
                    )
                }
            )
        }
        filterGroup.map {
            it.filters.map { filter ->
                addAllFilterWithCocktailId(
                    filter.cocktailIds.map { cocktailId ->
                        FilterWithCocktailIds(
                            filterId = filter.id.value,
                            cocktailId = cocktailId.id
                        )
                    }
                )
            }
        }
    }

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    @Transaction
    suspend fun addAllFilterGroups(filterGroup: List<FilterGroup>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    @Transaction
    suspend fun addAllFilters(filterGroup: List<Filters>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    @Transaction
    suspend fun addAllFilterWithCocktailId(filterWithCocktailId: List<FilterWithCocktailIds>)

    @Query("SELECT * FROM filter_groups")
    suspend fun getAllFilterGroups() : List<FilterGroups>
}

data class FilterGroups(
    @Embedded
    val filterGroup: FilterGroup,
    @Relation(
        parentColumn = "id",
        entityColumn = "filter_group_id",
    )
    val filters: List<Filters>
)

