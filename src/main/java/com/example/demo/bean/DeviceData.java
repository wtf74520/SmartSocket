package com.example.demo.bean;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class DeviceData {
    private int id;
    private int deviceId;
    private Timestamp timestamp;
    private float current;
    private float power;
    private String status;
}