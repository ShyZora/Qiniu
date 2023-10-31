package com.security.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.security.pojo.User;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author Wcilzo
 * @since 2023-10-28
 */
@Component
public interface UserMapper extends BaseMapper<User> {
}
