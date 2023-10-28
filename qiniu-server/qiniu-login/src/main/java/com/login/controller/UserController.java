package com.login.controller;


import com.common.model.ResponseResult;
import com.login.service.UserService;
import com.login.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author Wcilzo
 * @since 2023-10-28
 */
@RestController
@RequestMapping("/home")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/login")
    public ResponseResult Login(String username, String password){
        return userService.LoginTest(username, password);
    }
}

