package org.mixdrinks.mixdrinks.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tastes")
data class Taste(
    @PrimaryKey
    @ColumnInfo(name = "taste_id")
    val tasteId: Int,
    val name: String
)

