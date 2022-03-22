package com.movisens.xs.api.exceptions

import com.movisens.xs.api.models.ApiError

class NotFoundException(apiError: ApiError?) : MovisensXSException(apiError) {
    companion object {
        private const val serialVersionUID = 7448898720664495647L
    }
}