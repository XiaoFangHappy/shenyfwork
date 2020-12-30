package com.shenyf.shenyfwork.service.impl;

import com.shenyf.shenyfwork.dao.TsysUserMapper;
import com.shenyf.shenyfwork.entity.vo.TsysUserVO;
import com.shenyf.shenyfwork.model.TsysUser;
import com.shenyf.shenyfwork.model.TsysUserExample;
import com.shenyf.shenyfwork.service.ITSysUserService;
import com.shenyf.shenyfwork.utils.BeanCopierUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author: shenyf
 * @Date: 2020/9/27 17:19
 */
@Service
@Slf4j
public class TSysUserServiceImpl implements ITSysUserService {
    @Autowired
    private TsysUserMapper tsysUserMapper;

    @Override
    public TsysUserVO login(TsysUser tsysUser) {
        TsysUserExample example = new TsysUserExample();
        TsysUserExample.Criteria cr = example.createCriteria();
        cr.andUserLoginNameEqualTo(tsysUser.getUserLoginName());
        cr.andLoginPwdEqualTo(tsysUser.getLoginPwd());
        List<TsysUserVO> list = BeanCopierUtils.convertList(tsysUserMapper.selectByExample(example), TsysUserVO.class);
        if(list != null && list.size() == 1){
            if(StringUtils.equals(list.get(0).getUserStatus(),"1")){
                return list.get(0);
            }
        }
        return null;
    }

    @Override
    public TsysUserVO getUserById(String Id) {
        if(StringUtils.isNotBlank(Id) && StringUtils.isNumeric(Id)){
            TsysUser user = tsysUserMapper.selectByPrimaryKey(Long.valueOf(Id));
            if(user != null && StringUtils.equals(user.getUserStatus(),"1")){
                return BeanCopierUtils.convert(user,TsysUserVO.class);
            }
        }
        return null;
    }
}
