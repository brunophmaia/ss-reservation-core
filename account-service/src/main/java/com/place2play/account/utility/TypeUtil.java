package com.place2play.account.utility;

public class TypeUtil {
    public static boolean isStringNullOrEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }

    public static boolean isLongNullOrEmpty(Long value) {
        return value == null;
    }
}
