package com.place2play.auth.model;

import java.util.List;

public class ErrorResponse {
    private int statusCode;
    private String message;
    private List<String> values;

    public ErrorResponse(int statusCode, String message, List<String> values) {
        this.statusCode = statusCode;
        this.message = message;
        this.values = values;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getValues() {
        return values;
    }

    public void setValues(List<String> values) {
        this.values = values;
    }
}