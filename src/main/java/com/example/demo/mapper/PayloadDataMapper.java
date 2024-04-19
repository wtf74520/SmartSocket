package com.example.demo.mapper;

import com.example.demo.pojo.PayloadData;

public interface PayloadDataMapper {

    void insertPayloadData(PayloadData payloadData);

    PayloadData selectLatestPayloadData();

}