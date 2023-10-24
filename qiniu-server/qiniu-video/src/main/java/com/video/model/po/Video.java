package com.video.model.po;

import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * (Video)表实体类
 *
 * @author makejava
 * @since 2023-10-25 01:45:31
 */
@SuppressWarnings("serial")

public class Video extends Model<Video> {

    private Long id;

    private String VideoUrl;
    private String CoverUrl;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setVideoUrl(String videoUrl) {
        VideoUrl = videoUrl;
    }

    public void setCoverUrl(String coverUrl) {
        CoverUrl = coverUrl;
    }

    public String getVideoUrl() {
        return VideoUrl;
    }

    public String getCoverUrl() {
        return CoverUrl;
    }
}

