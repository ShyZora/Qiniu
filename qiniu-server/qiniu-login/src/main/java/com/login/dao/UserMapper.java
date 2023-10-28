package com.login.dao;

import com.login.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author Wcilzo
 * @since 2023-10-28
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
