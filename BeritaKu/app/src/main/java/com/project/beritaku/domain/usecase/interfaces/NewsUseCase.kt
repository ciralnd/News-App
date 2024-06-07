package com.project.beritaku.domain.usecase.interfaces

import com.project.beritaku.data.Resource
import com.project.beritaku.data.remote.response.ArticlesItem
import kotlinx.coroutines.flow.Flow

interface NewsUseCase {
    fun getLatestNews(): Flow<Resource<List<ArticlesItem>>>
}