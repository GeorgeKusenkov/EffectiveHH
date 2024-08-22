package com.egasmith.core.api

import com.egasmith.core.api.models.HHResponseDTO
import com.egasmith.core.api.utils.AssetJsonReader
import com.egasmith.core.api.utils.MockInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

const val BASE_URL = "https://api.hh.ru/"

interface Api {

    @GET("offers")
    suspend fun getOffers(): HHResponseDTO
}

class ApiProvider (jsonReader: AssetJsonReader) {
    private val mockInterceptor = MockInterceptor(jsonReader)

    fun provideAviaRailsApi(): Api {
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(mockInterceptor)
            .build()
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
        return retrofit.create(Api::class.java)
    }
}