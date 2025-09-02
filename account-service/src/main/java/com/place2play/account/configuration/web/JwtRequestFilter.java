package com.place2play.account.configuration.web;

import com.place2play.account.security.JwtTokenClientUtil;
import com.place2play.account.security.JwtTokenServiceUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    @Autowired
    private JwtTokenServiceUtil jwtTokenServiceUtil;

    @Autowired
    private JwtTokenClientUtil jwtTokenClientUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain) throws ServletException, IOException {

        String serviceJwt = request.getHeader("X-Service-Token");
        String clientJwt = request.getHeader("X-Client-Token");

        if (serviceJwt == null || !jwtTokenServiceUtil.isValidToken(serviceJwt)) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        if (SecurityContextHolder.getContext().getAuthentication() == null) {
            if (clientJwt != null && jwtTokenClientUtil.isValidToken(clientJwt)) {
                Authentication authentication = new UsernamePasswordAuthenticationToken(Long.parseLong(jwtTokenClientUtil.extractUserId(clientJwt)), null, null);
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }

        chain.doFilter(request, response);
    }
}