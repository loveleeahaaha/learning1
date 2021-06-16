package com.learning.learningcore.component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author liqiatao
 * @Description 自定义注解，结合AOP打印线程日志
 * @since 2021/6/11 11:38
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ThreadLoggerPrint {
    String param() default "";
}
