package com.sdjz.cqbms.entity.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class SysUser implements Serializable {
    /**
    * id
    */
    private String id;

    /**
    * 用户名
    */
    private String username;

    /**
    * 密码
    */
    private String password;

    private Integer deleteFlag;

    private Date createTime;

    private Date updateTime;

    private String token;

    private static final long serialVersionUID = 1L;
}