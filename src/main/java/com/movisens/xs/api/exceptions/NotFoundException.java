package com.movisens.xs.api.exceptions;

import com.movisens.xs.api.models.ApiError;

public class NotFoundException extends MovisensXSException {

    private static final long serialVersionUID = 7448898720664495647L;

    public NotFoundException(ApiError apiError) {
        super(apiError);
    }
}
