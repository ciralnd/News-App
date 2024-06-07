package com.project.beritaku.data.remote.network

import com.project.beritaku.data.remote.response.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("top-headlines")
    suspend fun getLatestNews(
        @Query("country") country: String = "us"
    ): NewsResponse
}