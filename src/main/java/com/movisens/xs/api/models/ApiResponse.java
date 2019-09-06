package com.movisens.xs.api.models;

public class ApiResponse {
    public Integer code;
    public String status;
    public String message;
    public Object data;

    public ApiResponse(Integer code, String status, String message, Object data) {
        this.code = code;
        this.status = status;
        this.message = message;
        this.data = data;
    }
}
