package com.security.filter;

import com.alibaba.fastjson.JSON;
import com.security.pojo.LoginUser;
import com.security.utils.JwtUtil;
import com.security.utils.RedisCache;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {
    @Autowired
    private RedisCache redisCache;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // 获取前端请求头中的 token
        String token = request.getHeader("token");
        // 如果请求头中 token 为空则放行
        if (!StringUtils.hasText(token)) {
            // 放行
            filterChain.doFilter(request, response);
            return;
        }
        // 不为空解析 token 并判断是否非法
        String userId;
        try {
            Claims claims = JwtUtil.parseJWT(token);
            userId = claims.getSubject();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("token 非法");
        }
        // 从内存中拿到 authenticate
        String userKey = "login:" + userId;
        JSON json = (JSON) JSON.toJSON(redisCache.getCacheObject(userKey));
        System.out.println(json + "json");
        LoginUser loginUser = JSON.toJavaObject(json, LoginUser.class);
        System.out.println(loginUser.toString());
        if(Objects.isNull(loginUser)) {
            throw new RuntimeException("用户未登录");
        }
        // 存入SecurityContextHolder
        // 获取权限信息封装到Authentication中
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(loginUser,null,loginUser.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        // 放行
        filterChain.doFilter(request,response);
    }
}
