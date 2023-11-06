package com.video.model.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * (Video)表实体类
 *
 * @author makejava
 * @since 2023-10-25 01:45:31
 */
@SuppressWarnings("serial")
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("video")
public class Video extends Model<Video> {
    @TableId(value="id",type = IdType.AUTO )
    private Long id;
    private Long userId;
    private String title;
    private Integer categoryId;
    private String videoUrl;
    private String coverUrl;
    private Long likeNum;
    private Long favouriteNum;
    private Long shareNum;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

}

