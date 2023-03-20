package org.mixdrinks.mixdrinks.features.data.cocktail

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Tag(
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String
)
