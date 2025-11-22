package com.tinylink.exception;

public class DuplicateCodeException extends RuntimeException {

    public DuplicateCodeException(String message) {
        super(message);
    }

    public DuplicateCodeException(String code, boolean isCode) {
        super("Code already exists: " + code);
    }
}
