package org.mixdrinks.mixdrinks.features.data.cocktail

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class Goods(
    @SerialName("amount")
    val amount: Int? = null,
    @SerialName("id")
    val id: Int,
    @SerialName("images")
    val images: List<DataImage>,
    @SerialName("name")
    val name: String,
    @SerialName("unit")
    val unit: String? = null
)

