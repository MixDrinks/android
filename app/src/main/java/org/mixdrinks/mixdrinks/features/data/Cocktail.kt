package org.mixdrinks.mixdrinks.features.data

import com.google.gson.annotations.SerializedName

data class Cocktail (
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("rating")
    val rating: Float? = null,
    @SerializedName("visitCount")
    val visitCount: Int? = null,
    @SerializedName("images")
    val images: List<DataImage> = listOf()
)