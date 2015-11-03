package com.movisens.xs.api.exceptions;

import java.io.IOException;

import com.movisens.xs.api.models.ApiError;

public class MovisensXSException extends IOException {

	private static final long serialVersionUID = 1359714572930063286L;

	public MovisensXSException(ApiError apiError) {
		super(parseMessage(apiError));

	}

	private static String parseMessage(ApiError apiError) {
		if (apiError != null) {
			return apiError.getMessage();
		} else {
			return new ApiError("unknown", "unknown").getMessage();
		}
	}

	public MovisensXSException() {
		super();
	}

}
