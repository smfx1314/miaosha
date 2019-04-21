package com.jiangfeixiang.shopmiaosha;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.jiangfeixiang.shopmiaosha.dao")
public class ShopmiaoshaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopmiaoshaApplication.class, args);
    }

}
