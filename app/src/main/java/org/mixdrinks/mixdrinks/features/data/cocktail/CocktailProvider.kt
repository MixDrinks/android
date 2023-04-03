package org.mixdrinks.mixdrinks.features.data.cocktail

import org.mixdrinks.dto.SnapshotDto
import retrofit2.http.GET
import retrofit2.http.Query

interface CocktailProvider {    @GET("cocktails/full")
    suspend fun getCocktail(@Query("id") id: Int): DetailCocktailResponse
    @GET("snapshot")
    suspend fun getAllCocktails(): SnapshotDto
}



