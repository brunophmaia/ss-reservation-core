package com.ss_reservation.ss_reservation_core.Security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class SecurityService {

    private final BCryptPasswordEncoder passwordEncoder;

    public SecurityService() {
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public String getEncodedPassword(String password) {
        return passwordEncoder.encode(password);
    }
}
