package com.ahmed.idemvvmfinalproject.model.topheadlines

data class TopHeadLinesResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)