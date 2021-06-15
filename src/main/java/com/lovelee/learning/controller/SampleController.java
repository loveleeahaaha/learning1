package com.lovelee.learning.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liqiatao
 * @Description 测试nacos配置
 * @since 2021/6/15 11:26
 */
@RestController
@RefreshScope   //打开动态刷新功能
public class SampleController {
    private static final Logger logger = LoggerFactory.getLogger(SampleController.class);

    @Value("${user.name}")
    String userName;

    @Value("${user.age}")
    int age;

    @GetMapping("/user")
    public String getUserMessage() {
        return userName + ":" + age;
    }
}
