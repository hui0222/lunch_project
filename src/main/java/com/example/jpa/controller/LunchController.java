package com.example.jpa.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LunchController {


    @GetMapping("/lunch")
    public void getLunch() {
    }
}
