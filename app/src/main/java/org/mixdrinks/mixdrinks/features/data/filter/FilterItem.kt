package org.mixdrinks.mixdrinks.features.data.filter

import kotlinx.serialization.Serializable

@Serializable
data class FilterItem(
    val id: Int,
    val queryName: String,
    val name: String,
    val items: List<Item>,
    val selectionType: String
)




