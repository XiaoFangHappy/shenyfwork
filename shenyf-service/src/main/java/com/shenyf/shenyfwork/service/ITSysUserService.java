package com.shenyf.shenyfwork.service;

import com.shenyf.shenyfwork.entity.vo.TsysUserVO;
import com.shenyf.shenyfwork.model.TsysUser;

/**
 * @Description:
 * @Author: shenyf
 * @Date: 2020/9/27 17:18
 */
public interface ITSysUserService {
    TsysUserVO login(TsysUser tsysUser);
    TsysUserVO getUserById(String Id);
}
