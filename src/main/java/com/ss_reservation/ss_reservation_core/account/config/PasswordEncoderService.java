package com.ss_reservation.ss_reservation_core.account.config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoderService {

    private final BCryptPasswordEncoder passwordEncoder;

    public PasswordEncoderService() {
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public String getEncodedPassword(String password) {
        return passwordEncoder.encode(password);
    }
}
