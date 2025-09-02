package com.place2play.auth.controller;

import com.place2play.auth.model.LoginDTO;
import com.place2play.auth.service.LoginService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth/")
public class AuthController {

    @Autowired
    LoginService loginService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDTO login, HttpServletResponse response) {

        Cookie cookie = new Cookie("token", loginService.login(login));
        cookie.setHttpOnly(true);
        cookie.setSecure(true);
        cookie.setPath("/");
        //cookie.setDomain(".domain.com"); // when production
        cookie.setMaxAge(24 * 60 * 60);
        response.addCookie(cookie);

        return ResponseEntity.ok("OK");
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }

        Cookie cookie = new Cookie("token", null);
        cookie.setHttpOnly(true);
        cookie.setSecure(true);
        cookie.setPath("/");
        cookie.setMaxAge(0);
        response.addCookie(cookie);

        SecurityContextHolder.clearContext();

        return ResponseEntity.ok("Logout");
    }
}
