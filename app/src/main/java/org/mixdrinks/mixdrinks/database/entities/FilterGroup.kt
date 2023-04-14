package org.mixdrinks.mixdrinks.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import org.mixdrinks.dto.SelectionType

@Entity(tableName = "filter_groups")
data class FilterGroup(
    @PrimaryKey
    val id: Int,
    val name: String,
    val selectionType: SelectionType,
)

@Entity(tableName = "filters")
data class Filters(
    @PrimaryKey
    @ColumnInfo(name = "filter_id")
    val filterId : Int,
    @ColumnInfo(name = "filter_group_id")
    val filterGroupId: Int,
    val name: String,
)

@Entity(
    tableName = "filter_with_cocktail_ids",
    primaryKeys = ["filter_id", "cocktail_id"],
    foreignKeys = [
        ForeignKey(
            entity = Filters::class,
            parentColumns = arrayOf("filter_id"),
            childColumns = arrayOf("filter_id"),
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Cocktail::class,
            parentColumns = arrayOf("cocktail_id"),
            childColumns = arrayOf("cocktail_id"),
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        ),
    ]
)
data class FilterWithCocktailIds(
    @ColumnInfo(name = "filter_id")
    val filterId : Int,
    @ColumnInfo(name = "cocktail_id")
    val cocktailId: Int,
)