package com.movisens.xs.api.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ApiError {
    public String error;
    public String error_description;

    public ApiError(String error, String error_description) {
        this.error = error;
        this.error_description = error_description;
    }

    public String getMessage() {
        return error + ": " + error_description;
    }

    public void setMessage(String error_description) {
        this.error_description = error_description;
    }

    public static ApiError parse(String str) {
        Gson gson = new GsonBuilder().create();
        ApiError apiError = gson.fromJson(str, ApiError.class);
        return apiError;
    }

}