package com.video.controller;

import com.common.model.ResponseResult;
import com.video.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @GetMapping("feed")
    public ResponseResult Feed(){
        return  videoService.feed();
    }
}
