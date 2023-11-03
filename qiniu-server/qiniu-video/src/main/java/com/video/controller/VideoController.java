package com.video.controller;

import com.common.model.ResponseResult;
import com.qiniu.common.QiniuException;
import com.video.model.dto.PublishVideoDto;
import com.video.service.IQiniuService;
import com.video.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.File;

/**
 * @program: Qiniu
 * @description:
 * @author: ShyZOra
 * @create: 2023-10-25 02:34
 **/
@RestController
@RequestMapping("video")
public class VideoController {
    @Autowired
    private VideoService videoService;
    @Autowired
    private IQiniuService qiniuService;
    @GetMapping("feed")
    public ResponseResult Feed(){
        return  videoService.feed();
    }
    @GetMapping("sda")
    public void testUpload() throws QiniuException {
        String result = qiniuService.uploadFile(new File("C:\\Users\\world\\Pictures\\1688129525236.jpg"), "video\\688129525236.jpg");
        System.out.println("访问地址： " + result);
    }
    @GetMapping("upload")
    public ResponseResult uploadToken(){
        return qiniuService.token();
    }
    @PostMapping("publish")
    public ResponseResult publishVideo(@RequestBody PublishVideoDto publishVideoDto){
        return qiniuService.publish(publishVideoDto);
    }
    @GetMapping("category/feed")
    public ResponseResult categoryVideo(Long categoryId){
        return videoService.categoryVideo(categoryId);
    }

    @PostMapping("delete")
    public ResponseResult deleteVideo(Long videoId){
        return videoService.deleteVideo(videoId);
    }

    @GetMapping("user/feed")
    public ResponseResult userVideo(Long userId){
        System.out.println("用户视频controller");
        return videoService.userVideo(userId);
    }
}
