package org.mixdrinks.mixdrinks.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tools")
data class Tool(
    @PrimaryKey
    val id: Int,
    val name: String,
    val about: String
)
