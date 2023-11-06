package com.security.service.impl;

import com.common.model.ResponseResult;
import com.security.dao.UserRoleMapper;
import com.security.pojo.UserRole;
import com.security.utils.JwtUtil;
import com.security.pojo.LoginUser;
import com.security.pojo.User;
import com.security.service.LoginService;
import com.security.utils.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Objects;

// 重写类 实现AuthenticationManager接口
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private RedisCache redisCache;

    @Override
    public ResponseResult login(User user) {
        // 根据 username 和 密码生成认证
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getNickName(),user.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        // 判断认证是否通过
        if(Objects.isNull(authenticate)) {
            throw new RuntimeException("用户名或者密码错误");
        }
        // 使用 userId 生成 token
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        String userId = loginUser.getUser().getId().toString();
        String jwt = JwtUtil.createJWT(userId);
        // 将生成的 authenticate 保存到本地
        redisCache.setCacheObject("login:" + userId, loginUser);

        // 将token返回给前端
        HashMap<String,String> map = new HashMap<>();
        map.put("token",jwt);
        return new ResponseResult(200,"登录成功",map);
    }

    @Override
    public LoginUser getLoginUser(String userId) {
        return (LoginUser) redisCache.getCacheObject(userId);
    }

    @Override
    public ResponseResult logout() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        Long userId = loginUser.getUser().getId();
        redisCache.deleteObject("login:" + userId);
        return new ResponseResult(200,"退出成功");
    }
}