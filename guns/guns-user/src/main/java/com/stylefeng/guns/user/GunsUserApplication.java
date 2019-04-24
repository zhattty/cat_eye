package com.stylefeng.guns.user;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubboConfig;
import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDubboConfiguration
@SpringBootApplication(scanBasePackages = {"com.stylefeng.guns"})
public class GunsUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(GunsUserApplication.class, args);
    }
}
