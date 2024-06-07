package com.project.beritaku.domain.usecase.implementations

import com.project.beritaku.data.NetworkBoundResource
import com.project.beritaku.data.Resource
import com.project.beritaku.data.remote.RemoteDataSource
import com.project.beritaku.data.remote.network.ApiResponse
import com.project.beritaku.data.remote.response.ArticlesItem
import com.project.beritaku.domain.repository.interfaces.NewsRepository
import com.project.beritaku.domain.repository.interfaces.SettingsRepository
import com.project.beritaku.domain.usecase.interfaces.SettingsUseCase
import com.project.beritaku.utils.SettingsPreferences
import kotlinx.coroutines.flow.Flow

class SettingsUseCaseImpl(
    private val settingsRepository: SettingsRepository,
) : SettingsUseCase {
    override fun getDarkMode() = settingsRepository.getDarkMode()

    override suspend fun setDarkMode(isDarkMode: Boolean) {
        settingsRepository.setDarkMode(isDarkMode)
    }
}
