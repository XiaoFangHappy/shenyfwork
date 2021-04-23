package com.shenyf.shenyfwork.filter;

import com.shenyf.shenyfwork.entity.vo.TsysUserVO;
import com.shenyf.shenyfwork.service.ITSysUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ：shenyf
 * @date ：Created 2021/4/22 10:14
 * @description：登录filter
 */
@Slf4j
@Component
public class LoginFilter extends OncePerRequestFilter {

    @Autowired
    private ITSysUserService sysUserService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        StringBuffer fileURL = request.getRequestURL();
        if (StringUtils.isNotBlank(fileURL) && fileURL.indexOf("user/login") > 0) {
            chain.doFilter(request, response);
        } else {
            TsysUserVO loginUser = sysUserService.getLoginUser(request);
            if (loginUser != null) {
                chain.doFilter(request, response);
            }
        }
    }
}
