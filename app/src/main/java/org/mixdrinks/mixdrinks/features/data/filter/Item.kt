package org.mixdrinks.mixdrinks.features.data.filter

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Item(
    @SerialName("id")
    val id: Int,
    @SerialName("cocktailCount")
    val cocktailCount: Int,
    @SerialName("name")
    val name: String
)

