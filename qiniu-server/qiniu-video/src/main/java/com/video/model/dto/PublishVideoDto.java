package com.video.model.dto;

import java.util.Date;

/**
 * @program: Qiniu
 * @description: 发布视频
 * @author: ShyZOra
 * @create: 2023-10-26 15:27
 **/

public class PublishVideoDto {
    private String videoUrl;

    private String title;
    private Integer categoryId;
    private Long userId;

    public PublishVideoDto(String videoUrl, String title, Integer categoryId, Long userId) {
        this.videoUrl = videoUrl;
        this.title = title;
        this.categoryId = categoryId;
        this.userId = userId;
    }

    public PublishVideoDto() {
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }






    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}