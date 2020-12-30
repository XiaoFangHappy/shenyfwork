package com.shenyf.shenyfwork.entity.vo;

import lombok.Data;

import java.util.Date;

/**
 * @Description:
 * @Author: shenyf
 * @Date: 2020/9/29 14:45
 */
@Data
public class IdiomRecordVO {
    private Long idiomId;

    private String idiomName;

    private String idiomPronounce;

    private String idiomContent;

    private String idiomComefrom;

    private String idiomAntonym;

    private String idiomThesaurus;

    private String idiomExample;

    private Date createTime;

    private Date updateTime;

    private String status;

    private String value1;

    private String value2;

}
