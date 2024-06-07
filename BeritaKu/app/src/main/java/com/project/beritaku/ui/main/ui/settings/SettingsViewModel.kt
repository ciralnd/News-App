package com.project.beritaku.ui.main.ui.settings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.project.beritaku.domain.usecase.interfaces.SettingsUseCase
import kotlinx.coroutines.launch

class SettingsViewModel(private val settingsUseCase: SettingsUseCase) : ViewModel() {
    fun getDarkMode() = settingsUseCase.getDarkMode().asLiveData()

    fun setDarkMode(darkMode: Boolean) {
        viewModelScope.launch {
            settingsUseCase.setDarkMode(darkMode)
        }
    }
}