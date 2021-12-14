package com.ahmed.idemvvmfinalproject.remote

import com.ahmed.idemvvmfinalproject.other.Other
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {

    fun createNewsService () : NewsService {
        return Retrofit.Builder()
            .baseUrl(Other.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(NewsService::class.java)
    }
}