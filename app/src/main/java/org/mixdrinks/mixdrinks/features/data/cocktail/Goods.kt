package org.mixdrinks.mixdrinks.features.data.cocktail

data class Goods(
    val amount: Int,
    val id: Int,
    val images: List<DataImage> = listOf(),
    val name: String,
    val unit: String
)

