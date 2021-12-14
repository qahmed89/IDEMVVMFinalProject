package com.ahmed.idemvvmfinalproject.repo

import androidx.annotation.WorkerThread
import com.ahmed.idemvvmfinalproject.model.topheadlines.TopHeadLinesResponse
import com.ahmed.idemvvmfinalproject.remote.NewsService
import retrofit2.Response

class NewsRepository(val api: NewsService) {

    @WorkerThread
    fun getTopHeadLines(country: String, apiKey: String): Response<TopHeadLinesResponse> {
        val result = api.getTopHeadlines(country, apiKey).execute()
        return result
    }
}



