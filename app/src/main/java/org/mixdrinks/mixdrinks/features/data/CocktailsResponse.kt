package org.mixdrinks.mixdrinks.features.data

data class CocktailsResponse (
    val totalCount: Int? = null,
    val cocktails: List<Cocktail> = listOf(),
    val descriptions: String? = null
)

data class DetailCocktailResponse(
    val id: Int? = null,
    val name: String? = null,
    val visitCount: Int? = null,
    val rating: Double? = null,
    val ratingCount: Int? = null,
    val receipt: List<String>? = listOf(),
    val images: List<DataImage> = listOf(),
    val goods: List<Goods> = listOf(),
    val tools: List<Goods> = listOf(),
    val tags: List<Tag> = listOf(),
)

