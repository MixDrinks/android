package org.mixdrinks.mixdrinks.features.data

import org.mixdrinks.dto.SelectionType

data class FilterGroupFull(
    val id: Int,
    val name: String,
    val selectionType: SelectionType,
    val filters: List<Filter>
) {
    data class Filter(
        val id: Int,
        val name: String,
        val enabled: Boolean,
        val checked: Boolean,
        val cocktailIds: List<Int>
    )
}

