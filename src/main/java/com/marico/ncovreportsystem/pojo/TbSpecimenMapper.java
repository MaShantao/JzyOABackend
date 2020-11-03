package com.marico.ncovreportsystem.pojo;

import com.marico.ncovreportsystem.pojo.TbSpecimen;
import com.marico.ncovreportsystem.pojo.TbSpecimenExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbSpecimenMapper {
    int countByExample(TbSpecimenExample example);

    int deleteByExample(TbSpecimenExample example);

    int deleteByPrimaryKey(Integer specimenId);

    int insert(TbSpecimen record);

    int insertSelective(TbSpecimen record);

    List<TbSpecimen> selectByExample(TbSpecimenExample example);

    TbSpecimen selectByPrimaryKey(Integer specimenId);

    int updateByExampleSelective(@Param("record") TbSpecimen record, @Param("example") TbSpecimenExample example);

    int updateByExample(@Param("record") TbSpecimen record, @Param("example") TbSpecimenExample example);

    int updateByPrimaryKeySelective(TbSpecimen record);

    int updateByPrimaryKey(TbSpecimen record);
}