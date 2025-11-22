package com.tinylink.dto;

public class ErrorResponse {

    private String error;

    // Constructors
    public ErrorResponse() {
    }

    public ErrorResponse(String error) {
        this.error = error;
    }

    // Getters and Setters
    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
