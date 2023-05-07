package org.mixdrinks.mixdrinks.features.data

import org.mixdrinks.dto.GoodId
import org.mixdrinks.dto.ToolId

data class DetailGood (
    val id: GoodId,
    val name: String,
    val about: String
)

data class DetailTool (
    val id: ToolId,
    val name: String,
    val about: String
)

