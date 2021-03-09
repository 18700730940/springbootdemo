package com.sir.springbootdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InitConfig {
    @Bean
    public TestConfig testConfig(){
        return new TestConfig(1,"测试配置文件名称");
    }
}
