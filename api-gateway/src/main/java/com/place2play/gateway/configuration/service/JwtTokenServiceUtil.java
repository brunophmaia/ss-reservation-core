package com.place2play.gateway.configuration.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtTokenServiceUtil extends JwtUtil {

    public JwtTokenServiceUtil(@Value("${security.service-secret-key}") String secretKey) {
        super(secretKey);
    }
}