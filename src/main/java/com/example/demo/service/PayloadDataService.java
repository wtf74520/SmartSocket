package com.example.demo.service;

import com.example.demo.mapper.PayloadDataMapper;
import com.example.demo.pojo.PayloadData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PayloadDataService {
    @Autowired
    PayloadDataMapper payloadDataMapper;
    public void insertPayloadData(PayloadData payloadData){
        String payloadDataTime = payloadData.getTime();
        if(payloadDataTime==null){
            log.info("[PayloadDataService] : payloadData {} is null , not insert:",payloadDataTime);
            return;
        }
        log.info("[PayloadDataService] : payloadData {} need to be inserted:",payloadData.getTime());
        payloadDataMapper.insertPayloadData(payloadData);
    }
    public PayloadData selectLatestPayloadData(){
        return payloadDataMapper.selectLatestPayloadData();
    }
}
