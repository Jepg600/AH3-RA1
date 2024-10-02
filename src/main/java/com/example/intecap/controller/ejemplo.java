package com.example.intecap.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api")
public class ejemplo {
 
    @GetMapping("")
    public String hola() {
        return "Holaaaaa Mundo";
    }
    
}
 