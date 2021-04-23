package com.shenyf.shenyfwork.model;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class TsysUser {
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
