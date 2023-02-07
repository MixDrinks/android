package org.mixdrinks.mixdrinks.features.start.data

import retrofit2.http.GET
import retrofit2.http.Query

interface CocktailProvider {
    @GET("search/cocktails")
    suspend fun getCocktails(@Query("page") p: Int):  CocktailsResponse
}