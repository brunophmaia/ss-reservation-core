package com.ss_reservation.ss_reservation_core.Controllers;

import com.ss_reservation.ss_reservation_core.Models.AccountModel;
import com.ss_reservation.ss_reservation_core.Services.Interfaces.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("account")
public class AccountController {

    @Autowired
    AccountService accountService;

    @PostMapping(produces = "application/json")
    public void createUser(@RequestBody AccountModel account) {
        accountService.createUser(account);
    }

    @PostMapping("sendEmailCode")
    public void sendEmailCode(@RequestParam String email) {
        accountService.sendEmailCode(email);
    }
}
