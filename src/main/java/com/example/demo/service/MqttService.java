package com.example.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.*;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MqttService {

    private static final String BROKER = "tcp://localhost:1883"; // MQTT broker的地址
    private static final String TOPIC = "oldfox126/esp12s/bl0942/c8c9a33ed480/in"; // MQTT主题

    private MqttClient mqttClient;

    public MqttService() {
        try {
            mqttClient = new MqttClient(BROKER, MqttClient.generateClientId());
            mqttClient.connect();
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    public void sendMessageToDevice(String msg, String value) {
        String message = "{\"m\":\""+ msg + "\",\"v\":\"" + value + "\"}";

        try {
            MqttMessage mqttMessage = new MqttMessage(message.getBytes());
            mqttClient.publish(TOPIC, mqttMessage);
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    public void disconnect() {
        try {
            mqttClient.disconnect();
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }
}