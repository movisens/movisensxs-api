package com.movisens.xs.api;

import java.io.IOException;

import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

/**
 * Interceptor used to authorize requests.
 */
public class AuthRequestInterceptor implements Interceptor {

	private String authorizationValue = "";

	public AuthRequestInterceptor(String apiKey) {
		authorizationValue = "ApiKey " + apiKey;
	}

	@Override
	public Response intercept(Chain chain) throws IOException {
		Request original = chain.request();

		Request request = original.newBuilder()
				.addHeader("Authorization", authorizationValue)
				.addHeader("User-Agent", "movisensXS Java API")
				.addHeader("Accept", "application/json")
				.build();

		Response response = chain.proceed(request);

		return response;
	}
}