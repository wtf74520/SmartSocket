package com.example.demo.controller;

import com.example.demo.pojo.PayloadData;
import com.example.demo.service.MqttService;
import com.example.demo.service.PayloadDataService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Log4j2
@Controller
public class DeviceUpStreamController {
    @Autowired
    MqttService mqttService;
    @Autowired
    PayloadDataService payloadDataService;
    @ResponseBody
    @GetMapping("/appUpStream")
    public PayloadData handleMqttMsg(@RequestParam("msg") String  msg, @RequestParam("value") String  value) {

        log.info("handleMqttMsg msg : {} value : {}", msg,value);
        mqttService.sendMessageToDevice(msg,value);
        //查表 top1

        return payloadDataService.selectLatestPayloadData();
    }
}
