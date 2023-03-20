package org.mixdrinks.mixdrinks.features.data.cocktail

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class CocktailsResponse (
    @SerialName("totalCount")
    val totalCount: Int,
    @SerialName("cocktails")
    val cocktails: List<Cocktail>,
)

@Serializable
data class DetailCocktailResponse(
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String,
    @SerialName("visitCount")
    val visitCount: Int,
    @SerialName("rating")
    val rating: Float? = null,
    @SerialName("ratingCount")
    val ratingCount: Int,
    @SerialName("receipt")
    val receipt: List<String>,
    @SerialName("images")
    val images: List<DataImage>,
    @SerialName("goods")
    val goods: List<Goods>,
    @SerialName("tools")
    val tools: List<Goods>,
    @SerialName("tags")
    val tags: List<Tag>,
)

