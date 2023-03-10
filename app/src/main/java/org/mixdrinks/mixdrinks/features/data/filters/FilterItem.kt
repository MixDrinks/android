package org.mixdrinks.mixdrinks.features.data.filters

data class FilterItem(
    val id: Int,
    val items: List<Item>,
    val name: String,
    val queryName: String,
    val selectionType: String
)