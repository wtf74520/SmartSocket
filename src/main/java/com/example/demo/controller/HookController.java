package com.example.demo.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Log4j2
public class HookController {

    @PostMapping("/hook")
    public ResponseEntity<String> handlePostRequest(@RequestBody String json) {
        // Your logic to process the data goes here
        // For demonstration purposes, just returning the data as is
        log.info(json);
        System.out.println("hooked");
        return ResponseEntity.ok(json);
    }
}
