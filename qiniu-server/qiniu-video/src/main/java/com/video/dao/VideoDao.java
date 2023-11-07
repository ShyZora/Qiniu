package com.video.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.video.model.po.Video;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * (Video)表数据库访问层
 *
 * @author makejava
 * @since 2023-10-25 01:45:30
 */
@Mapper
public interface VideoDao extends BaseMapper<Video> {

}

