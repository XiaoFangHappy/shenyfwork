package com.shenyf.shenyfwork.controller;

import com.shenyf.shenyfwork.entity.vo.AjaxResultVO;
import com.shenyf.shenyfwork.entity.vo.TMenuVO;
import com.shenyf.shenyfwork.entity.vo.TsysUserVO;
import com.shenyf.shenyfwork.service.ITMenuService;
import com.shenyf.shenyfwork.service.ITSysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Description: 首页
 * @Author: shenyf
 * @Date: 2020/11/18 15:21
 */
@Slf4j
@Controller
@RequestMapping(value = "/index")
public class IndexController {

    @Autowired
    private ITMenuService menuService;
    @Autowired
    private ITSysUserService sysUserService;


    @ResponseBody
    @PostMapping("/init")
    public AjaxResultVO init(HttpServletRequest request) {
        TsysUserVO sysUser = sysUserService.getLoginUser(request);
        if (sysUser != null) {
            TsysUserVO user = sysUserService.getUserById(sysUser.getUserId() + "");
            if (user != null) {
                //获取菜单
                List<TMenuVO> menuList = menuService.getMenuByUser(sysUser.getUserId() + "");
                return AjaxResultVO.markSuccess("查询成功", menuList);
            }
        }
        return AjaxResultVO.markError("请重新登录");
    }
}
