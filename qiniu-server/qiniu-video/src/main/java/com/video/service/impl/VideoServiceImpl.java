package com.video.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.common.model.ResponseResult;
import com.video.dao.VideoDao;
import com.video.model.po.Video;
import com.video.service.VideoService;
import org.springframework.stereotype.Service;

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
//        Video video = new Video();
//        video.setVideoUrl("dasdas");
//        video.setCoverUrl("dsad");
//        video.setPublishTime(new Date());
//        video.setUserId(1L);
//        save(video);
//        int i = list().size();
//        System.out.println(i);
        return ResponseResult.okResult();
    }
}

