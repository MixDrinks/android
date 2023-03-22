package org.mixdrinks.mixdrinks.features.data.cocktail

import kotlinx.serialization.SerialName
import org.mixdrinks.dto.CocktailDto
import org.mixdrinks.dto.FilterGroupDto
import org.mixdrinks.dto.GlasswareDto
import org.mixdrinks.dto.GoodDto
import org.mixdrinks.dto.TagDto
import org.mixdrinks.dto.TasteDto
import org.mixdrinks.dto.ToolDto
import org.mixdrinks.mixdrinks.features.data.CocktailsSnapshot
import retrofit2.http.GET
import retrofit2.http.Query

interface CocktailProvider {
    @GET("search/cocktails")
    suspend fun getCocktails(@Query("page") page: Int,  @Query("sort") sort: String = "most-popular"): CocktailsResponse

    @GET("cocktails/full")
    suspend fun getCocktail(@Query("id") id: Int): DetailCocktailResponse

    @GET("snapshot")
    suspend fun getAllCocktails(): CocktailsSnapshot
}



