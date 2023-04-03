package org.mixdrinks.mixdrinks.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.Companion.CASCADE
import androidx.room.PrimaryKey

@Entity(
    tableName = "cocktails",
    foreignKeys = [ForeignKey(
        entity = Glassware::class,
        parentColumns = arrayOf("glassware_id"),
        childColumns = arrayOf("glassware_id"),
        onDelete = CASCADE,
        onUpdate = CASCADE
    )]
)
data class Cocktail(
    @PrimaryKey
    @ColumnInfo(name = "cocktail_id")
    val cocktailId: Int,
    val receipt: String,
    val name: String,
    @ColumnInfo(name = "glassware_id")
    val glasswareId: Int
)

