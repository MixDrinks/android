package org.mixdrinks.mixdrinks.models

import com.google.gson.annotations.SerializedName

data class CocktailsResponse (
    @SerializedName("totalCount"   ) var totalCount   : Int?                 = null,
    @SerializedName("cocktails"    ) var cocktails    : ArrayList<Cocktail> = arrayListOf(),
    @SerializedName("descriptions" ) var descriptions : String?              = null
)