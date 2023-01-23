package org.mixdrinks.mixdrinks.models

import com.google.gson.annotations.SerializedName

data class Image (
    @SerializedName("srcset" ) var srcset : String? = null,
    @SerializedName("media"  ) var media  : String? = null,
    @SerializedName("type"   ) var type   : String? = null
)