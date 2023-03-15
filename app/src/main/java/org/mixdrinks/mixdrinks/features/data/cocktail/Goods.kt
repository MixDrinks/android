package org.mixdrinks.mixdrinks.features.data.cocktail

import kotlinx.serialization.Serializable


@Serializable
data class Goods(
    val amount: Int? = null,
    val id: Int,
    val images: List<DataImage>,
    val name: String,
    val unit: String? = null
)

