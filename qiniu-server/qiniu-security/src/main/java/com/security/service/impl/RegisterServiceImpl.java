package com.security.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.segments.MergeSegments;
import com.common.model.ResponseResult;
import com.security.dao.UserMapper;
import com.security.pojo.User;
import com.security.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public ResponseResult register(User user) {
        try {
            userMapper.insert(user);
        } catch (Exception e) {
            return new ResponseResult(HttpStatus.FORBIDDEN.value(), "注册失败！", "请输入合适的账号和密码");
        }
        return new ResponseResult(HttpStatus.OK.value(), "注册成功");
    }
}
