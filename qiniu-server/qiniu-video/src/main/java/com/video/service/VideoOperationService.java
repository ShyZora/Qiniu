package com.video.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.video.model.po.VideoOperation;
import org.apache.mahout.cf.taste.common.TasteException;
import java.util.List;


/**
 * (VideoOperation)表服务接口
 *
 * @author makejava
 * @since 2023-11-06 14:37:19
 */
public interface VideoOperationService extends IService<VideoOperation> {
    List<Long> recommend(Integer userId) throws TasteException;
}

