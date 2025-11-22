package com.tinylink.dto;

public class CreateLinkResponse {

    private String code;
    private String shortUrl;

    // Constructors
    public CreateLinkResponse() {
    }

    public CreateLinkResponse(String code, String shortUrl) {
        this.code = code;
        this.shortUrl = shortUrl;
    }

    // Getters and Setters
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }
}
