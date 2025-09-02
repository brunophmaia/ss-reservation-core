package com.place2play.account.controller;

import com.place2play.account.model.dto.AccountDTO;
import com.place2play.account.service.AccountService;
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
    public Long checkUser(@RequestParam String username, @RequestParam String password) {
        return accountService.checkUser(username, password);
    }
}
