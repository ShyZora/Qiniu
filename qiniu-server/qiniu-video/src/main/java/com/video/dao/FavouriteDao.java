package com.video.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.video.model.po.Favourite;
import org.apache.ibatis.annotations.Mapper;

/**
 * (Favourite)表数据库访问层
 *
 * @author makejava
 * @since 2023-11-03 16:14:51
 */
@Mapper
public interface FavouriteDao extends BaseMapper<Favourite> {

}

