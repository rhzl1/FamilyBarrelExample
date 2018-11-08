package com.example.controller;

import com.example.service.HomeSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeCtl {

    @Autowired
    HomeSer homeSer;

    @GetMapping("/")
    public String index(){

        return homeSer.index();
    }
}
