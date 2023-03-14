package org.mixdrinks.mixdrinks.features.data.filter

import kotlinx.serialization.Serializable

@Serializable
data class FilterItem(
    val id: Int,
    val items: List<Item>,
    val name: String,
    val queryName: String,
    val selectionType: String
)




