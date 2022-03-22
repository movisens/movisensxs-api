package com.movisens.xs.api.exceptions

import com.movisens.xs.api.models.ApiError

class AuthorizationException(apiError: ApiError?) : MovisensXSException(apiError) {
    companion object {
        private const val serialVersionUID = -1523752187360750888L
    }
}