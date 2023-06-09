package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@MapperScan("com.example.dao")
@SpringBootApplication
@EnableFeignClients
public class BorrowApplication {
    public static void main(String[] args) {
        SpringApplication.run(BorrowApplication.class,args);
    }
}