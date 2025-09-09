package com.place2play.sportsComplex.controller;

import com.place2play.sportsComplex.model.dto.SportsComplexDTO;
import com.place2play.sportsComplex.service.SportsComplexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("sportsComplex")
public class SportsComplexController {

    @Autowired
    SportsComplexService sportsComplexService;

    @PostMapping("create")
    public void create(@RequestBody SportsComplexDTO sportsComplexDTO) {
        sportsComplexService.create(sportsComplexDTO);
    }

    @GetMapping("getAll")
    public List<String> getAll() {
        return new ArrayList<String>();
    }
}
