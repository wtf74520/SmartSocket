package com.example.demo.service;

import com.example.demo.bean.Device;
import com.example.demo.mapper.DeviceMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DeviceService {
    @Autowired
    private DeviceMapper deviceMapper;

    public void createDevice(Device device) {

        if(getDeviceById(device.getDeviceId())==null){
            log.info("Device should be inserted" + device.getDeviceId());
            deviceMapper.createDevice(device);
        }

    }

    public void updateDevice(Device device) {
        deviceMapper.updateDevice(device);
    }

    public void deleteDevice(int deviceId) {
        deviceMapper.deleteDevice(deviceId);
    }

    public Device getDeviceById(int deviceId) {
        return deviceMapper.getDeviceById(deviceId);
    }
}