package com.video.config;

import com.alibaba.fastjson.JSON;
import com.video.pojo.LoginUser;
import com.video.pojo.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Principal;

/**
 * @program: Qiniu
 * @description:
 * @author: ShyZOra
 * @create: 2023-11-03 14:36
 **/
@Component
public class CurrentUser {

    public static Long getUserId(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        JSON json = (JSON) JSON.toJSON(principal);
        LoginUser loginUser = JSON.toJavaObject(json,LoginUser.class);
        return loginUser.getUser().getId();
    }
}
