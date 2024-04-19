package com.example.demo.mapper;

import com.example.demo.pojo.Device;

public interface DeviceMapper {
    void createDevice(Device device);
    void updateDevice(Device device);
    void deleteDevice(Device device);
    Device getDeviceById(String clientId);
    int countsHasSameId(String clientId);
    int selectIdByClientId(String clientId);
}