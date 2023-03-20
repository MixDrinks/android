package org.mixdrinks.mixdrinks.features.data.cocktail

import kotlinx.serialization.Serializable

@Serializable
data class Tag(
    val id: Int,
    val name: String
)
