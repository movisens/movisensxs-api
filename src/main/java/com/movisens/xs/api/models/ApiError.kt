package com.movisens.xs.api.models

import com.google.gson.GsonBuilder
import com.movisens.xs.api.models.ApiError

class ApiError(var error: String, var error_description: String) {
    var message: String
        get() = "$error: $error_description"
        set(error_description) {
            this.error_description = error_description
        }

    override fun toString(): String {
        return "ApiError{" +
                "error='" + error + '\'' +
                ", error_description='" + error_description + '\'' +
                '}'
    }

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false
        val apiError = o as ApiError
        if (error != apiError.error) return false
        return error_description == apiError.error_description
    }

    override fun hashCode(): Int {
        var result = error.hashCode()
        result = 31 * result + error_description.hashCode()
        return result
    }

    companion object {
        @JvmStatic
        fun parse(str: String?): ApiError {
            val gson = GsonBuilder().create()
            return gson.fromJson(str, ApiError::class.java)
        }
    }
}