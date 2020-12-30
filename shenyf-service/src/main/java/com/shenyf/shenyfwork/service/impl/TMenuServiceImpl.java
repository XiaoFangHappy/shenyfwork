package com.shenyf.shenyfwork.service.impl;

import com.shenyf.shenyfwork.dao.TMenuMapper;
import com.shenyf.shenyfwork.entity.vo.TMenuVO;
import com.shenyf.shenyfwork.model.TMenu;
import com.shenyf.shenyfwork.model.TMenuExample;
import com.shenyf.shenyfwork.service.ITMenuService;
import com.shenyf.shenyfwork.utils.BeanCopierUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author: shenyf
 * @Date: 2020/11/18 15:41
 */
@Service
public class TMenuServiceImpl implements ITMenuService {
    @Autowired
    private TMenuMapper tMenuMapper;

    @Override
    public List<TMenuVO> getMenuByUser(String userId) {
        TMenuExample example = new TMenuExample();
        TMenuExample.Criteria cr = example.createCriteria();
        cr.andMenuStatusEqualTo(1);
        List<TMenu> list = tMenuMapper.selectByExample(example);
        return BeanCopierUtils.convertList(list,TMenuVO.class);
    }
}
