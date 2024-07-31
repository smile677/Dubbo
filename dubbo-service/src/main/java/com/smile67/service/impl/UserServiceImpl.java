package com.smile67.service.impl;

import com.smile67.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public String sayHello() {
        return "hello duubbo!";
    }
}
