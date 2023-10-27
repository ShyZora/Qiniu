package com.qiniu.controller;

import com.common.model.ResponseResult;
import com.qiniu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class UserLogin {
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public ResponseResult userLogin(@RequestParam(name = "name", required = false) String username, String password) {
        if (userService.LoginService(username, password)) return ResponseResult.okResult();
        else return ResponseResult.errorResult(200, "账号或者密码错误");
    }
}
