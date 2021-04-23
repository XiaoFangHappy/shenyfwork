package com.shenyf.shenyfwork.controller;

import com.alibaba.fastjson.JSON;
import com.shenyf.shenyfwork.constant.Constant;
import com.shenyf.shenyfwork.entity.vo.AjaxResultVO;
import com.shenyf.shenyfwork.entity.vo.TsysUserVO;
import com.shenyf.shenyfwork.model.TsysUser;
import com.shenyf.shenyfwork.service.ITSysUserService;
import com.shenyf.shenyfwork.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description:
 * @Author: shenyf
 * @Date: 2020/9/27 17:08
 */
@Controller
@RequestMapping(value = "/user")
@Slf4j
public class TSysUserController {

    @Autowired
    private ITSysUserService tsysUserService;

    @Autowired
    private RedisUtil redisUtil;
    ;

    @ResponseBody
    @PostMapping("/login")
    public AjaxResultVO login(TsysUser tsysUser, HttpServletRequest request, HttpServletResponse response) {
        TsysUserVO user = tsysUserService.login(tsysUser);
        if (user != null) {
            loginCookie(user, request, response);
            return AjaxResultVO.markSuccess("登录成功", user);
        }
        return AjaxResultVO.markError("登录失败");
    }

    private void loginCookie(TsysUserVO tsysUser, HttpServletRequest request, HttpServletResponse response) {
        String ip = getRemortIP(request);
        String token = DigestUtils.md5DigestAsHex(tsysUser.getUserLoginName().getBytes());
        writeLoginToken(response, token);
        redisUtil.set(ip + token, JSON.toJSONString(tsysUser));
    }

    public String getRemortIP(HttpServletRequest request) {
        if (request.getHeader("x-forwarded-for") == null) {
            return request.getRemoteAddr();
        }
        return request.getHeader("x-forwarded-for");
    }

    /**
     * 写入cookie 用于登入
     * @param response
     * @param token
     */
    private void writeLoginToken(HttpServletResponse response, String token) {
        Cookie ck = new Cookie(Constant.LOGIN_COOKIE_NAME, token);
        ck.setPath("/");
        ck.setHttpOnly(true);
        ck.setMaxAge(Constant.LOGIN_COOKIE_TIME); //保存时间
        log.info("write cookie name:{} , cookie vlaue: {}", ck.getName(), ck.getValue());
        response.addCookie(ck);
    }

    /**
     * 删除cookie 用于登出
     * @param response
     * @param request
     */
    private void delLoginToken(HttpServletResponse response,HttpServletRequest request){
        Cookie[] cks = request.getCookies();
        String ip = getRemortIP(request);
        if (cks != null){
            for (Cookie ck : cks){
                if (StringUtils.equals(ck.getName(),Constant.LOGIN_COOKIE_NAME)){
                    redisUtil.del(ip + ck.getValue());
                    ck.setPath("/");
                    ck.setMaxAge(0); //0 = del
                    log.info("del cookie name : {} ,cookie vlaue: {}",ck.getName(),ck.getValue());
                    response.addCookie(ck);
                    return;
                }
            }
        }
    }
}
