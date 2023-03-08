package org.mixdrinks.mixdrinks.features.data

data class Cocktail (
    val id: Int? = null,
    val name: String? = null,
    val rating: Float? = null,
    val visitCount: Int? = null,
    val images: List<DataImage> = listOf()
)


