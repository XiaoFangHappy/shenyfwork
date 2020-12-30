package com.shenyf.shenyfwork.service.impl;

import com.shenyf.shenyfwork.dao.IdiomRecordMapper;
import com.shenyf.shenyfwork.entity.vo.IdiomRecordVO;
import com.shenyf.shenyfwork.model.IdiomRecord;
import com.shenyf.shenyfwork.model.IdiomRecordExample;
import com.shenyf.shenyfwork.service.ITIdiomService;
import com.shenyf.shenyfwork.utils.BeanCopierUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author: shenyf
 * @Date: 2020/9/29 14:41
 */
@Service
public class TIdiomServiceImpl implements ITIdiomService {

    @Autowired
    private IdiomRecordMapper idiomRecordMapper;

    @Override
    public int saveIdiom(IdiomRecord idiomRecord) {
        return idiomRecordMapper.insertSelective(idiomRecord);
    }

    @Override
    public IdiomRecordVO getIdiomByName(String idiomName) {
        IdiomRecordExample example = new IdiomRecordExample();
        IdiomRecordExample.Criteria cr = example.createCriteria();
        cr.andIdiomNameEqualTo(idiomName);
        List<IdiomRecord> idiom = idiomRecordMapper.selectByExample(example);
        if(idiom != null && !idiom.isEmpty()){
            return BeanCopierUtils.convert(idiom.get(0),IdiomRecordVO.class);
        }
        return null;
    }

    @Override
    public IdiomRecordVO getIdiomBykeyword(String keyword) {
        IdiomRecordExample example = new IdiomRecordExample();
        IdiomRecordExample.Criteria cr = example.createCriteria();
        cr.andIdiomNameLike(keyword +"%");
        List<IdiomRecord> idiom = idiomRecordMapper.selectByExample(example);
        if(idiom != null && !idiom.isEmpty()){
            return BeanCopierUtils.convert(idiom.get(0),IdiomRecordVO.class);
        }
        return null;
    }
}
