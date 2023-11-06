package com.category;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.category.dao")
public class CategorySystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(CategorySystemApplication.class, args);
    }
}
