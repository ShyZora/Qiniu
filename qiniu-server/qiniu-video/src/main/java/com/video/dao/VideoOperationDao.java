package com.video.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.video.model.po.VideoOperation;
import org.apache.ibatis.annotations.Mapper;

/**
 * (VideoOperation)表数据库访问层
 *
 * @author makejava
 * @since 2023-11-06 14:37:15
 */
@Mapper
public interface VideoOperationDao extends BaseMapper<VideoOperation> {

}

