package com.video.model.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.util.Date;

/**
 * (Video)表实体类
 *
 * @author makejava
 * @since 2023-10-25 01:45:31
 */
@SuppressWarnings("serial")
@TableName("video")
public class Video extends Model<Video> {
    @TableId(value="id",type = IdType.AUTO )
    private Long id;

    private Long userId;

    private String videoUrl;
    private String coverUrl;
    private Date publishTime;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public String getCoverUrl() {
        return coverUrl;
    }
}

