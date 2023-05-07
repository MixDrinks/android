package org.mixdrinks.mixdrinks.features.data

import org.mixdrinks.dto.SelectionType

data class FilterGroupFull(
    val id: Int,
    val name: String,
    val selectionType: SelectionType,
    val filters: List<Filters>
    ) {
    data class Filters(
        val id: Int,
        val name: String,
        val cocktailIds: Set<Int>
    )
}

