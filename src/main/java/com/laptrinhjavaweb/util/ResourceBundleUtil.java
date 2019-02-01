package com.laptrinhjavaweb.util;

import java.util.ResourceBundle;

public class ResourceBundleUtil {
    private static ResourceBundle resourceBundle = ResourceBundle.getBundle("message");

    public static String getString(String key) {
        return resourceBundle.getString(key);
    }
}
