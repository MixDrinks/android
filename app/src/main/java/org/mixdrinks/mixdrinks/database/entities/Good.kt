package org.mixdrinks.mixdrinks.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "goods")
data class Good(
    @PrimaryKey
    @ColumnInfo(name = "good_id")
    val goodId: Int,
    val name: String,
    val about: String
)
