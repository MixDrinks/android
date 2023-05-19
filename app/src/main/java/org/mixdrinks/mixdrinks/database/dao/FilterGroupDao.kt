package org.mixdrinks.mixdrinks.database.dao

import androidx.room.Dao
import androidx.room.Embedded
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Relation
import androidx.room.Transaction
import org.mixdrinks.mixdrinks.database.entities.FilterGroup
import org.mixdrinks.mixdrinks.database.entities.FilterWithCocktailIds
import org.mixdrinks.mixdrinks.database.entities.Filters


@Dao
interface FilterGroupDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    @Transaction
    suspend fun addAllFilterGroups(filterGroup: List<FilterGroup>)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    @Transaction
    suspend fun addFilterGroup(filterGroup: FilterGroup)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    @Transaction
    suspend fun addAllFilters(filterGroup: List<Filters>)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    @Transaction
    suspend fun addFilter(filterGroup: Filters)
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
    val filters: List<Filters>,
    @Relation(
        parentColumn = "id",
        entityColumn = "filter_id",
    )
    val cocktailIds: List<FilterWithCocktailIds>,


)

