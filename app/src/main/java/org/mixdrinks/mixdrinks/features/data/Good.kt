package org.mixdrinks.mixdrinks.features.data

data class Good(
    val amount: Int,
    val id: Int,
    val images: List<DataImage>,
    val name: String,
    val unit: String
)