package com.jzyoa.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.jzyoa.pojo.TbRight;
import com.jzyoa.pojo.TbRightExample;

public interface TbRightMapper {
    int countByExample(TbRightExample example);

    int deleteByExample(TbRightExample example);

    int deleteByPrimaryKey(Integer rightId);

    int insert(TbRight record);

    int insertSelective(TbRight record);

    List<TbRight> selectByExample(TbRightExample example);

    TbRight selectByPrimaryKey(Integer rightId);

    int updateByExampleSelective(@Param("record") TbRight record, @Param("example") TbRightExample example);

    int updateByExample(@Param("record") TbRight record, @Param("example") TbRightExample example);

    int updateByPrimaryKeySelective(TbRight record);

    int updateByPrimaryKey(TbRight record);
}