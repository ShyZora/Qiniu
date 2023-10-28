package com.video.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.common.model.ResponseResult;
import com.video.dao.VideoDao;
import com.video.model.po.Video;
import com.video.service.VideoService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (Video)表服务实现类
 *
 * @author makejava
 * @since 2023-10-25 01:45:32
 */
@Service("videoService")
public class VideoServiceImpl extends ServiceImpl<VideoDao, Video> implements VideoService {

    @Override
    public ResponseResult feed() {
        QueryWrapper<Video> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().orderByAsc(Video::getPublishTime);
        queryWrapper.last("limit 10");
        List<Video> list = list(queryWrapper);
        System.out.println("dsaasdsasda");
        return ResponseResult.okResult(list);
    }

    @Override
    public ResponseResult categoryVideo(Long categoryId) {
        LambdaQueryWrapper<Video> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Video::getCategoryId,categoryId);
        queryWrapper.orderByDesc(Video::getPublishTime);
        List<Video> list = list(queryWrapper);
        System.out.println("查询分类视频");
        return ResponseResult.okResult(list);
    }

    @Override
    public ResponseResult userVideo(Long userId) {
        LambdaQueryWrapper<Video> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Video::getUserId,userId);
        queryWrapper.orderByDesc(Video::getPublishTime);
        List<Video> list = list(queryWrapper);
        System.out.println("查询用户视频");
        return ResponseResult.okResult(list);
    }
}

