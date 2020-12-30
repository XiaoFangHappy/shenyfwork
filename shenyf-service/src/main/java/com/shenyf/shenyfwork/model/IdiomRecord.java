package com.shenyf.shenyfwork.model;

import java.util.Date;

public class IdiomRecord {
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

    public Long getIdiomId() {
        return idiomId;
    }

    public void setIdiomId(Long idiomId) {
        this.idiomId = idiomId;
    }

    public String getIdiomName() {
        return idiomName;
    }

    public void setIdiomName(String idiomName) {
        this.idiomName = idiomName == null ? null : idiomName.trim();
    }

    public String getIdiomPronounce() {
        return idiomPronounce;
    }

    public void setIdiomPronounce(String idiomPronounce) {
        this.idiomPronounce = idiomPronounce == null ? null : idiomPronounce.trim();
    }

    public String getIdiomContent() {
        return idiomContent;
    }

    public void setIdiomContent(String idiomContent) {
        this.idiomContent = idiomContent == null ? null : idiomContent.trim();
    }

    public String getIdiomComefrom() {
        return idiomComefrom;
    }

    public void setIdiomComefrom(String idiomComefrom) {
        this.idiomComefrom = idiomComefrom == null ? null : idiomComefrom.trim();
    }

    public String getIdiomAntonym() {
        return idiomAntonym;
    }

    public void setIdiomAntonym(String idiomAntonym) {
        this.idiomAntonym = idiomAntonym == null ? null : idiomAntonym.trim();
    }

    public String getIdiomThesaurus() {
        return idiomThesaurus;
    }

    public void setIdiomThesaurus(String idiomThesaurus) {
        this.idiomThesaurus = idiomThesaurus == null ? null : idiomThesaurus.trim();
    }

    public String getIdiomExample() {
        return idiomExample;
    }

    public void setIdiomExample(String idiomExample) {
        this.idiomExample = idiomExample == null ? null : idiomExample.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getValue1() {
        return value1;
    }

    public void setValue1(String value1) {
        this.value1 = value1 == null ? null : value1.trim();
    }

    public String getValue2() {
        return value2;
    }

    public void setValue2(String value2) {
        this.value2 = value2 == null ? null : value2.trim();
    }
}