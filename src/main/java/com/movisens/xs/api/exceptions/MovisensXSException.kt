package com.movisens.xs.api.exceptions

import com.movisens.xs.api.models.ApiError
import com.movisens.xs.api.exceptions.MovisensXSException
import java.io.IOException

open class MovisensXSException : IOException {
    constructor(apiError: ApiError?) : super(parseMessage(apiError))
    constructor() : super()

    companion object {
        private const val serialVersionUID = 1359714572930063286L
        private fun parseMessage(apiError: ApiError?): String {
            return if (apiError != null) {
                apiError.message
            } else {
                ApiError("unknown", "unknown").message
            }
        }
    }
}