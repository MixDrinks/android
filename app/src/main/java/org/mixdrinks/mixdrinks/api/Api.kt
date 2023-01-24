package org.mixdrinks.mixdrinks.api

import org.mixdrinks.mixdrinks.models.CocktailsResponse
import org.mixdrinks.mixdrinks.models.SettingsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("search/cocktails")
    fun getCocktails(@Query("page") p: Int): Call<CocktailsResponse>

    @GET("settings")
    fun getSettings(): Call<SettingsResponse>


}