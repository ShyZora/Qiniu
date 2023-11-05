package com.security.service;

import com.common.model.ResponseResult;
import com.security.pojo.User;

public interface RegisterService {
    public ResponseResult register(User user);
}
