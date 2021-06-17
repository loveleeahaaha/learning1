package com.learning.learningconsumer.controller;

import com.learning.learningconsumer.service.TestFeign;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author liqiatao
 * @Description
 * @since 2021/6/17 17:05
 */
@RestController
public class TestController {
    @Resource
    TestFeign testFeign;

    @GetMapping(value = "/testfeign")
    public String testFeign() {
        return testFeign.test();
    }
}
