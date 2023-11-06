package com.video.service;

import com.common.model.ResponseResult;
import com.qiniu.common.QiniuException;
import com.video.model.dto.PublishVideoDto;

import java.io.File;
import java.io.InputStream;

public interface IQiniuService {

    /**
     * 以文件的形式上传
     *
     * @param file
     * @param fileName:
     * @return: java.lang.String
     */
    String uploadFile(File file, String fileName) throws QiniuException;

    /**
     * 以流的形式上传
     *
     * @param inputStream
     * @param fileName:
     * @return: java.lang.String
     */
    String uploadFile(InputStream inputStream, String fileName) throws QiniuException;

    /**
     * 删除文件
     *
     * @param key:
     * @return: java.lang.String
     */
    Integer delete(String key) throws QiniuException;

    ResponseResult token();

    ResponseResult publish(PublishVideoDto publishVideoDto);
}
