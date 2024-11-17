package com.ss_reservation.ss_reservation_core.login.controller;

import com.ss_reservation.ss_reservation_core.account.model.AccountDTO;
import com.ss_reservation.ss_reservation_core.login.model.LoginDTO;
import com.ss_reservation.ss_reservation_core.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("login")
public class LoginController {

    @Autowired
    LoginService loginService;

    @PostMapping(produces = "application/json")
    public void login(@RequestBody LoginDTO login) {
        loginService.login(login);
    }
}
