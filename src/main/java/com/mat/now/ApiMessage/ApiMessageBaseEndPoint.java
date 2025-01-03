package com.mat.now.ApiMessage;

public class ApiMessageBaseEndPoint {
    private String message;

    public ApiMessageBaseEndPoint(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
