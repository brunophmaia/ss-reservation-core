package com.ss_reservation.ss_reservation_core.account.controller;

import com.ss_reservation.ss_reservation_core.account.model.AccountDTO;
import com.ss_reservation.ss_reservation_core.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("account")
public class AccountController {

    @Autowired
    AccountService accountService;

    @PostMapping(produces = "application/json")
    public void createUser(@RequestBody AccountDTO account) {
        accountService.createUser(account);
    }

    @PostMapping("sendEmailCode")
    public void sendEmailCode(@RequestParam String email) {
        accountService.sendEmailCode(email);
    }

    @GetMapping("checkUser")
    public boolean checkUser(@RequestParam String username, @RequestParam String password) {
        return accountService.checkUser(username, password);
    }
}
