package org.mixdrinks.mixdrinks.features.data.cocktail

import kotlinx.serialization.Serializable

@Serializable
data class Cocktail (
    val id: Int,
    val name: String,
    val rating: Float = 0.0f,
    val visitCount: Int,
    val images: List<DataImage>
)

