package com.movisens.xs.api

import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

/**
 * Interceptor used to authorize requests.
 */
class AuthRequestInterceptor(apiKey: String) : Interceptor {
    private val authorizationValue: String = "ApiKey $apiKey"

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val request = original.newBuilder()
            .addHeader("Authorization", authorizationValue)
            .addHeader("User-Agent", "movisensXS Java API")
            .addHeader("Accept", "application/json")
            .build()
        return chain.proceed(request)
    }
}