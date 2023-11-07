package com.video.service.impl;

import com.common.model.ResponseResult;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
import com.video.model.dto.PublishVideoDto;
import com.video.model.dto.UploadTokenDto;
import com.video.model.po.Video;
import com.video.service.IQiniuService;
import com.video.service.VideoService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.Date;

@Service
public class QiniuServiceImpl implements IQiniuService, InitializingBean {

    @Autowired
    private VideoService videoService;
    @Autowired
    private UploadManager uploadManager;

    @Autowired
    private BucketManager bucketManager;

    @Autowired
    private Auth auth;

    @Value("${qiniu.bucket}")
    private String bucket;
    @Value("${qiniu.baseUrl}")
    private String baseUrl;
    @Value("${qiniu.domain}")
    private String domain;

    /**
     * 定义七牛云上传的相关策略
     */
    private StringMap putPolicy;

    @Override
    public String uploadFile(File file, String fileName) throws QiniuException {
        Response response = this.uploadManager.put(file, fileName, getUploadToken());
        int retry = 0;
        while (response.needRetry() && retry < 3) {
            response = this.uploadManager.put(file, fileName, getUploadToken());
            retry++;
        }
        if (response.statusCode == 200) {
            return "http://" + domain + "/" + fileName;
        }
        return "上传失败!";
    }

    @Override
    public String uploadFile(InputStream inputStream, String fileName) throws QiniuException {
        Response response = this.uploadManager.put(inputStream, fileName, getUploadToken(), null, null);
        int retry = 0;
        while (response.needRetry() && retry < 3) {
            response = this.uploadManager.put(inputStream, fileName, getUploadToken(), null, null);
            retry++;
        }
        if (response.statusCode == 200) {
            return "http://" + domain + "/" + fileName;
        }
        return "上传失败!";
    }


    @Override
    public Integer delete(String key) throws QiniuException {
        Response response = bucketManager.delete(this.bucket, key);
        int retry = 0;
        while (response.needRetry() && retry++ < 3) {
            response = bucketManager.delete(bucket, key);
        }
        return response.statusCode;
    }

    @Override
    public ResponseResult token() {
        String upToken = auth.uploadToken(bucket);
        UploadTokenDto uploadTokenDto = new UploadTokenDto(upToken,baseUrl);
        return ResponseResult.okResult(uploadTokenDto);
    }

    @Override
    public ResponseResult publish(PublishVideoDto publishVideoDto) {
        Video video = new Video();
        video.setTitle(publishVideoDto.getTitle());
        video.setUserId(publishVideoDto.getUserId());
        video.setCategoryId(publishVideoDto.getCategoryId());
        video.setVideoUrl(publishVideoDto.getVideoUrl());
        video.setUpdateTime(LocalDateTime.now());
        video.setLikeNum(0L);
        video.setCreateTime(LocalDateTime.now());
        video.setFavouriteNum(0L);
        video.setShareNum(0L);
        video.setCoverUrl("null");
        videoService.save(video);
        return ResponseResult.okResult();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        this.putPolicy = new StringMap();
        putPolicy.put("returnBody", "{\"key\":\"$(key)\",\"hash\":\"$(etag)\",\"bucket\":\"$(bucket)\",\"width\":$(imageInfo.width), \"height\":${imageInfo.height}}");
    }

    /**
     * 获取上传凭证
     */
    private String getUploadToken() {
        return this.auth.uploadToken(bucket, null, 3600, putPolicy);
    }

}
