package com.security.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/product")
public class ProductTestController {
    @RequestMapping("/info")
    @ResponseBody
    public String productInfo() {
        String currenUser = "";
        Object principl = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(principl instanceof UserDetails) {
            currenUser = ((UserDetails)principl).getUsername();
        }else {
            currenUser = principl.toString();
        }
        return "some product info, currentUser is: " + currenUser;
    }
}
