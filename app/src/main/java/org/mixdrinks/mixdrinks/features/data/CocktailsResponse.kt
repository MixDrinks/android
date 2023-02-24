package org.mixdrinks.mixdrinks.features.data

import com.google.gson.annotations.SerializedName

data class CocktailsResponse (
    @SerializedName("totalCount")
    val totalCount: Int? = null,
    @SerializedName("cocktails")
    val cocktails: List<Cocktail> = listOf(),
    @SerializedName("descriptions")
    val descriptions: String? = null
)

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