package com.example.demo.controller;


import com.example.demo.bean.PayloadData;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.beans.BeanProperty;
import java.util.Arrays;

@RestController
@RequestMapping("/api")
@Log4j2
public class HookController {
    private final ObjectMapper objectMapper;

    public HookController(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }


    @PostMapping("/hook")
    public ResponseEntity<String> handlePostRequest(@RequestBody String json) {
        // Your logic to process the data goes here
        // For demonstration purposes, just returning the data as is
        //log.info(json);
        String payload = "";
        PayloadData payloadData;
        log.info("hooked");
        try {
            JsonNode rootNode = objectMapper.readTree(json);
            //log.info("rootNode : " + rootNode.toString()) ;
            if(rootNode.get("payload")!=null){
                payload = rootNode.get("payload").asText();
                log.info("payload: " + payload) ;
                payloadData = objectMapper.readValue(payload, PayloadData.class);
            }else{

            }


            // 在这里可以对payloadData进行进一步处理或操作

            //log.info("Received payload: " + payloadData.toString()) ;
        } catch (Exception e) {
            // 处理解析JSON时的异常
            //return (ResponseEntity<String>) ResponseEntity.notFound();
            log.error("Error stack{}", Arrays.toString(e.getStackTrace()));
        }
        return ResponseEntity.ok(json);
    }
}
