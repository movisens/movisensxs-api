package com.movisens.xs.api;

import java.util.Date;
import java.util.concurrent.Executor;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.movisens.xs.api.adapters.DateAdapter;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class XSApi {
	public static class Builder {
		private static final String SERVER_URL = "https://xs.movisens.com";
		private static final String API_PATH = "/api/v2/";
		AuthRequestInterceptor authRequestInterceptor;
		ErrorInterceptor errorInterceptor;
		private Retrofit.Builder retrofit;

		public Builder() {
			super();
			retrofit = new Retrofit.Builder();
		}

		Gson gson = new GsonBuilder().registerTypeAdapter(Date.class, new DateAdapter()).create();
		private HttpLoggingInterceptor httpLoggingInterceptor;

		public Builder(String ApiKey) {
			retrofit = new Retrofit.Builder();

			authRequestInterceptor = new AuthRequestInterceptor(ApiKey);
			errorInterceptor = new ErrorInterceptor();

			httpLoggingInterceptor = new HttpLoggingInterceptor();
			httpLoggingInterceptor.setLevel(Level.NONE);

			OkHttpClient client = new OkHttpClient.Builder()
					.addInterceptor(authRequestInterceptor)
					.addInterceptor(errorInterceptor)
					.addInterceptor(httpLoggingInterceptor)
				    .build();

			this.setServer(SERVER_URL)
				.client(client)
				.addConverterFactory(GsonConverterFactory.create(gson));
		}

		public Builder setServer(String server) {
			retrofit.baseUrl(server + API_PATH);
			return this;
		}

		public Builder client(OkHttpClient client) {
			retrofit.client(client);
			return this;
		}

		public Builder baseUrl(String baseUrl) {
			retrofit.baseUrl(baseUrl);
			return this;
		}

		public Builder baseUrl(final HttpUrl baseUrl) {
			retrofit.baseUrl(baseUrl);
			return this;
		}

		public Builder addConverterFactory(Converter.Factory converterFactory) {
			retrofit.addConverterFactory(converterFactory);
			return this;
		}

		public Builder addCallAdapterFactory(CallAdapter.Factory factory) {
			retrofit.addCallAdapterFactory(factory);
			return this;
		}

		public Builder callbackExecutor(Executor callbackExecutor) {
			retrofit.callbackExecutor(callbackExecutor);
			return this;
		}

		public Retrofit build() {
			return retrofit.build();
		}

		public Builder setLogLevel(Level level) {
			httpLoggingInterceptor.setLevel(level);
			return this;
		}

	}
}