package com.ss_reservation.ss_reservation_core.security.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {

    private final BCryptPasswordEncoder passwordEncoder;

    public PasswordEncoder() {
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public String getEncodedPassword(String password) {
        return passwordEncoder.encode(password);
    }

    public boolean isValidPassword(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }
}
