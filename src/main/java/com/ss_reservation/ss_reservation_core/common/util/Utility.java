package com.ss_reservation.ss_reservation_core.common.util;

public class Utility {
    public static boolean isStringNullOrEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }

    public static boolean isLongNullOrEmpty(Long value) {
        return value == null;
    }
}
