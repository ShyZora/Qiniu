package com.category.controller;

import com.category.service.CategoryService;
import com.common.model.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/home/getCategoryHomeList")
    public ResponseResult getCategoryHomeList() {
        return categoryService.getCategoryHomeList();
    }

    @RequestMapping("/home/getCategoryTagList")
    public ResponseResult getCategoryTagList(Integer id) {
        return categoryService.getCategoryTagList(id);
    }
}
