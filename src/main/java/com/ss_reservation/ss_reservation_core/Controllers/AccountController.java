package com.ss_reservation.ss_reservation_core.Controllers;

import com.ss_reservation.ss_reservation_core.Models.AccountModel;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("account")
public class AccountController {

    @PostMapping(produces = "application/json")
    public AccountModel post(@RequestBody AccountModel account) {
        return account;
    }
}
