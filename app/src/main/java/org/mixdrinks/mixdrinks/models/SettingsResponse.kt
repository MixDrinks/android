package org.mixdrinks.mixdrinks.models

import com.google.gson.annotations.SerializedName

class SettingsResponse(
    @SerializedName("minVote") var minVote: Int? = null,
    @SerializedName("maxVote") var maxVote: Int? = null,
    @SerializedName("pageSize") var pageSize: Int? = null
)