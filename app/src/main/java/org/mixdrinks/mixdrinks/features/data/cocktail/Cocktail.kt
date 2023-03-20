package org.mixdrinks.mixdrinks.features.data.cocktail

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Cocktail (
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String,
    @SerialName("rating")
    val rating: Float? = null,
    @SerialName("visitCount")
    val visitCount: Int,
    @SerialName("images")
    val images: List<DataImage>
)

