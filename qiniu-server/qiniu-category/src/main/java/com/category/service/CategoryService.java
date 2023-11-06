package com.category.service;

import com.common.model.ResponseResult;

public interface CategoryService {
    public ResponseResult getCategoryHomeList();

    public ResponseResult getCategoryTagList(Integer id);
}
