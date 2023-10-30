package com.security.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "Menu")
public class Menu implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId
    private Long id;
    private String menuName;
    private String menuKey;
}
