package org.mixdrinks.mixdrinks.features.data.cocktail

import kotlinx.serialization.Serializable


@Serializable
data class Goods(
    val amount: Int,
    val id: Int,
    val images: List<DataImage> = listOf(),
    val name: String,
    val unit: String
)

