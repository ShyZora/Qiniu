package com.security.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @RequestMapping("/hell")
//    @PreAuthorize("hasAuthority('action::visited.test')")
    String home() {
        return "Hello, spring video";
    }
}