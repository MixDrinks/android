package org.mixdrinks.mixdrinks.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tags")
data class Tag(
    @PrimaryKey
    @ColumnInfo(name = "tag_id")
    val tagId: Int,
    val name: String,
)

