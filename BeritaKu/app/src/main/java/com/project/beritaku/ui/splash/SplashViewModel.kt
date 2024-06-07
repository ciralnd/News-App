package com.project.beritaku.ui.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.project.beritaku.domain.usecase.interfaces.SettingsUseCase

class SplashViewModel(private val settingsUseCase: SettingsUseCase) : ViewModel() {
    fun getDarkMode() = settingsUseCase.getDarkMode().asLiveData()
}