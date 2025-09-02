package com.place2play.account.controller;

import com.place2play.account.model.dto.UserInfoDTO;
import com.place2play.account.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
