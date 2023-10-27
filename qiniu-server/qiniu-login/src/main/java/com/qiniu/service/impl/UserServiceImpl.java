package com.qiniu.service.impl;

import com.qiniu.dao.UserDao;
import com.qiniu.pojo.User;
import com.qiniu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    // 接收来自dao层的数据库数据并与前端提供的信息进行对比返回结果
    public Boolean LoginService(String username, String password) {
        User user = userDao.Login();
        String name = user.getName();
        String userPassword = user.getPassword();
//        System.out.println(name + " " + userPassword + "  " + username + "  " + password);
        if(username.equals(name)) {
            if(password.equals(userPassword)) return true;
            else return false;
        }
        return false;
    }
}
