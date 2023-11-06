package com.video.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.common.model.ResponseResult;
import com.video.config.CurrentUser;
import com.video.dao.LikeDao;
import com.video.dao.VideoDao;
import com.video.model.po.Favourite;
import com.video.model.po.Like;
import com.video.model.po.Video;
import com.video.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeServiceImpl extends ServiceImpl<LikeDao, Like> implements LikeService {

    @Autowired
    private LikeService likeService;

    @Autowired
    private LikeDao likeDao;

    @Override
    public ResponseResult unlikeVideo(Long id) {
        CurrentUser.getUserId();
        LambdaQueryWrapper<Like> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Like::getUserId,CurrentUser.getUserId());
        wrapper.eq(Like::getVideoId,id);
        likeService.remove(wrapper);
        return ResponseResult.okResult();
    }

    @Override
    public ResponseResult getLikeVideo(Long id) {
        LambdaQueryWrapper<Like> wrapper = new LambdaQueryWrapper<>();
        List<Like> likeList;
        try {
            wrapper.eq(Like::getUserId, id);
            likeList = likeDao.selectList(wrapper);
        } catch (Exception e) {
            return new ResponseResult(HttpStatus.FORBIDDEN.value(), "获取失败");
        }
        return new ResponseResult<>(HttpStatus.OK.value(), "获取点赞列表成功", likeList);
    }

    @Override
    public ResponseResult likeVideo(Like like) {
        save(like);
        return ResponseResult.okResult();
    }
}
