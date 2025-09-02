package com.place2play.auth.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTokenClientUtil extends JwtUtil{

    public JwtTokenClientUtil(@Value("${security.secret-key}") String secretKey) {
        super(secretKey);
    }

    public String generateToken(String id) {
        return Jwts.builder()
                .id(id)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 10)) //10min
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }
}