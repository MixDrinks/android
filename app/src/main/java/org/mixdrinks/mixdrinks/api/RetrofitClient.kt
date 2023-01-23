package org.mixdrinks.mixdrinks.api

import android.net.Uri
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.Boolean
import java.util.concurrent.TimeUnit


object RetrofitClient {

//    private val baseUrl = Uri.Builder()
//        .scheme("https")
//        .appendPath("api.mixdrinks.org")
//        .appendPath("v2").build()

    private var baseUrl = "https://api.mixdrinks.org/v2/"

    private const val TIME_OUT: Long = 60
    private const val TAG = "RetrofitClient"

    private val gson = GsonBuilder().setLenient().create()
    private var logging = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    private val okHttpClient = OkHttpClient.Builder()
        .readTimeout(TIME_OUT, TimeUnit.SECONDS)
        .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
        .writeTimeout(TIME_OUT, TimeUnit.SECONDS)
        .addInterceptor(logging)
        .build()


    val instance: Api by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl.toString())
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
        retrofit.create(Api::class.java)
    }

}
