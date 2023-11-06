package com.security.service;

import com.common.model.ResponseResult;
import com.security.pojo.User;
import org.springframework.stereotype.Service;

@Service
public interface LoginService {
    public ResponseResult login(User user);

    public Object getLoginUser(String userId);
    public ResponseResult logout();
}
