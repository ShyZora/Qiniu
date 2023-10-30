package com.security.service.impl;

import com.common.model.ResponseResult;

import com.security.pojo.User;
import com.security.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Objects;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private AuthenticationManager authenticationManager;
    HashMap<String,LoginUser> temporary = new HashMap<>();
    @Override
    public ResponseResult login(User user){
        // AuthenticationManager 进行用户认证
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getNickName(),user.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        // 认证是否通过
        if(Objects.isNull(authenticate)) {
            throw new RuntimeException("用户或者密码错误");
        }
        // 利用 UserId生成token
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        String userId = loginUser.getUser().getId().toString();
        String jwt = JwtUtil.createJWT(userId);

        // 用hashmap 暂存token
        temporary.put("login:" + userId,loginUser);
        // token 响应给前端
        HashMap<String,String> map = new HashMap<>();
        map.put("token",jwt);
        return new ResponseResult(200,"登录成功",map);
    }
    @Override
    public LoginUser getLoginUser(String userId) {
        return temporary.get(userId);
    }

    @Override
    public ResponseResult logout() {
        // 获取SecurityContextHolder中的用户id
        UsernamePasswordAuthenticationToken authentication = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        Integer userId = loginUser.getUser().getId();
        // 删除redis中的值
        temporary.replace("login:" + userId,null);
        return new ResponseResult(200,"注销成功");
    }
}
