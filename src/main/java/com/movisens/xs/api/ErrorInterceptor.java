package com.movisens.xs.api;

import com.movisens.xs.api.exceptions.AuthorizationException;
import com.movisens.xs.api.exceptions.MovisensXSException;
import com.movisens.xs.api.exceptions.NotFoundException;
import com.movisens.xs.api.exceptions.ServerException;
import com.movisens.xs.api.models.ApiError;
import okhttp3.Interceptor;
import okhttp3.Response;

import java.io.IOException;

public class ErrorInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Response response = chain.proceed(chain.request());

        switch (response.code()) {
            case 200:
                return response;
            case 401:
            case 403:
                throw new AuthorizationException(getApiError(response));
            case 404:
                throw new NotFoundException(new ApiError(String.valueOf(404), "Resource not found"));
            case 500:
            case 503:
                throw new ServerException(getApiError(response));
            default:
                throw new MovisensXSException(getApiError(response));
        }
    }

    private ApiError getApiError(Response response) throws IOException {
        ApiError apiError = null;
        if (response.body() != null) {
            apiError = ApiError.parse(response.body().string());
        }
        return apiError;
    }
}
