package com.security.controller;

import com.common.model.ResponseResult;
import com.security.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogoutController {
    @Autowired
    private LoginService loginService;
    @RequestMapping("/user/logout")
    public ResponseResult Logout(){
        return loginService.logout();
    }
}
