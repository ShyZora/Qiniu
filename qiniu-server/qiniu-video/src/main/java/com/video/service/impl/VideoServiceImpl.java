package com.video.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.common.model.ResponseResult;
import com.qiniu.common.QiniuException;
import com.video.config.CurrentUser;
import com.video.dao.VideoDao;
import com.video.model.po.Video;
import com.video.model.po.VideoOperation;
import com.video.service.IQiniuService;
import com.video.service.VideoOperationService;
import com.video.service.VideoService;
import io.jsonwebtoken.lang.Collections;
import org.apache.mahout.cf.taste.common.TasteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisServer;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Vector;

/**
 * (Video)表服务实现类
 *
 * @author makejava
 * @since 2023-10-25 01:45:32
 */
@Service("videoService")
public class VideoServiceImpl extends ServiceImpl<VideoDao, Video> implements VideoService {

    @Autowired
    IQiniuService qiniuService;
    @Autowired
    VideoDao videoDao;

    @Autowired
    VideoOperationService videoOperationService;

    Vector<Video>videos = new Vector<>();

    @Override
    public ResponseResult feed() throws TasteException {
        QueryWrapper<Video> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().orderByAsc(Video::getUpdateTime);
        List<Long> recommend = videoOperationService.recommend(CurrentUser.getUserId().intValue());
        videoDao.selectBatchIds(recommend).forEach( entity -> videos.add(entity));
        while(videos.size()<10){
            list(queryWrapper).forEach(entity -> videos.add(entity));
        }
        List<Video> result = new ArrayList<>();
        for(int i = 0;i<10;i++){
            result.add(videos.remove(0));
        }
        return ResponseResult.okResult(result);
    }

    @Override
    public ResponseResult categoryVideo(Long categoryId) {
        LambdaQueryWrapper<Video> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Video::getCategoryId, categoryId);
        queryWrapper.orderByDesc(Video::getUpdateTime);
        List<Video> list = list(queryWrapper);
        System.out.println("查询分类视频");
        return ResponseResult.okResult(list);
    }

    @Override
    public ResponseResult userVideo(Long userId) {
        LambdaQueryWrapper<Video> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Video::getUserId, userId);
        queryWrapper.orderByDesc(Video::getUpdateTime);
        List<Video> list = list(queryWrapper);
        System.out.println("查询用户视频");
        return ResponseResult.okResult(list);
    }

    @Override
    public ResponseResult deleteVideo(Long videoId) {
        Video video = getById(videoId);
        Integer code = 0;
        removeById(videoId);
        try {
            code = qiniuService.delete(video.getVideoUrl());
        } catch (QiniuException e) {
            throw new RuntimeException(e);
        }
        if (code == 500) {
            return ResponseResult.okResult();
        }
        return ResponseResult.errorResult(503, "删除视频失败");
    }

    @Override
    public ResponseResult videoUpdateLikeInfo(Long id,Long likeNum) {
        UpdateWrapper<Video> videoWrapper = new UpdateWrapper<>();
        VideoOperation videoOperation = new VideoOperation();
        videoOperation.setVideoId(id);
        videoOperation.setUserId(CurrentUser.getUserId());
        videoOperation.setOperationId(0);
        try {
            videoOperationService.save(videoOperation);
            videoWrapper.eq("id",id)
                    .set("like_num",likeNum);
            update(videoWrapper);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseResult(HttpStatus.FORBIDDEN.value(), "更新失败,请重试");
        }
        return new ResponseResult(HttpStatus.OK.value(), "更新成功");
    }
    @Override
    public ResponseResult videoUpdateFavouriteInfo(Long id, Long favouriteNum) {
        LambdaUpdateWrapper<Video> wrapper = new LambdaUpdateWrapper<>();
        VideoOperation videoOperation = new VideoOperation();
        videoOperation.setVideoId(id);
        videoOperation.setUserId(CurrentUser.getUserId());
        videoOperation.setOperationId(1);
        try {
            videoOperationService.save(videoOperation);
            wrapper.eq(Video::getId,id)
                    .set(Video::getFavouriteNum,favouriteNum);
            update(wrapper);
        } catch (Exception e) {
            return new ResponseResult(HttpStatus.FORBIDDEN.value(), "更新失败,请重试");
        }
        return new ResponseResult(HttpStatus.OK.value(), "更新成功");
    }
    @Override
    public ResponseResult videoUpdateShareInfo(Long id, Long shareNum) {
        LambdaUpdateWrapper<Video> wrapper = new LambdaUpdateWrapper<>();
        VideoOperation videoOperation = new VideoOperation();
        videoOperation.setVideoId(id);
        videoOperation.setUserId(CurrentUser.getUserId());
        videoOperation.setOperationId(2);
        try {
            videoOperationService.save(videoOperation);
            wrapper.eq(Video::getId,id)
                    .set(Video::getShareNum,shareNum);
            update(wrapper);
        } catch (Exception e) {
            return new ResponseResult(HttpStatus.FORBIDDEN.value(), "更新失败,请重试");
        }
        return new ResponseResult(HttpStatus.OK.value(), "更新成功");
    }
}

