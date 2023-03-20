package org.mixdrinks.mixdrinks.features.data.filter

import kotlinx.serialization.Serializable

@Serializable
data class Item(
    val cocktailCount: Int,
    val id: Int,
    val name: String
)

