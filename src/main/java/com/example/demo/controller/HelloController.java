package com.example.demo.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Log4j2
@Controller
public class HelloController {
    @Value("${spring.application.name}")
    String appName;

    @GetMapping("/")
    public String homePage() {

        return "home";
    }
}
