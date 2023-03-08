package org.mixdrinks.mixdrinks.features.data

data class Goods(
    val amount: Int? = null,
    val id: Int? = null,
    val images: List<DataImage> = listOf(),
    val name: String? = null,
    val unit: String? = null
)

