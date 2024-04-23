package com.example.demo.controller;


import com.example.demo.pojo.Device;
import com.example.demo.pojo.PayloadData;
import com.example.demo.service.DeviceDataService;
import com.example.demo.service.DeviceService;
import com.example.demo.service.PayloadDataService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    PayloadDataService payloadDataService;
    @Autowired
    DeviceService deviceService;
    @PostMapping("/hook")
    public ResponseEntity<String> handlePostRequest(@RequestBody String json) {
        String inOrStat = "";
        JsonNode rootNode = null;
        Device device = new Device() ;
        PayloadData payloadData = null;
        String payload = "";
        log.info(json);
        try {
            rootNode = objectMapper.readTree(json);

        } catch (Exception e) {
            log.error("Error stack{}", Arrays.toString(e.getStackTrace()));
        }

        if(rootNode != null && rootNode.asText().equals("\"state\": 0")){


            log.info("Death message received");
            return ResponseEntity.ok(json);
            //payloadDataService.insertPayloadData(new PayloadData());
        }

        if (rootNode != null && rootNode.has("event") && rootNode.has("topic")) {
            String topic = rootNode.get("topic").asText();
            int lastIndex = topic.lastIndexOf('/');
            if (lastIndex != -1 && lastIndex < topic.length() - 1) {
                inOrStat = topic.substring(lastIndex + 1);
                log.info("topic inOrStat: {}", inOrStat);
            }
        }
        if (inOrStat.equals("stat")){ //need save data to database
            if(!rootNode.get("clientid").asText().isEmpty()){

                log.info("client id :{}",rootNode.get("clientid").asText());
                log.info("peerhost :{}",rootNode.get("peerhost").asText());
                device.setClientId(rootNode.get("clientid").asText());
                device.setDeviceName(rootNode.get("peerhost").asText());
                if(deviceService.countsHasSameId(device.getClientId())==0){
                    deviceService.createDevice(device);
                }

            }
            if(rootNode.get("payload")!=null){
                payload = rootNode.get("payload").asText();
                //log.info("payload: " + payload) ;
                try {
                    payloadData = objectMapper.readValue(payload, PayloadData.class);
                } catch (Exception e){
                    log.error("Error stack{}", Arrays.toString(e.getStackTrace()));
                }
                if(payloadData!=null){
                    payloadData.setDeviceId(deviceService.selectIdByClientId(device.getClientId()));
                    log.info("setDeviceId : {}",deviceService.selectIdByClientId(device.getClientId()));
                    payloadDataService.insertPayloadData(payloadData);
                }



                //deviceDataService.createDeviceData(payloadData.get);


            }


        }



        return ResponseEntity.ok(json);
    }
}
