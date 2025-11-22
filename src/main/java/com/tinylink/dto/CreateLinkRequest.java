package com.tinylink.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class CreateLinkRequest {

    @NotBlank(message = "Target URL is required")
    private String targetUrl;

    @Pattern(regexp = "^[A-Za-z0-9]{6,8}$", message = "Custom code must be 6-8 alphanumeric characters")
    private String customCode;

    // Constructors
    public CreateLinkRequest() {
    }

    public CreateLinkRequest(String targetUrl, String customCode) {
        this.targetUrl = targetUrl;
        this.customCode = customCode;
    }

    // Getters and Setters
    public String getTargetUrl() {
        return targetUrl;
    }

    public void setTargetUrl(String targetUrl) {
        this.targetUrl = targetUrl;
    }

    public String getCustomCode() {
        return customCode;
    }

    public void setCustomCode(String customCode) {
        this.customCode = customCode;
    }
}
