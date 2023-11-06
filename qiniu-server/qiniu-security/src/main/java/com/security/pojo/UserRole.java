package com.security.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.github.jeffreyning.mybatisplus.anno.MppMultiId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "user_role")
public class UserRole {
    @MppMultiId
    @TableField("user_id")
    private Long userId;
    @MppMultiId
    @TableField("role_id")
    private Long roleId;
}
