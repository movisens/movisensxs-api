package com.movisens.xs.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import retrofit.ErrorHandler;
import retrofit.RetrofitError;
import retrofit.client.Response;

import com.google.gson.JsonParseException;
import com.movisens.xs.api.exceptions.AuthorizationException;
import com.movisens.xs.api.exceptions.MovisensXSException;
import com.movisens.xs.api.exceptions.NetworkIOException;
import com.movisens.xs.api.exceptions.NotFoundException;
import com.movisens.xs.api.exceptions.ServerException;
import com.movisens.xs.api.models.ApiError;
import com.movisens.xs.api.models.ServerError;

public class XSApiErrorHandler implements ErrorHandler {
	@Override
	public Throwable handleError(RetrofitError cause) {

		Response r = cause.getResponse();

		if (cause.getKind().equals(RetrofitError.Kind.NETWORK)) {
			return new NetworkIOException(cause);
		}
		if (r != null) {
			int responseCode = r.getStatus();
			ApiError apiError = new ApiError("unknown","unknown");
			try {
				String text = fromStream(r.getBody().in());
				apiError = ApiError.parse(text);
			} catch (JsonParseException e) {
			} catch (IOException e) {
			}
			if (responseCode == 403 || responseCode == 401) {
				return new AuthorizationException(apiError, cause);
			} else if (responseCode == 404) {
				return new NotFoundException(apiError, cause);
			} else if (responseCode == 500 || responseCode == 503) {
				ServerError serverError = new ServerError();
				try {
					String text = fromStream(r.getBody().in());
					serverError = ServerError.parse(text);
					apiError = new ApiError(serverError.type, serverError.message);
				} catch (JsonParseException e) {
				} catch (IOException e) {
				}
				return new ServerException(apiError, cause);
			} else {
				return new MovisensXSException(apiError, cause);
			}
		}
		return cause;
	}

	public static String fromStream(InputStream in) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		StringBuilder out = new StringBuilder();
		String newLine = System.getProperty("line.separator");
		String line;
		while ((line = reader.readLine()) != null) {
			out.append(line);
			out.append(newLine);
		}
		return out.toString();
	}
}