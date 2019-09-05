package com.movisens.xs.api.models;

public class ApiSuccessResponse {
    public Integer code;
    public String status;
    public String message;
    public Object data;

    public ApiSuccessResponse(Integer code, String status, String message, Object data) {
        this.code = code;
        this.status = status;
        this.message = message;
        this.data = data;
    }
}
