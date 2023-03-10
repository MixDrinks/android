package org.mixdrinks.mixdrinks.features.data.cocktail

import retrofit2.http.GET
import retrofit2.http.Query

interface CocktailProvider {
    @GET("search/cocktails")
    suspend fun getCocktails(@Query("page") p: Int,  @Query("sort") b: String = "most-popular"): CocktailsResponse

    @GET("cocktails/full")
    suspend fun getCocktail(@Query("id") id: Int): DetailCocktailResponse
}


