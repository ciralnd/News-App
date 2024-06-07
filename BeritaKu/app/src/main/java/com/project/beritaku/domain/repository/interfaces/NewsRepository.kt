package com.project.beritaku.domain.repository.interfaces

import com.project.beritaku.data.Resource
import com.project.beritaku.data.remote.response.ArticlesItem
import kotlinx.coroutines.flow.Flow

interface NewsRepository {
    fun getLatestNews(): Flow<Resource<List<ArticlesItem>>>
}