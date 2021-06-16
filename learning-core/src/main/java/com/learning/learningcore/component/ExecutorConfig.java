package com.learning.learningcore.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author liqiatao
 * @Description 线程池配置(@ Configuration, @ Component将该类交由IoC容器管理 ， @ Bean注解声明一个方法产生一个bead实例并交由容器管理)
 * @since 2021/6/11 9:40
 */
@Configuration
@EnableAsync
public class ExecutorConfig {
    private static final Logger logger = LoggerFactory.getLogger(ExecutorConfig.class);

    @Bean
    public Executor asyncServiceExecutor() {
        logger.info("start asyncServiceExecutor");
        ThreadPoolTaskExecutor executor = new VisiableThreadPoolTaskExecutor();
        //核心线程数
        executor.setCorePoolSize(5);
        //最大线程数
        executor.setMaxPoolSize(5);
        //任务队列
        executor.setQueueCapacity(1000);
        //线程前缀设置
        executor.setThreadNamePrefix("async-service-");
        //最大线程满了后执行拒绝策略，CallerRunsPolicy：不在新建线程中执行任务，而是用调用者所在的线程执行
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        //执行初始化
        executor.initialize();
        return executor;
    }
}
