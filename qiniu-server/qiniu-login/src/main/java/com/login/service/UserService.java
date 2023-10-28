package com.login.service;

import com.common.model.ResponseResult;
import com.login.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author Wcilzo
 * @since 2023-10-28
 */
public interface UserService extends IService<User> {
    ResponseResult LoginTest(String username,String password);
}
