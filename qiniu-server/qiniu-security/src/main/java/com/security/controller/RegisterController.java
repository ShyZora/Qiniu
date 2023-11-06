package com.security.controller;

import com.common.model.ResponseResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.security.pojo.User;
import com.security.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class RegisterController {
    @Autowired
    private RegisterService registerService;

    @PostMapping("/user/register")
    public ResponseResult register(@RequestBody Map<String, Object> requestData) {
        User user = new ObjectMapper().convertValue(requestData.get("user"), User.class);
        Long roleId = Long.parseLong(requestData.get("roleId").toString());
        return registerService.register(user, roleId);
    }
}
