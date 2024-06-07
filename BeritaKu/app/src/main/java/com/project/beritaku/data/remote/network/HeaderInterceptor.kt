package com.project.beritaku.data.remote.network

import com.project.beritaku.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class HeaderInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        request = request.newBuilder()
            .addHeader("Authorization", "Token ${BuildConfig.API_TOKEN}")
            .build()
        return chain.proceed(request)
    }
}