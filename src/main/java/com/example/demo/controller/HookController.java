package com.example.demo.controller;


import com.example.demo.bean.Device;
import com.example.demo.bean.PayloadData;
import com.example.demo.service.DeviceDataService;
import com.example.demo.service.DeviceService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    DeviceDataService deviceDataService;
    @Autowired
    DeviceService deviceService;
    @PostMapping("/hook")
    public ResponseEntity<String> handlePostRequest(@RequestBody String json) {
        log.info(json);
        String payload = "";
        String clientId = "";
        PayloadData payloadData;
        Device device = new Device() ;
        log.info("hooked");
        try {
            JsonNode rootNode = objectMapper.readTree(json);
            //log.info("rootNode : " + rootNode.toString()) ;
            if(rootNode.get("clientid")!=null){
                log.info("client id :{}",rootNode.get("clientid").asInt());
                device.setDeviceId(rootNode.get("clientid").asInt());
                device.setDeviceName(rootNode.get("peerhost").asText());
                //deviceService.createDevice(device);
            }
            if(rootNode.get("payload")!=null){
                payload = rootNode.get("payload").asText();
                //log.info("payload: " + payload) ;
                payloadData = objectMapper.readValue(payload, PayloadData.class);

            }
            //(#{deviceId}, #{timestamp}, #{current}, #{power}, #{status})
//            deviceDataService.createDeviceData(payloadData.get);

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
