package org.mixdrinks.mixdrinks.api

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


object RetrofitClient {
    private const val BASE_URL = "https://api.mixdrinks.org/v2/"
    private const val TIME_OUT: Long = 60

    private val gson = GsonBuilder().setLenient().create()
    private val logging = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    private val okHttpClient = OkHttpClient.Builder()
        .readTimeout(TIME_OUT, TimeUnit.SECONDS)
        .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
        .writeTimeout(TIME_OUT, TimeUnit.SECONDS)
        .addInterceptor(logging)
        .build()


    val instance: Api by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
        retrofit.create(Api::class.java)
    }

}
