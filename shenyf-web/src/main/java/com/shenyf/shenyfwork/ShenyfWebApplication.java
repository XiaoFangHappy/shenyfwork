package com.shenyf.shenyfwork;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class ShenyfWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShenyfWebApplication.class, args);
    }

}
