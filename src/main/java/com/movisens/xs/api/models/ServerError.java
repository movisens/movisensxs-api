package com.movisens.xs.api.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ServerError {
	public String type;
	public String message;

	public String getMessage() {
		return type + ": " + message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public static ServerError parse(String str) {
		Gson gson = new GsonBuilder().create();
		ServerError serverError = gson.fromJson(str, ServerError.class);
		return serverError;
	}

}