package com.place2play.account.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTokenServiceUtil extends JwtUtil {

    public JwtTokenServiceUtil(@Value("${security.service-secret-key}") String secretKey) {
        super(secretKey);
    }

    public String generateToken() {
        return Jwts.builder()
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 10)) //10min
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }
}