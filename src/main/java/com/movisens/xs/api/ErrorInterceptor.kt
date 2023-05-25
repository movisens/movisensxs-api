package com.movisens.xs.api

import com.movisens.xs.api.exceptions.AuthorizationException
import com.movisens.xs.api.exceptions.MovisensXSException
import com.movisens.xs.api.exceptions.NotFoundException
import com.movisens.xs.api.exceptions.ServerException
import com.movisens.xs.api.models.ApiError
import com.movisens.xs.api.models.ApiError.Companion.parse
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class ErrorInterceptor : Interceptor {
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val response = chain.proceed(chain.request())
        return when (response.code) {
            200, 201 -> response
            401, 403 -> throw AuthorizationException(getApiError(response))
            404 -> throw NotFoundException(ApiError(404.toString(), "Resource not found"))
            500, 503 -> throw ServerException(getApiError(response))
            else -> throw MovisensXSException(getApiError(response))
        }
    }

    @Throws(IOException::class)
    private fun getApiError(response: Response): ApiError? {
        return if (response.body != null) {
            parse(response.body!!.string())
        } else null
    }
}