package com.shenyf.shenyfwork.service;

import com.shenyf.shenyfwork.entity.vo.IdiomRecordVO;
import com.shenyf.shenyfwork.model.IdiomRecord;

/**
 * @Description:
 * @Author: shenyf
 * @Date: 2020/9/29 14:40
 */
public interface ITIdiomService {
    int saveIdiom(IdiomRecord idiomRecord);
    IdiomRecordVO getIdiomByName(String idiomName);
    IdiomRecordVO getIdiomBykeyword(String keyword);
}
