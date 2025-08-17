package com.ss_reservation.ss_reservation_core.account.controller;

import com.ss_reservation.ss_reservation_core.account.entity.AccountType;
import com.ss_reservation.ss_reservation_core.account.service.AccountTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("accountType")
public class AccountTypeController {

    @Autowired
    AccountTypeService accountTypeService;

    @GetMapping("getAll")
    public List<AccountType> checkUser() {
        return accountTypeService.getAll();
    }
}
