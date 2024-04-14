package com.example.demo.service;

import com.example.demo.bean.DeviceData;
import com.example.demo.mapper.DeviceDataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeviceDataService {
    @Autowired
    DeviceDataMapper deviceDataMapper;



    public void createDeviceData(DeviceData deviceData) {

        deviceDataMapper.createDeviceData(deviceData);
    }

    public void updateDeviceData(DeviceData deviceData) {
        deviceDataMapper.updateDeviceData(deviceData);
    }

    public void deleteDeviceData(int deviceDataId) {
        deviceDataMapper.deleteDeviceData(deviceDataId);
    }

    public DeviceData getDeviceDataById(int deviceDataId) {
        return deviceDataMapper.getDeviceDataById(deviceDataId);
    }
}