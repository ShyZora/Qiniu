package com.video.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.common.model.ResponseResult;
import com.video.model.po.Video;

/**
 * (Video)表服务接口
 *
 * @author makejava
 * @since 2023-10-25 01:45:32
 */
public interface VideoService extends IService<Video> {
    ResponseResult feed();
}

