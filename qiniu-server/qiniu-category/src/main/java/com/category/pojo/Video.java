package com.category.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "video")
public class Video {
    private static final long serialVersionUID = 1L;
    @TableId
    private Long id;
    private Long userId;
    private String title;
    private Integer categoryId;
    private String videoUrl;
    private String coverUrl;
    private Integer likeNum;
    private Integer favouriteNum;
    private Integer shareNum;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
