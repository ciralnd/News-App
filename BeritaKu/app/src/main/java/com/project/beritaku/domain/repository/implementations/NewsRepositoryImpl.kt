package com.project.beritaku.domain.repository.implementations

import com.project.beritaku.data.NetworkBoundResource
import com.project.beritaku.data.Resource
import com.project.beritaku.data.remote.RemoteDataSource
import com.project.beritaku.data.remote.network.ApiResponse
import com.project.beritaku.data.remote.response.ArticlesItem
import com.project.beritaku.domain.repository.interfaces.NewsRepository
import kotlinx.coroutines.flow.Flow

class NewsRepositoryImpl(
    private val remoteDataSource: RemoteDataSource,
) : NewsRepository {
    override fun getLatestNews(): Flow<Resource<List<ArticlesItem>>> =
        object : NetworkBoundResource<List<ArticlesItem>, List<ArticlesItem>>() {
            override suspend fun createCall(): Flow<ApiResponse<List<ArticlesItem>>> =
                remoteDataSource.getLatestNews()
        }.asFlow()
}
