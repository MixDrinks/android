package org.mixdrinks.mixdrinks.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cocktails")
data class Cocktail(
    @PrimaryKey
    @ColumnInfo(name = "cocktail_id")
    val cocktailId: Int,
    val name: String,
    val receipt: String,
)






