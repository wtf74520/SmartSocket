package com.example.demo.controller;

import com.example.demo.bean.User;
import com.example.demo.service.MqttService;
import com.example.demo.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Log4j2
@Controller
public class HelloController {
    @Value("${spring.application.name}")
    String appName;

    @Autowired
    UserService userService;
    @Autowired
    MqttService mqttService;

    @GetMapping("/")
    public String homePage() {

        return "home";
    }
    @ResponseBody
    @GetMapping("/user")
    public User getUserById(@RequestParam("id") Long id) {
        log.info("userId: " + id);
        if(id==1){
            mqttService.sendMessageToDevice("on","1");
        } else if (id == 0) {
            mqttService.sendMessageToDevice("on","0");
        }
        User user = userService.getUserById(id);
        //System.out.println(user.toString());
        return user;
    }
}
