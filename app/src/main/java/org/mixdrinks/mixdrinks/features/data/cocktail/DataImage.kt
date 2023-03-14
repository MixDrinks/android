package org.mixdrinks.mixdrinks.features.data.cocktail

import kotlinx.serialization.Serializable


@Serializable
data class DataImage (
    val srcset: String,
    val media: String,
    val type: String
)

