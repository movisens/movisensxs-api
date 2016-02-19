package com.movisens.xs.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.google.gson.JsonParseException;
import com.movisens.xs.api.exceptions.AuthorizationException;
import com.movisens.xs.api.exceptions.MovisensXSException;
import com.movisens.xs.api.exceptions.NotFoundException;
import com.movisens.xs.api.exceptions.ServerException;
import com.movisens.xs.api.models.ApiError;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class ErrorInterceptor implements Interceptor {

	@Override
	public Response intercept(Chain chain) throws IOException {
		Request original = chain.request();
		Response response = chain.proceed(original);
		
		ApiError apiError = null;
		try {
			if (response.body() != null) {
				String text = fromStream(response.body().byteStream());
				response = response.newBuilder().body(ResponseBody.create(response.body().contentType(), text)).build();
				apiError = ApiError.parse(text);
			}
		} catch (JsonParseException e) {
		} catch (IOException e) {
		}

		int responseCode = response.code();
		
		switch (responseCode) {
		case 200:
			return response;
		case 401:
		case 403:
			throw new AuthorizationException(apiError);
		case 404:
			throw new NotFoundException(apiError);
		case 500:
		case 503:
			throw new ServerException(apiError);
		default:
			throw new MovisensXSException(apiError);
		}

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
