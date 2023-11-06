package com.video.model.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * (Favourite)表实体类
 *
 * @author makejava
 * @since 2023-11-03 16:14:51
 */
@SuppressWarnings("serial")
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("favourite")
public class Favourite extends Model<Favourite> {
    @TableId(value="id",type = IdType.AUTO )
    private Long id;
    
    private Long userId;
    
    private Long videoId;

    private String title;

    private String videoUrl;

    private String coverUrl;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.id;
    }
    }

