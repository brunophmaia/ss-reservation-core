package com.place2play.gateway.configuration.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtTokenClientUtil extends JwtUtil{

    public JwtTokenClientUtil(@Value("${security.secret-key}") String secretKey) {
        super(secretKey);
    }
}