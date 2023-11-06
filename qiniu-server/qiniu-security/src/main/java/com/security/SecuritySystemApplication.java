package com.security;

import com.github.jeffreyning.mybatisplus.conf.EnableMPP;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableMPP
@MapperScan("com.security.dao")
public class SecuritySystemApplication {
    public static void main(String[] args){
        SpringApplication.run(SecuritySystemApplication.class, args);
    }
}
