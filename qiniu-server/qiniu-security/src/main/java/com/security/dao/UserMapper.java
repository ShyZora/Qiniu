package com.security.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.security.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author Wcilzo
 * @since 2023-10-28
 */
@Repository
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
