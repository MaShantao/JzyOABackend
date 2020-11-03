package com.jzyoa.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.jzyoa.pojo.TbDictionary;
import com.jzyoa.pojo.TbDictionaryExample;

public interface TbDictionaryMapper {
    int countByExample(TbDictionaryExample example);

    int deleteByExample(TbDictionaryExample example);

    int deleteByPrimaryKey(Integer dictId);

    int insert(TbDictionary record);

    int insertSelective(TbDictionary record);

    List<TbDictionary> selectByExample(TbDictionaryExample example);

    TbDictionary selectByPrimaryKey(Integer dictId);

    int updateByExampleSelective(@Param("record") TbDictionary record, @Param("example") TbDictionaryExample example);

    int updateByExample(@Param("record") TbDictionary record, @Param("example") TbDictionaryExample example);

    int updateByPrimaryKeySelective(TbDictionary record);

    int updateByPrimaryKey(TbDictionary record);
}