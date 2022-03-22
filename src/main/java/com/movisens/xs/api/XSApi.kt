package com.movisens.xs.api

import com.google.gson.GsonBuilder
import com.movisens.xs.api.adapters.DateAdapter
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*
import java.util.concurrent.Executor

class XSApi {
    class Builder {
        private val retrofit: Retrofit.Builder
        private val httpLoggingInterceptor =
            HttpLoggingInterceptor().also { it.level = HttpLoggingInterceptor.Level.NONE }
        private val gson = GsonBuilder().registerTypeAdapter(Date::class.java, DateAdapter()).create()

        constructor() : super() {
            retrofit = Retrofit.Builder()
        }

        constructor(ApiKey: String) {
            retrofit = Retrofit.Builder()
            val authRequestInterceptor = AuthRequestInterceptor(ApiKey)
            val errorInterceptor = ErrorInterceptor()
            val client = OkHttpClient.Builder()
                .addInterceptor(authRequestInterceptor)
                .addInterceptor(errorInterceptor)
                .addInterceptor(httpLoggingInterceptor)
                .build()
            setServer(SERVER_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
        }

        fun setServer(server: String): Builder {
            retrofit.baseUrl(server + API_PATH)
            return this
        }

        fun client(client: OkHttpClient): Builder {
            retrofit.client(client)
            return this
        }

        fun baseUrl(baseUrl: String): Builder {
            retrofit.baseUrl(baseUrl)
            return this
        }

        fun baseUrl(baseUrl: HttpUrl): Builder {
            retrofit.baseUrl(baseUrl)
            return this
        }

        fun addConverterFactory(converterFactory: Converter.Factory): Builder {
            retrofit.addConverterFactory(converterFactory)
            return this
        }

        fun addCallAdapterFactory(factory: CallAdapter.Factory): Builder {
            retrofit.addCallAdapterFactory(factory)
            return this
        }

        fun callbackExecutor(callbackExecutor: Executor): Builder {
            retrofit.callbackExecutor(callbackExecutor)
            return this
        }

        fun build(): Retrofit {
            return retrofit.build()
        }

        fun setLogLevel(level: HttpLoggingInterceptor.Level): Builder {
            httpLoggingInterceptor.level = level
            return this
        }

        companion object {
            private const val SERVER_URL = "https://xs.movisens.com"
            private const val API_PATH = "/api/v2/"
        }
    }
}