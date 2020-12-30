package com.shenyf.shenyfwork.dao;

import com.shenyf.shenyfwork.model.TMenuClick;
import com.shenyf.shenyfwork.model.TMenuClickExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TMenuClickMapper {
    int countByExample(TMenuClickExample example);

    int deleteByExample(TMenuClickExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TMenuClick record);

    int insertSelective(TMenuClick record);

    List<TMenuClick> selectByExample(TMenuClickExample example);

    TMenuClick selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TMenuClick record, @Param("example") TMenuClickExample example);

    int updateByExample(@Param("record") TMenuClick record, @Param("example") TMenuClickExample example);

    int updateByPrimaryKeySelective(TMenuClick record);

    int updateByPrimaryKey(TMenuClick record);
}