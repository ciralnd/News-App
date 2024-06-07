package com.project.beritaku

import android.app.Application
import com.project.beritaku.di.dataStoreModule
import com.project.beritaku.di.networkModule
import com.project.beritaku.di.repositoryModule
import com.project.beritaku.di.useCaseModule
import com.project.beritaku.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BeritaKu : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@BeritaKu)
            modules(
                dataStoreModule,
                networkModule,
                repositoryModule,
                useCaseModule,
                viewModelModule
            )
        }
    }
}