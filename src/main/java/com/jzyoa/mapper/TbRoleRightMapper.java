package com.jzyoa.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.jzyoa.pojo.TbRoleRight;
import com.jzyoa.pojo.TbRoleRightExample;

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