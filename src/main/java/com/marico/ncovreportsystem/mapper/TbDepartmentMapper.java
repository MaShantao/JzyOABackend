package com.marico.ncovreportsystem.mapper;

import com.marico.ncovreportsystem.pojo.TbDepartment;
import com.marico.ncovreportsystem.pojo.TbDepartmentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

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