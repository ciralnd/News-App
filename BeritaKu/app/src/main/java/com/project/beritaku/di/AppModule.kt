package com.project.beritaku.di

import com.project.beritaku.data.remote.RemoteDataSource
import com.project.beritaku.data.remote.network.ApiConfig
import com.project.beritaku.domain.repository.interfaces.NewsRepository
import com.project.beritaku.domain.repository.implementations.NewsRepositoryImpl
import com.project.beritaku.domain.repository.implementations.SettingsRepositoryImpl
import com.project.beritaku.domain.repository.interfaces.SettingsRepository
import com.project.beritaku.domain.usecase.interfaces.NewsUseCase
import com.project.beritaku.domain.usecase.implementations.NewsUseCaseImpl
import com.project.beritaku.domain.usecase.implementations.SettingsUseCaseImpl
import com.project.beritaku.domain.usecase.interfaces.SettingsUseCase
import com.project.beritaku.ui.splash.SplashViewModel
import com.project.beritaku.ui.main.ui.home.HomeViewModel
import com.project.beritaku.ui.main.ui.settings.SettingsViewModel
import com.project.beritaku.utils.SettingsPreferences
import com.project.beritaku.utils.dataStore
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val dataStoreModule = module {
    single { SettingsPreferences(androidContext().dataStore) }
}

val networkModule = module {
    single { ApiConfig.getApiService() }
    single { RemoteDataSource(get()) }
}

val repositoryModule = module {
    single<NewsRepository> { NewsRepositoryImpl(get()) }
    single<SettingsRepository> { SettingsRepositoryImpl(get()) }
}

val useCaseModule = module {
    single<NewsUseCase> { NewsUseCaseImpl(get()) }
    single<SettingsUseCase> { SettingsUseCaseImpl(get()) }
}

val viewModelModule = module {
    viewModel { SplashViewModel(get()) }
    viewModel { HomeViewModel(get()) }
    viewModel { SettingsViewModel(get()) }
}