package com.movisens.xs.api.exceptions;

import retrofit.RetrofitError;

import com.movisens.xs.api.models.ApiError;

public class MovisensXSException extends Exception {

	private static final long serialVersionUID = 1359714572930063286L;

	public MovisensXSException(ApiError apiError, RetrofitError cause) {
		super(getMessage(apiError, cause), cause);
	}

	public MovisensXSException(RetrofitError cause) {
		super(cause);
	}

	public static String getMessage(ApiError apiError, RetrofitError cause) {
		String message = "Could not read error message from server";
		if (cause != null && cause.getMessage() != null) {
			message = cause.getMessage();
		}
		if (apiError != null && apiError.getMessage() != null) {
			message = apiError.getMessage();
		}
		return message;
	}
}
