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

    @Override
    public String toString() {
        return "ServerError{" +
                "type='" + type + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ServerError that = (ServerError) o;

        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        return message != null ? message.equals(that.message) : that.message == null;
    }

    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + (message != null ? message.hashCode() : 0);
        return result;
    }
}