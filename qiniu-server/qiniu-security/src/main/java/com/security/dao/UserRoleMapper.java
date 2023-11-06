package com.security.dao;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.security.pojo.UserRole;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserRoleMapper extends BaseMapper<UserRole> {
}
