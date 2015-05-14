package com.movisens.xs.api.exceptions;

import retrofit.RetrofitError;

public class NetworkIOException extends MovisensXSException {

	private static final long serialVersionUID = 3829167624351808156L;

	public NetworkIOException(RetrofitError cause) {
		super(cause);
	}
}
