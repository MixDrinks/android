package org.mixdrinks.mixdrinks.features.data

import com.google.gson.annotations.SerializedName

class SettingsResponse(
    val minVote: Int? = null,
    val maxVote: Int? = null,
    val pageSize: Int? = null
)