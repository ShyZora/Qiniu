package com.video.controller;

import com.common.model.ResponseResult;
import com.qiniu.common.QiniuException;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import com.video.model.dto.PublishVideoDto;
import com.video.model.po.Video;
import com.video.service.IQiniuService;
import com.video.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

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
        System.out.println("请求视频");
        return  videoService.feed();
    }
    @GetMapping("sda")
    public void testUpload() throws QiniuException {
        String result = qiniuService.uploadFile(new File("C:\\Users\\world\\Pictures\\1688129525236.jpg"), "video\\688129525236.jpg");
        System.out.println("访问地址： " + result);
    }
    @GetMapping("add")
    public void addVideo(){
        String url = "http://s32tuvjv2.hn-bkt.clouddn.com/video/";
        String[] strList={"救助小松鼠.mp4","人间真实.mp4","好响就是好头。舍友的响头，祝大家晚安.mp4","学校水龙头.mp4"};
        List<Video> list = new LinkedList<>();
        for (String i:strList){
            Video video= new Video();
            video.setUserId(1L);
            video.setVideoUrl(url+i);
            System.out.println(url+i);
            video.setCoverUrl(url+i);
            video.setPublishTime(new Date());
            video.setTitle(i.substring(0,i.length()-4));
            video.setGoodNum(1L);
            video.setShareNum(1L);
            video.setCategoryId(1L);
            video.setFavouriteNum(1L);
            list.add(video);
        }
        //videoService.saveBatch(list);
    }
    @GetMapping("upload")
    public ResponseResult uploadToken(){
        return qiniuService.token();
    }
    @PostMapping("publish")
    public ResponseResult publishVideo(@RequestBody PublishVideoDto publishVideoDto){
        return qiniuService.publish(publishVideoDto);
    }
}
