package com.login.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.common.model.ResponseResult;
import com.login.pojo.User;
import com.login.dao.UserMapper;
import com.login.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author Wcilzo
 * @since 2023-10-28
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public ResponseResult LoginTest(String username,String password){
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        queryWrapper.eq("nick_name",username);
        queryWrapper.eq("password",password);
        queryWrapper.select("id");
        Integer count = userMapper.selectCount(queryWrapper);
        if(count.equals(1)) return ResponseResult.okResult();
        else return ResponseResult.errorResult(401,"账号或者密码错误");
    }
}
