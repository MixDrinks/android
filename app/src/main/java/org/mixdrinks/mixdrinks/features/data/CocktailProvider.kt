package org.mixdrinks.mixdrinks.features.data

import org.mixdrinks.dto.SnapshotDto
import retrofit2.http.GET

interface CocktailProvider {
    @GET("snapshot")
    suspend fun getAllCocktails(): SnapshotDto
}



