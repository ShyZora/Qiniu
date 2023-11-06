package com.security.controller;

import com.common.model.ResponseResult;
import com.security.pojo.User;
import com.security.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {
    @Autowired
    private RegisterService registerService;

    @PostMapping("/user/register")
    public ResponseResult register(@RequestBody User user) {
        return registerService.register(user);
    }
}
