package com.shenyf.shenyfwork.entity.vo;

import lombok.Data;

import java.util.Date;

/**
 * @Description:
 * @Author: shenyf
 * @Date: 2020/9/27 17:29
 */
@Data
public class TsysUserVO {
    private Long userId;

    private String userName;

    private String userLoginName;

    private String email;

    private String mobilePhone;

    private String userStatus;

    private String userType;

    private Long creater;

    private Date createTime;

    private Long updater;

    private Date updateTime;

    private String loginPwd;

    private Date changeTime;

    private String regionCode;
}
