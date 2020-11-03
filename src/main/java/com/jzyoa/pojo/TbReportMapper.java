package com.jzyoa.pojo;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.jzyoa.pojo.TbReport;
import com.jzyoa.pojo.TbReportExample;

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
}