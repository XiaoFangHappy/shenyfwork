package com.shenyf.shenyfwork.dao;

import com.shenyf.shenyfwork.model.IdiomRecord;
import com.shenyf.shenyfwork.model.IdiomRecordExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface IdiomRecordMapper {
    int countByExample(IdiomRecordExample example);

    int deleteByExample(IdiomRecordExample example);

    int deleteByPrimaryKey(Long idiomId);

    int insert(IdiomRecord record);

    int insertSelective(IdiomRecord record);

    List<IdiomRecord> selectByExample(IdiomRecordExample example);

    IdiomRecord selectByPrimaryKey(Long idiomId);

    int updateByExampleSelective(@Param("record") IdiomRecord record, @Param("example") IdiomRecordExample example);

    int updateByExample(@Param("record") IdiomRecord record, @Param("example") IdiomRecordExample example);

    int updateByPrimaryKeySelective(IdiomRecord record);

    int updateByPrimaryKey(IdiomRecord record);

    List<IdiomRecord> selectByRound();
}
