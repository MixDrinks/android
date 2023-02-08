package org.mixdrinks.mixdrinks.app

import com.google.gson.annotations.SerializedName

class SettingsResponse(
    @SerializedName("minVote") val minVote: Int? = null,
    @SerializedName("maxVote") val maxVote: Int? = null,
    @SerializedName("pageSize") val pageSize: Int? = null
)