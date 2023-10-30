package com.security.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @RequestMapping("/hell")
    @PreAuthorize("hasAnyAuthority('test')")
    String home() {
        return "Hello, spring security";
    }
}