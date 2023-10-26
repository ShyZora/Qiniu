package com.video.model.dto;

/**
 * @program: Qiniu
 * @description: 发布视频
 * @author: ShyZOra
 * @create: 2023-10-26 15:27
 **/

public class PublishVideoDto {
    Long userId;
    String title;
    String url;

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
