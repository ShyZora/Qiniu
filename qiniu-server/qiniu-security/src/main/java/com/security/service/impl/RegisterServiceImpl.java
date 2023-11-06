package com.security.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.segments.MergeSegments;
import com.common.model.ResponseResult;
import com.security.dao.UserMapper;
import com.security.dao.UserRoleMapper;
import com.security.pojo.User;
import com.security.pojo.UserRole;
import com.security.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public ResponseResult register(User user, Long roleId) {
        try {
            userMapper.insert(user);
            // 注册权限
            UserRole userRole = new UserRole();
            userRole.setUserId(user.getId());
            userRole.setRoleId(roleId);
            userRoleMapper.insert(userRole);
        } catch (Exception e) {
            return new ResponseResult(HttpStatus.FORBIDDEN.value(), "注册失败！", "请输入合适的账号和密码");
        }
        return new ResponseResult(HttpStatus.OK.value(), "注册成功");
    }
}
