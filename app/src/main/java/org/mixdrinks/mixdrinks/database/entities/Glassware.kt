package org.mixdrinks.mixdrinks.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "glassware")
data class Glassware(
    @PrimaryKey
    val id: Int,
    val name: String,
    val about: String

)
