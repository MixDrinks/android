package org.mixdrinks.mixdrinks.api

import org.mixdrinks.mixdrinks.models.CocktailsResponse
import retrofit2.Call
import retrofit2.http.GET

interface Api {
    @GET("search/cocktails?page=0")
    fun getCocktails(): Call<CocktailsResponse>
}