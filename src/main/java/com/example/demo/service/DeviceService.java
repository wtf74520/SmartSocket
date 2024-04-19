package com.example.demo.service;

import com.example.demo.pojo.Device;
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


        log.info("Device should be inserted :" + device.getClientId());

        deviceMapper.createDevice(device);


    }

    public void updateDevice(Device device) {
        deviceMapper.updateDevice(device);
    }

    public void deleteDevice(Device device) {
        deviceMapper.deleteDevice(device);
    }

    public Device getDeviceById(String clientId) {
        return deviceMapper.getDeviceById(clientId);
    }
    public int countsHasSameId(String clientId) {
        return deviceMapper.countsHasSameId(clientId);
    }
    public int selectIdByClientId(String clientId){
        return deviceMapper.selectIdByClientId(clientId);
    }
}