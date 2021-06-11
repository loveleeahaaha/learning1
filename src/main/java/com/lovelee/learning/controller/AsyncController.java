package com.lovelee.learning.controller;

import com.lovelee.learning.service.AsyncService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liqiatao
 * @Description
 * @since 2021/6/11 9:36
 */
@RestController
public class AsyncController {
    private static final Logger logger = LoggerFactory.getLogger(AsyncController.class);
    
    @Autowired
    private AsyncService asyncService;

    @RequestMapping("/")
    public String submit() {
        logger.info("start submit");
        asyncService.executeAsync();
        logger.info("end submit");
        return "success";
    }
}
