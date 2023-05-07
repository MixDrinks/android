package org.mixdrinks.mixdrinks.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "glasswares")
data class Glassware(
    @PrimaryKey
    @ColumnInfo(name = "glassware_id")
    val glasswareId: Int,
    val name: String,
    val about: String
)
