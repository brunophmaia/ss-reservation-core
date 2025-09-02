package com.place2play.account.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import java.util.Date;
import java.util.function.Function;

public class JwtUtil {

    protected String secretKey;

    public JwtUtil(String secretKey){
        this.secretKey = secretKey;
    }

    public String extractUserId(String token) {
        return extractClaim(token, Claims::getId);
    }

    public boolean isValidToken(String token) {
        try {
            return !isTokenExpired(token);
        }
        catch (Exception ex) {
            return false;
        }
    }

    private boolean isTokenExpired(String token) {
        Date d1 = extractExpiration(token);

        return extractExpiration(token).before(new Date());
    }

    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(secretKey).build().parseSignedClaims(token).getPayload();
    }
}