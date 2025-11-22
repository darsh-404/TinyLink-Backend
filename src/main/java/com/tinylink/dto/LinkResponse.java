package com.tinylink.dto;

import com.tinylink.entity.Link;

import java.time.LocalDateTime;

public class LinkResponse {

    private Long id;
    private String code;
    private String targetUrl;
    private Integer clicks;
    private LocalDateTime lastClicked;
    private LocalDateTime createdAt;

    // Constructors
    public LinkResponse() {
    }

    public LinkResponse(Link link) {
        this.id = link.getId();
        this.code = link.getCode();
        this.targetUrl = link.getTargetUrl();
        this.clicks = link.getClicks();
        this.lastClicked = link.getLastClicked();
        this.createdAt = link.getCreatedAt();
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTargetUrl() {
        return targetUrl;
    }

    public void setTargetUrl(String targetUrl) {
        this.targetUrl = targetUrl;
    }

    public Integer getClicks() {
        return clicks;
    }

    public void setClicks(Integer clicks) {
        this.clicks = clicks;
    }

    public LocalDateTime getLastClicked() {
        return lastClicked;
    }

    public void setLastClicked(LocalDateTime lastClicked) {
        this.lastClicked = lastClicked;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
