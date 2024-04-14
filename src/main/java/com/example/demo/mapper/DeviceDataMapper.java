package com.example.demo.mapper;

import com.example.demo.bean.DeviceData;

public interface DeviceDataMapper {
    void createDeviceData(DeviceData deviceData);
    void updateDeviceData(DeviceData deviceData);
    void deleteDeviceData(int deviceDataId);
    DeviceData getDeviceDataById(int deviceDataId);
}