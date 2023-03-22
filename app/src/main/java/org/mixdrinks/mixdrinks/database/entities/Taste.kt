package org.mixdrinks.mixdrinks.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tastes")
data class Taste(
    @PrimaryKey
    val id: Int,
    val name: String
)