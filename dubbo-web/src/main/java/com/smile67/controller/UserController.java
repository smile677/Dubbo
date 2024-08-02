package com.smile67.controller;

import com.smile67.pojo.User;
import com.smile67.service.UserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    // 注入userService
    //@Autowired // 本地注入

    /**
     * 1. 从注册中心zookeeper获取userService的访问url地址
     * 2. 通过url地址远程调用userService（RPC）
     * 3. 将调用结果封装为一个代理对象，给变量赋值
     */
    @Reference(loadbalance = "roundrobin") // 远程注入
    private UserService userService;

    @RequestMapping("/sayHello")
    public String sayHello() {
        return userService.sayHello();
    }

    /**
     * 根据id查询用户信息
     *
     * @param id
     * @return
     */
    int i = 1;

    @RequestMapping("/find")
    public User find(int id) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("第" + i++ + "次调用find方法");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }).start();
        return userService.findUserById(id);
    }
}