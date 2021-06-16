package com.learning.learningcore.service.impl;

import com.learning.learningcore.component.ThreadLoggerPrint;
import com.learning.learningcore.service.AsyncService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author liqiatao
 * @Description
 * @since 2021/6/11 9:32
 */
@Service
public class AsyncServiceImpl implements AsyncService {
    private static final Logger logger = LoggerFactory.getLogger(AsyncServiceImpl.class);

    @Override
    @ThreadLoggerPrint
    @Async("asyncServiceExecutor")
    public void executeAsync() {
        //logger.info("start executeAsync");
        try {
            logger.info("executeAsync  ing........");
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //logger.info("end executeAsync");
    }
}
