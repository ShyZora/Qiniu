package com.category.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.category.dao.CategoryMapper;
import com.category.dao.VideoMapper;
import com.category.pojo.Category;
import com.category.pojo.Video;
import com.category.service.CategoryService;
import com.common.model.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private VideoMapper videoMapper;

    @Override
    public ResponseResult getCategoryHomeList() {
        LambdaQueryWrapper<Category> wrapper = new LambdaQueryWrapper<>();
        List<Category> arrayList;
        try {
            wrapper.select(Category::getCategoryName, Category::getId);
            arrayList = categoryMapper.selectList(wrapper);
        } catch (Exception e) {
            return new ResponseResult(HttpStatus.FORBIDDEN.value(), "获取失败");
        }
        return new ResponseResult(HttpStatus.OK.value(), "获取成功", arrayList);
    }

    @Transactional
    @Override
    public ResponseResult getCategoryTagList(Integer id) {
        QueryWrapper wrapper = new QueryWrapper<>();
        wrapper.eq("category_id",id);
        List<Video> categoryList = videoMapper.selectList(wrapper);
        if(Objects.isNull(categoryList)){
            return new ResponseResult(HttpStatus.FORBIDDEN.value(), "获取失败，请检查传入的ID值是否正确");
        }
        return new ResponseResult(HttpStatus.OK.value(), "获取成功", categoryList);
    }
}
