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

    @Override
    public String toString() {
        return "ApiError{" +
                "error='" + error + '\'' +
                ", error_description='" + error_description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ApiError apiError = (ApiError) o;

        if (error != null ? !error.equals(apiError.error) : apiError.error != null) return false;
        return error_description != null ? error_description.equals(apiError.error_description) : apiError.error_description == null;
    }

    @Override
    public int hashCode() {
        int result = error != null ? error.hashCode() : 0;
        result = 31 * result + (error_description != null ? error_description.hashCode() : 0);
        return result;
    }
}