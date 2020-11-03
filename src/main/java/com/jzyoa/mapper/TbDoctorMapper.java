package com.jzyoa.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.jzyoa.pojo.TbDoctor;
import com.jzyoa.pojo.TbDoctorExample;

public interface TbDoctorMapper {
    int countByExample(TbDoctorExample example);

    int deleteByExample(TbDoctorExample example);

    int deleteByPrimaryKey(Integer docId);

    int insert(TbDoctor record);

    int insertSelective(TbDoctor record);

    List<TbDoctor> selectByExample(TbDoctorExample example);

    TbDoctor selectByPrimaryKey(Integer docId);

    int updateByExampleSelective(@Param("record") TbDoctor record, @Param("example") TbDoctorExample example);

    int updateByExample(@Param("record") TbDoctor record, @Param("example") TbDoctorExample example);

    int updateByPrimaryKeySelective(TbDoctor record);

    int updateByPrimaryKey(TbDoctor record);
}