package com.security.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.security.pojo.Menu;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface MenuMapper extends BaseMapper<Menu> {
    List<String> selectMenuKeyById(Long id);
}
