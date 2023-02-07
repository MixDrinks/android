package org.mixdrinks.mixdrinks.models

import com.google.gson.annotations.SerializedName

data class Cocktail (

    @SerializedName("id"         ) var id         : Int?              = null,
    @SerializedName("name"       ) var name       : String?           = null,
    @SerializedName("rating"     ) var rating     : Float?              = null,
    @SerializedName("visitCount" ) var visitCount : Int?              = null,
    @SerializedName("images"     ) var images     : ArrayList<Image> = arrayListOf()

)