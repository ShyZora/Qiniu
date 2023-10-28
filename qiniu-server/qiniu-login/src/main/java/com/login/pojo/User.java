package com.login.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author Wcilzo
 * @since 2023-10-28
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 用户id **/
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /** 用户名 **/
    private String nickName;

    /** 密码 **/
    private String password;

}
