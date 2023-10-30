package com.security.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.security.dao.UserMapper;
import com.security.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author Wcilzo
 * @since 2023-10-28
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserMapper userMapper;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 根据用户名查询用户信息
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getNickName,username);
        User user = userMapper.selectOne(wrapper);
        // 查询不到返回错误
        if(Objects.isNull(user)) {
            throw new RuntimeException("用户名或者密码错误");
        }
        // TODO 根据用户查询 LoginUser中
        List<String> list = new ArrayList<>(Arrays.asList("test","admin"));
        // 返回UserDetails
        return new LoginUser(user,list);
    }
}
