package org.mixdrinks.mixdrinks.features.data.filter

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FilterItem(
    @SerialName("id")
    val id: Int,
    @SerialName("queryName")
    val queryName: String,
    @SerialName("name")
    val name: String,
    @SerialName("items")
    val items: List<Item>,
    @SerialName("selectionType")
    val selectionType: String
)




