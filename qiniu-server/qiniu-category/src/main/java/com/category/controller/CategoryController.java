package com.category.controller;

import com.category.service.CategoryService;
import com.common.model.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/home/getCategoryHomeList")
    public ResponseResult getCategoryHomeList() {
        return categoryService.getCategoryHomeList();
    }

    @GetMapping("/home/getCategoryTagList")
    public ResponseResult getCategoryTagList(Integer id) {
        return categoryService.getCategoryTagList(id);
    }
}
