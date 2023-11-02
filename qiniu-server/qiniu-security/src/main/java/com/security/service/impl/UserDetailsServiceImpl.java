package com.security.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.security.pojo.LoginUser;
import com.security.dao.MenuMapper;
import com.security.dao.UserMapper;
import com.security.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

// 重写类实现 UserDetailsService接口查询数据库
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private MenuMapper menuMapper;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper();
        wrapper.eq(User::getNickName, username);
        User user = userMapper.selectOne(wrapper);
        if(Objects.isNull(user)) {
            throw new RuntimeException("用户名或者密码错误");
        }
        // 查询用户权限信息，添加到LoginUser
       // List<String> menuKeyList = menuMapper.selectMenuKeyById(user.getId());
        // 封装成LoginUser返回
        System.out.println("loadUsername");
        return new LoginUser(user,null);
    }
}
