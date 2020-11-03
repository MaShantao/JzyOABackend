package com.marico.ncovreportsystem.mapper;

import com.marico.ncovreportsystem.pojo.TbRoleRight;
import com.marico.ncovreportsystem.pojo.TbRoleRightExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbRoleRightMapper {
    int countByExample(TbRoleRightExample example);

    int deleteByExample(TbRoleRightExample example);

    int deleteByPrimaryKey(Integer roleRightId);

    int insert(TbRoleRight record);

    int insertSelective(TbRoleRight record);

    List<TbRoleRight> selectByExample(TbRoleRightExample example);

    TbRoleRight selectByPrimaryKey(Integer roleRightId);

    int updateByExampleSelective(@Param("record") TbRoleRight record, @Param("example") TbRoleRightExample example);

    int updateByExample(@Param("record") TbRoleRight record, @Param("example") TbRoleRightExample example);

    int updateByPrimaryKeySelective(TbRoleRight record);

    int updateByPrimaryKey(TbRoleRight record);
}