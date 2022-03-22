package com.movisens.xs.api.exceptions

import com.movisens.xs.api.models.ApiError

class ServerException(apiError: ApiError?) : MovisensXSException(apiError) {
    companion object {
        private const val serialVersionUID = 5596568349506604008L
    }
}