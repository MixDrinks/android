package org.mixdrinks.mixdrinks.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tools")
data class Tool(
    @PrimaryKey
    @ColumnInfo(name = "tool_id")
    val toolId: Int,
    val name: String,
    val about: String
)
