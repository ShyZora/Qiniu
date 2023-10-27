package com.qiniu.dao.impl;

import com.qiniu.dao.UserDao;
import com.qiniu.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDaoImpl implements UserDao {
    @Autowired
    @Override
    public User Login(){
        // 假设数据库返回账号信息为 name : 111 , password : 123
        String name = "111";
        String password = "123";
        User user = new User(name,password);
        return user;
    }
}
