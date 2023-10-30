package com.security.controller;

import com.common.model.ResponseResult;
import com.security.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;
    @PostMapping("/home/login")
    public ResponseResult login(@RequestBody User user) {
        return loginService.login(user);
    }
    @RequestMapping("/home/logout")
    public ResponseResult logout(){
        return loginService.logout();
    }
}