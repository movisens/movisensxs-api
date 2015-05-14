package com.movisens.xs.api;

import retrofit.RestAdapter;

public class XSApi {
	public static class Builder extends RestAdapter.Builder {
		private static final String SERVER_URL = "https://xs.movisens.com";
		private static final String API_PATH = "/api/v2";
		AuthRequestInterceptor authRequestInterceptor;

		public Builder(String ApiKey) {
			authRequestInterceptor = new AuthRequestInterceptor(ApiKey);
			this.setServer(SERVER_URL).setErrorHandler(new XSApiErrorHandler())
					.setRequestInterceptor(authRequestInterceptor)
					.setLogLevel(RestAdapter.LogLevel.FULL);
		}

		public Builder setServer(String server) {
			super.setEndpoint(server + API_PATH);
			return this;
		}
	}
}