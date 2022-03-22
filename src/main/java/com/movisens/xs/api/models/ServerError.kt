package com.movisens.xs.api.models

import com.google.gson.GsonBuilder

class ServerError {
    var type: String? = null
    var errorMessage: String? = null
    var message: String?
        get() = "$type: $errorMessage"
        set(message) {
            errorMessage = message
        }

    override fun toString(): String {
        return "ServerError{" +
                "type='" + type + '\'' +
                ", message='" + errorMessage + '\'' +
                '}'
    }



    companion object {
        fun parse(str: String?): ServerError {
            val gson = GsonBuilder().create()
            return gson.fromJson(str, ServerError::class.java)
        }
    }
}