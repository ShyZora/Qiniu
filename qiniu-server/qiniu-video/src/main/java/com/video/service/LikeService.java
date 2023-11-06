package com.video.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.common.model.ResponseResult;
import com.video.model.po.Like;

public interface LikeService extends IService<Like> {
    ResponseResult unlikeVideo(Long id);

    ResponseResult getLikeVideo(Long id);

    ResponseResult likeVideo(Like like);
}
