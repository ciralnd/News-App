package com.project.beritaku.data.remote

import android.util.Log
import com.project.beritaku.data.remote.network.ApiResponse
import com.project.beritaku.data.remote.network.ApiService
import com.project.beritaku.data.remote.response.ArticlesItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RemoteDataSource(private val apiService: ApiService) {
    suspend fun getLatestNews(): Flow<ApiResponse<List<ArticlesItem>>> {
        return flow {
            try {
                val response = apiService.getLatestNews()
                val dataArray = response.articles
                if (dataArray.isNotEmpty()) {
                    val filteredNews = response.articles.filter { it.title != "[Removed]" }
                    emit(ApiResponse.Success(filteredNews))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }
}