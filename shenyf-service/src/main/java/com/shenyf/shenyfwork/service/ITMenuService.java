package com.shenyf.shenyfwork.service;

import com.shenyf.shenyfwork.entity.vo.TMenuVO;

import java.util.List;

/**
 * @Description:
 * @Author: shenyf
 * @Date: 2020/11/18 15:41
 */
public interface ITMenuService {
    List<TMenuVO> getMenuByUser(String userId);
}
