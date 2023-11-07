package com.video.controller;

import com.common.model.ResponseResult;
import com.video.model.dto.IdDto;
import com.video.model.po.Favourite;
import com.video.model.po.Like;
import com.video.model.po.Video;
import com.video.service.FavouriteService;
import com.video.service.LikeService;
import com.video.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserVideoController {
    @Autowired
    private VideoService videoService;

    @Autowired
    private FavouriteService favouriteService;

    @Autowired
    private LikeService likeService;
    // 点赞 // 收藏 // 转发更新 （视频）
    // 点赞
    // 点赞数目更新
    @PostMapping("user/videoLikeNum")
    public ResponseResult VideoUpdateLikeInfo(Long id, Long likeNum) {
        return videoService.videoUpdateLikeInfo(id, likeNum);
    }
    // 点赞数目获取
    @GetMapping("user/getVideoLikeNum")
    public ResponseResult getVideoLikeNum(Long id){
        return videoService.getVideoLikeNum(id);
    }
    // 取消点赞
    @PostMapping("user/unlike")
    public ResponseResult unlikeVideo(@RequestBody IdDto idDto){
        return likeService.unlikeVideo(idDto.getId());
    }
    // 获得点赞列表
    @GetMapping("user/likeList")
    public ResponseResult getLikeVideo(Long id){
        return likeService.getLikeVideo(id);
    }
    // 点赞视频
    @PostMapping("user/like")
    public ResponseResult likeVideo(@RequestBody Like like){
        return likeService.likeVideo(like);
    }

    // 收藏
    // 收藏数目更新
    @PostMapping("user/favouriteNum")
    public ResponseResult VideoUpdateFavouriteInfo(Long id, Long favouriteNum) {
        return videoService.videoUpdateFavouriteInfo(id, favouriteNum);
    }
    // 收藏数目获取
    @GetMapping("user/getFavouriteNum")
    public ResponseResult getFavouriteVideoNum(Long id){
        return videoService.getFavouriteVideoNum(id);
    }
    // 取消收藏
    @PostMapping("user/unfavourite")
    public ResponseResult unFavouriteVideo(@RequestBody IdDto idDto){
        return favouriteService.unFavouriteVideo(idDto.getId());
    }
    // 获得收藏列表
    @GetMapping("user/favourite")
    public ResponseResult getFavouriteVideo(Long id){
        return favouriteService.getFavouriteVideo(id);
    }
    // 收藏视频
    @PostMapping("user/favourite")
    public ResponseResult favouriteVideo(@RequestBody Favourite favourite){
        return favouriteService.favouriteVideo(favourite);
    }

    // 分享
    // 数目更新
    @PostMapping("user/videoShare")
    public ResponseResult VideoUpdateShareInfo(Long id, Long shareNum) {
        return videoService.videoUpdateShareInfo(id, shareNum);
    }
    // 获得分享数
    @GetMapping("user/getShareNum")
    public ResponseResult getShareVideoNum(Long id){
        return videoService.getShareVideoNum(id);
    }
}
