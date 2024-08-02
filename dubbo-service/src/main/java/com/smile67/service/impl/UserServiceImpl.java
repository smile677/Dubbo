package com.smile67.service.impl;

import com.smile67.pojo.User;
import com.smile67.service.UserService;
import org.apache.dubbo.config.annotation.Service;


//@Service// 将该类的对象创建出来，放到Spring的IOC容器中 bean定义
// 导入dubbo的注解  将这个类提供的方法（服务）对外发布。将访问的ip端口路径注册到 注册中心
@Service(timeout = 3000, retries = 0)
public class UserServiceImpl implements UserService {
    @Override
    public String sayHello() {
        return "hello duubbo! hello";
    }

    @Override
    public User findUserById(int id) {
        // 查询用户
        User user = new User(id, "张三", "123");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return user;
    }
}
