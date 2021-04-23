package com.shenyf.shenyfwork.service.impl;

import com.alibaba.fastjson.JSON;
import com.shenyf.shenyfwork.constant.Constant;
import com.shenyf.shenyfwork.dao.TsysUserMapper;
import com.shenyf.shenyfwork.entity.vo.TsysUserVO;
import com.shenyf.shenyfwork.model.TsysUser;
import com.shenyf.shenyfwork.model.TsysUserExample;
import com.shenyf.shenyfwork.service.ITSysUserService;
import com.shenyf.shenyfwork.utils.BeanCopierUtils;
import com.shenyf.shenyfwork.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
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
    @Autowired
    private RedisUtil redisUtil;

    @Override
    public TsysUserVO login(TsysUser tsysUser) {
        String md5Str = DigestUtils.md5DigestAsHex(tsysUser.getLoginPwd().getBytes());
        TsysUserExample example = new TsysUserExample();
        TsysUserExample.Criteria cr = example.createCriteria();
        cr.andUserLoginNameEqualTo(tsysUser.getUserLoginName());
        cr.andLoginPwdEqualTo(md5Str);
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

    @Override
    public TsysUserVO getLoginUser(HttpServletRequest request) {
        String ip = getRemortIP(request);
        String token = readLoginToken(request);
        if (StringUtils.isNotBlank(token)) {
            System.out.println(redisUtil.get(ip + token));
            return JSON.parseObject((String) redisUtil.get(ip + token), TsysUserVO.class);
        }
        return null;
    }

    public String getRemortIP(HttpServletRequest request) {
        if (request.getHeader("x-forwarded-for") == null) {
            return request.getRemoteAddr();
        }
        return request.getHeader("x-forwarded-for");
    }
    public static String readLoginToken(HttpServletRequest request) {
        Cookie[] cks = request.getCookies();
        if (cks != null) {
            for (Cookie ck : cks) {
                log.info("read cookie name:{} , cookie value:{}", ck.getName(), ck.getValue());
                if (StringUtils.equals(ck.getName(), Constant.LOGIN_COOKIE_NAME)) {
                    return ck.getValue();
                }
            }
        }
        return null;
    }
}
