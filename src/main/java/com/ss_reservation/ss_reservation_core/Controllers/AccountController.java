package com.ss_reservation.ss_reservation_core.Controllers;

import com.ss_reservation.ss_reservation_core.Models.AccountModel;
import com.ss_reservation.ss_reservation_core.Services.Interfaces.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("account")
public class AccountController {

    @Autowired
    AccountService accountService;

    @PostMapping(produces = "application/json")
    public void post(@RequestBody AccountModel account) {
        accountService.createUser(account);
    }
}
