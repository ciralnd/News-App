package com.project.beritaku.domain.usecase.implementations

import com.project.beritaku.domain.repository.interfaces.NewsRepository
import com.project.beritaku.domain.usecase.interfaces.NewsUseCase

class NewsUseCaseImpl(private val newsRepository: NewsRepository) : NewsUseCase {
    override fun getLatestNews() = newsRepository.getLatestNews()
}