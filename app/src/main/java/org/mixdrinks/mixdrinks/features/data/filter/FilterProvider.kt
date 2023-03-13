package org.mixdrinks.mixdrinks.features.data.filter

import retrofit2.http.GET

interface FilterProvider {
    @GET("filters")
    suspend fun getFilters(): FilterResponse
}






