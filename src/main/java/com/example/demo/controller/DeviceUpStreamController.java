package com.example.demo.controller;

import com.example.demo.bean.User;
import com.example.demo.service.MqttService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Log4j2
@Controller
public class DeviceUpStreamController {
//    @Autowired
//    MqttService mqttService;
//    @ResponseBody
//    @GetMapping("/upload")
//    public User (@RequestParam("id") Long id) {
//        log.info("userId: " + id);
//        if(id==1){
//            mqttService.sendMessage("1");
//        } else if (id == 0) {
//            mqttService.sendMessage("0");
//        }
//        //User user = userService.getUserById(id);
//        //System.out.println(user.toString());
//        return user;
//    }
}
