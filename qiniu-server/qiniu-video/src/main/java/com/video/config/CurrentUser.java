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
        LoginUser loginUser;
        try {
            JSON json = (JSON) JSON.toJSON(principal);
            loginUser = JSON.toJavaObject(json, LoginUser.class);
        }catch (ClassCastException e){
            return 0L;
        }
        return loginUser.getUser().getId();
    }
}
