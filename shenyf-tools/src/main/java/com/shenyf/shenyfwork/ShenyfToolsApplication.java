package com.shenyf.shenyfwork;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.shenyf.dao")
public class ShenyfToolsApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShenyfToolsApplication.class, args);
    }

}
