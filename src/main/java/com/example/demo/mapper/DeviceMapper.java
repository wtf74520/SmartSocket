package com.example.demo.mapper;

import com.example.demo.bean.Device;

public interface DeviceMapper {
    void createDevice(Device device);
    void updateDevice(Device device);
    void deleteDevice(int deviceId);
    Device getDeviceById(int deviceId);
}