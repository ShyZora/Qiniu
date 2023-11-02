package com.video;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@SpringBootTest
public class TestApplication {
    @Autowired
    private DataSource dataSource;
    @Test
    public void TestBCryptPasswordEncoder() {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encode = passwordEncoder.encode("abc");
        System.out.println(encode);
    }
    @Test
    public void testConnection() throws Exception {
        System.out.println(dataSource.getConnection());
    }
}
