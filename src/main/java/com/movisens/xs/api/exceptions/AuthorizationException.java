package com.movisens.xs.api.exceptions;

import com.movisens.xs.api.models.ApiError;


public class AuthorizationException extends MovisensXSException {

    private static final long serialVersionUID = -1523752187360750888L;

    public AuthorizationException(ApiError apiError) {
        super(apiError);
    }
}
