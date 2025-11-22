package com.tinylink.util;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Pattern;

public class ValidationUtils {

    private static final Pattern CODE_PATTERN = Pattern.compile("^[A-Za-z0-9]{6,8}$");

    public static boolean isValidCode(String code) {
        return code != null && CODE_PATTERN.matcher(code).matches();
    }

    public static boolean isValidUrl(String url) {
        if (url == null || url.trim().isEmpty()) {
            return false;
        }

        try {
            new URL(url);
            return url.startsWith("http://") || url.startsWith("https://");
        } catch (MalformedURLException e) {
            return false;
        }
    }
}
