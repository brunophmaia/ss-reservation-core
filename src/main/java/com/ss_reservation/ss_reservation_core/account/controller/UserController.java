package com.ss_reservation.ss_reservation_core.account.controller;

import com.ss_reservation.ss_reservation_core.account.model.UserInfoDTO;
import com.ss_reservation.ss_reservation_core.account.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("getUserInfo")
    public UserInfoDTO getUserInfo() {
        return userService.getUserInfo();
    }
}
