package org.mixdrinks.mixdrinks.features.data.cocktail

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class DataImage (
    @SerialName("srcset")
    val srcset: String,
    @SerialName("media")
    val media: String,
    @SerialName("type")
    val type: String
)

