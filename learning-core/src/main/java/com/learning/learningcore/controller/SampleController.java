package com.learning.learningcore.controller;

import com.alibaba.nacos.api.exception.NacosException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liqiatao
 * @Description 测试nacos配置、nacos java客户端方法
 * @since 2021/6/15 11:26
 */
@RestController
@RequestMapping("/core")
@RefreshScope   //打开动态刷新功能
public class SampleController {

    @Value("${user.name}")
    String userName;

    @Value("${user.age}")
    int age;

//    @Value("${spring.application.name}")
//    String serviceName;

    @Value("${spring.cloud.nacos.discovery.server-addr}")
    String serverAddr;

    @Value("${server.port}")
    String port;

    /**
     * 从nacos配置中获取信息
     *
     * @return
     */
    @GetMapping("/user")
    public String getUserMessage() {
        return userName + ":" + age;
    }

    /**
     * @return
     * @throws NacosException
     */
    @GetMapping("/testnacos")
    public String testNacos() throws NacosException {
        //       NamingService naming = NamingFactory.createNamingService(serverAddr);
        //获取nacos服务下所有实例
//        List<Instance> allInstances = naming.getAllInstances(serviceName);

        //获取健康或不健康的实例列表
        //List<Instance> instances = naming.selectInstances(serviceName, true);
        //return JSON.toJSONString(instances);
        return "";
    }

    @GetMapping("/getport")
    public String getPort() {
        System.out.println("+++++" + port);
        return port;
    }
}
