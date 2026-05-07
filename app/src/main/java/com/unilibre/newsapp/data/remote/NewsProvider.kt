package com.unilibre.newsapp.data.remote

import com.unilibre.newsapp.data.model.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsProvider {
    @GET("v2/top-headlines")
    suspend fun getTopHeadlines(
        @Query("country") country: String = "us",
        @Query("apiKey") apiKey: String = "281ec604c8d74c8ab3e62cea4e159f91"
    ): NewsResponse
}
