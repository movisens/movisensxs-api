package com.movisens.xs.api.exceptions;

import com.movisens.xs.api.models.ApiError;

public class ServerException extends MovisensXSException {

    private static final long serialVersionUID = 5596568349506604008L;

    public ServerException(ApiError apiError) {
        super(apiError);
    }
}
