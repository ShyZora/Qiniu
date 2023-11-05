package com.security;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.security.dao")
public class SecuritySystemApplication {
    public static void main(String[] args){
        SpringApplication.run(SecuritySystemApplication.class, args);
    }
}
