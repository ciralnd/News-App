package com.project.beritaku.domain.repository.interfaces

import com.project.beritaku.data.Resource
import com.project.beritaku.data.remote.response.ArticlesItem
import kotlinx.coroutines.flow.Flow

interface SettingsRepository {
    fun getDarkMode(): Flow<Boolean>
    suspend fun setDarkMode(isDarkMode: Boolean)
}