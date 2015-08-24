package com.movisens.xs.api;

import java.util.Date;

import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.movisens.xs.api.adapters.DateAdapter;

public class XSApi {
	public static class Builder extends RestAdapter.Builder {
		private static final String SERVER_URL = "https://xs.movisens.com";
		private static final String API_PATH = "/api/v2";
		AuthRequestInterceptor authRequestInterceptor;

		Gson gson = new GsonBuilder().registerTypeAdapter(Date.class,
				new DateAdapter()).create();

		public Builder(String ApiKey) {
			authRequestInterceptor = new AuthRequestInterceptor(ApiKey);
			this.setServer(SERVER_URL).setErrorHandler(new XSApiErrorHandler())
					.setRequestInterceptor(authRequestInterceptor)
					.setConverter(new GsonConverter(gson))
					.setLogLevel(RestAdapter.LogLevel.FULL);
		}

		public Builder setServer(String server) {
			super.setEndpoint(server + API_PATH);
			return this;
		}
	}
}