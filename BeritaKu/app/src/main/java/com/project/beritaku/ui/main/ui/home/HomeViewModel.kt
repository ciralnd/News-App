package com.project.beritaku.ui.main.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.project.beritaku.domain.usecase.interfaces.NewsUseCase

class HomeViewModel(private val newsUseCase: NewsUseCase) : ViewModel() {
    fun getLatestNews() = newsUseCase.getLatestNews().asLiveData()
}