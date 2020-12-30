package com.shenyf.shenyfwork.controller;

import com.shenyf.shenyfwork.entity.vo.AjaxResultVO;
import com.shenyf.shenyfwork.entity.vo.TsysUserVO;
import com.shenyf.shenyfwork.model.TsysUser;
import com.shenyf.shenyfwork.service.ITSysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description:
 * @Author: shenyf
 * @Date: 2020/9/27 17:08
 */
@Controller
@RequestMapping(value = "/user")
public class TSysUserController {

    @Autowired
    private ITSysUserService tsysUserService;

    @ResponseBody
    @PostMapping("/login")
    public AjaxResultVO login(@RequestBody TsysUser tsysUser){
        TsysUserVO user = tsysUserService.login(tsysUser);
        if(user != null){
            return AjaxResultVO.markSuccess("登录成功",user);
        }
        return AjaxResultVO.markError("登录失败");
    }
}
