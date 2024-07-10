package com.ss_reservation.ss_reservation_core.Controllers;

import com.ss_reservation.ss_reservation_core.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ss_reservation.ss_reservation_core.Models.UserModel;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(value = "/{id}", produces = "application/json")
    public UserModel get(@PathVariable("id") Long id) {
        return userService.getUser(id);
    }

}
