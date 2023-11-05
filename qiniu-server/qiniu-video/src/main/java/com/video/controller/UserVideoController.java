package com.video.controller;

import com.common.model.ResponseResult;
import com.video.model.po.Video;
import com.video.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class UserVideoController {
    @Autowired
    private VideoService videoService;
    // 点赞 // 收藏 // 转发更新 （视频）
    // 点赞
    @PostMapping("user/videoLike")
    public ResponseResult VideoUpdateLikeInfo(Long id, Long likeNum) {
        return videoService.videoUpdateLikeInfo(id, likeNum);
    }
    // 分享
    @PostMapping("user/videoFavourite")
    public ResponseResult VideoUpdateFavouriteInfo(Long id, Long favouriteNum) {
        return videoService.videoUpdateFavouriteInfo(id, favouriteNum);
    }
    // 收藏
    @PostMapping("user/videoShare")
    public ResponseResult VideoUpdateShareInfo(Long id, Long shareNum) {
        return videoService.videoUpdateShareInfo(id, shareNum);
    }
}
