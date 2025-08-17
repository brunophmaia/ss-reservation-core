package com.ss_reservation.ss_reservation_core.sportsComplex.controller;

import com.ss_reservation.ss_reservation_core.sportsComplex.model.SportsComplexDTO;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sportsComplex")
public class SportsComplexController {

    @PostMapping(produces = "application/json")
    public void create(@RequestBody SportsComplexDTO sportsComplexDTO) {
        Long userId = (Long) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.print(userId);
    }
}
