package com.example.gtasks.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.gtasks.service.HelloService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/hello")
public class HelloController {
    @Autowired
    private HelloService service;

    @GetMapping("")
    public String getHello(){
        return service.sayHello();
    }
}
