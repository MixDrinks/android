package org.mixdrinks.mixdrinks.features.data.cocktail

data class Cocktail (
    val id: Int,
    val name: String,
    val rating: Float,
    val visitCount: Int,
    val images: List<DataImage>
)

