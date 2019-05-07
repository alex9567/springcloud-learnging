package com.chen;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
//动态刷新，需要post访问http://localhost:8881/actuator/refresh
//如果是多个服务注册，就要依次刷新每个端口
@RefreshScope
public class ConfigClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApplication.class, args);
    }

    @Value("${foo}")
    String foo;
    @RequestMapping(value = "/hi")
    public String hi(){
        return foo;
    }
    @Value("${democonfigclient.message}")
    String foo2;
    @RequestMapping(value = "/hi2")
    public String hi2(){
        return foo2;
    }
}
