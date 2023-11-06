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
    private String coverUrl;
    private Date publishTime;

    private String title;
    private Long shareNum;
    private Long categoryId;
    private Long goodNum;
    private Long favouriteNum;

    private Long userId;
    private Long id;

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public Long getShareNum() {
        return shareNum;
    }

    public void setShareNum(Long shareNum) {
        this.shareNum = shareNum;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getGoodNum() {
        return goodNum;
    }

    public void setGoodNum(Long goodNum) {
        this.goodNum = goodNum;
    }

    public Long getFavouriteNum() {
        return favouriteNum;
    }

    public void setFavouriteNum(Long favouriteNum) {
        this.favouriteNum = favouriteNum;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
