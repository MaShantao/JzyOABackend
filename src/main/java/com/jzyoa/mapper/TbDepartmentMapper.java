package com.jzyoa.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.jzyoa.pojo.TbDepartment;
import com.jzyoa.pojo.TbDepartmentExample;

public interface TbDepartmentMapper {
    int countByExample(TbDepartmentExample example);

    int deleteByExample(TbDepartmentExample example);

    int deleteByPrimaryKey(Integer deptId);

    int insert(TbDepartment record);

    int insertSelective(TbDepartment record);

    List<TbDepartment> selectByExample(TbDepartmentExample example);

    TbDepartment selectByPrimaryKey(Integer deptId);

    int updateByExampleSelective(@Param("record") TbDepartment record, @Param("example") TbDepartmentExample example);

    int updateByExample(@Param("record") TbDepartment record, @Param("example") TbDepartmentExample example);

    int updateByPrimaryKeySelective(TbDepartment record);

    int updateByPrimaryKey(TbDepartment record);
}