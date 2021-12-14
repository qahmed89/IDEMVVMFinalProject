package com.ahmed.idemvvmfinalproject.remote

import com.ahmed.idemvvmfinalproject.model.topheadlines.TopHeadLinesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {

    @GET("top-headlines")
    fun getTopHeadlines(
        @Query("country") country: String,
        @Query("apiKey") apiKey: String,
    ): Call<TopHeadLinesResponse>
}