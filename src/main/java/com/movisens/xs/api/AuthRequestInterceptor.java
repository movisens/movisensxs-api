package com.movisens.xs.api;


import retrofit.RequestInterceptor;

/**
 * Interceptor used to authorize requests.
 */
public class AuthRequestInterceptor implements RequestInterceptor {

	private String authorizationValue = "";

	public AuthRequestInterceptor(String apiKey) {
		authorizationValue = "ApiKey " + apiKey;
	}

	@Override
	public void intercept(RequestFacade requestFacade) {
		requestFacade.addHeader("Authorization", authorizationValue);
	}
}