package com.category.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.category.pojo.Category;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CategoryMapper extends BaseMapper<Category> {
}
