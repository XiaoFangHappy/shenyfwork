package com.shenyf.shenyfwork;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@ComponentScan(basePackages = { "com.shenyf.shenyfwork.dao" })
public class ShenyfServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShenyfServiceApplication.class, args);
    }

}
