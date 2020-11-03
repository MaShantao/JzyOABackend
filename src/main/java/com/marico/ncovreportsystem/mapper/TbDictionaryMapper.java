package com.marico.ncovreportsystem.mapper;

import com.marico.ncovreportsystem.pojo.TbDictionary;
import com.marico.ncovreportsystem.pojo.TbDictionaryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

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