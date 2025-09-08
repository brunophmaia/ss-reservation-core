package com.place2play.sportsComplex.controller;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("sportsComplex")
public class SportsComplexController {

    @GetMapping("getAll")
    public List<String> getAll() {
        return new ArrayList<String>();
    }
}
