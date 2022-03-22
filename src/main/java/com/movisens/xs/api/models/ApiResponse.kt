package com.movisens.xs.api.models

data class ApiResponse(val code: Int, val status: String, val message: String, val data: Any)