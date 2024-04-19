package com.example.demo.service;

import com.example.demo.pojo.User;
import com.example.demo.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {
    @Autowired
    UserMapper userMapper;
    public User getUserById(Long id) {
        log.info("id: " + id);
        User user = userMapper.selectByPrimaryKey(id);
        //System.out.println(user.toString());
        return user;
    }
}
