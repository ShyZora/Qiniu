package com.security.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.security.pojo.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface MenuMapper extends BaseMapper<Menu> {
    List<String> selectMenuKeyById(Long id);
}
