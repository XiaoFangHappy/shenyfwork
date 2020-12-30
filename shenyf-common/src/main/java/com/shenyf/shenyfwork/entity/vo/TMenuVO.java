package com.shenyf.shenyfwork.entity.vo;

import lombok.Data;

import java.util.Date;

/**
 * @Description:
 * @Author: shenyf
 * @Date: 2020/11/18 15:43
 */
@Data
public class TMenuVO {
    private Long menuId;

    private String menuName;

    private String menuUrl;

    private Integer menuType;

    private Integer menuStatus;

    private Date createTime;

    private Date updateTime;

    private Integer pMenuId;

    private String creater;

    private String updater;

    private String value1;

    private String value2;
}
