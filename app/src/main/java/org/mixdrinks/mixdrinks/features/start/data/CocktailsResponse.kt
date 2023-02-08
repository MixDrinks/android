package org.mixdrinks.mixdrinks.features.start.data

import com.google.gson.annotations.SerializedName

data class CocktailsResponse (
    @SerializedName("totalCount"   ) val totalCount   : Int?                 = null,
    @SerializedName("cocktails"    ) val cocktails    : List<Cocktail> = listOf(),
    @SerializedName("descriptions" ) val descriptions : String?              = null
)