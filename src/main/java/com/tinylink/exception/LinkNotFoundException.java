package com.tinylink.exception;

public class LinkNotFoundException extends RuntimeException {

    public LinkNotFoundException(String message) {
        super(message);
    }

    public LinkNotFoundException(String code, boolean isCode) {
        super("Link not found with code: " + code);
    }
}
