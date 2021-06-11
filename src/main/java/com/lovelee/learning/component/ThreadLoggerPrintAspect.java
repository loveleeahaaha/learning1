package com.lovelee.learning.component;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author liqiatao
 * @Description 自定义注解对应切面逻辑类
 * @since 2021/6/11 11:42
 */
@Component
@Aspect
public class ThreadLoggerPrintAspect {
    private static final Logger logger = LoggerFactory.getLogger(ThreadLoggerPrintAspect.class);

    @Around("@annotation(threadLoggerPrint)")
    public Object around(ProceedingJoinPoint joinPoint, ThreadLoggerPrint threadLoggerPrint) throws Throwable {
        logger.info("正在执行业务逻辑代码");
        Object o = joinPoint.proceed();
        logger.info("结束执行业务逻辑代码");
        return o;
    }
}
