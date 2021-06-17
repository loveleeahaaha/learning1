package com.learning.learningconsumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author liqiatao
 * @Description
 * @since 2021/6/17 17:10
 */
@Component
@FeignClient(value = "core")
public interface TestFeign {
    @GetMapping(value = "/core/getport")
    String test();
}
