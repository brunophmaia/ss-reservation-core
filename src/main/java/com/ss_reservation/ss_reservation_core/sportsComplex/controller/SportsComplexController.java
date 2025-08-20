package com.ss_reservation.ss_reservation_core.sportsComplex.controller;

import com.ss_reservation.ss_reservation_core.sportsComplex.model.SportsComplexDTO;
import com.ss_reservation.ss_reservation_core.sportsComplex.service.SportsComplexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sportsComplex")
public class SportsComplexController {

    @Autowired
    SportsComplexService sportsComplexService;

    @PostMapping(produces = "application/json")
    public void create(@RequestBody SportsComplexDTO sportsComplexDTO) {
        sportsComplexService.create(sportsComplexDTO);
    }
}
