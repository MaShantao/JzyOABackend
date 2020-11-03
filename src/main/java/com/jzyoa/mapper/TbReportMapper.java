package com.jzyoa.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.jzyoa.pojo.TbReport;
import com.jzyoa.pojo.TbReportExample;
import com.jzyoa.pojo.TbSpecimen;
import com.jzyoa.pojo.TbSpecimenExample;

public interface TbReportMapper {
    int countByExample(TbReportExample example);

    int deleteByExample(TbReportExample example);

    int deleteByPrimaryKey(Integer reportId);

    int insert(TbReport record);

    int insertSelective(TbReport record);

    List<TbReport> selectByExample(TbReportExample example);

    TbReport selectByPrimaryKey(Integer reportId);

    int updateByExampleSelective(@Param("record") TbReport record, @Param("example") TbReportExample example);

    int updateByExample(@Param("record") TbReport record, @Param("example") TbReportExample example);

    int updateByPrimaryKeySelective(TbReport record);

    int updateByPrimaryKey(TbReport record);

	List<TbReport> selectByExampleWithAllMessage(TbSpecimenExample example);
}