package org.mixdrinks.mixdrinks.features.start.data

import com.google.gson.annotations.SerializedName

data class DataImage (
    @SerializedName("srcset")
    val srcset: String? = null,
    @SerializedName("media")
    val media: String? = null,
    @SerializedName("type")
    val type: String? = null
)