package com.movisens.xs.api;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

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