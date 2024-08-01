package com.smile67.service;

import com.smile67.pojo.User;

public interface UserService {
    public String sayHello();
    /**
     * 查询用户
     */
    public User findUserById(int id);
}
