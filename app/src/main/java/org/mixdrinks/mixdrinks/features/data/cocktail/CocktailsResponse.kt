package org.mixdrinks.mixdrinks.features.data.cocktail

import kotlinx.serialization.Serializable


@Serializable
data class CocktailsResponse (
    val totalCount: Int,
    val cocktails: List<Cocktail>,
    val descriptions: Any,
)

@Serializable
data class DetailCocktailResponse(
    val id: Int,
    val name: String,
    val visitCount: Int,
    val rating: Double,
    val ratingCount: Int,
    val receipt: List<String>,
    val images: List<DataImage>,
    val goods: List<Goods>,
    val tools: List<Goods>,
    val tags: List<Tag>,
)

