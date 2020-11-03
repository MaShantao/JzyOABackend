package com.marico.ncovreportsystem.mapper;

import com.marico.ncovreportsystem.pojo.TbDoctor;
import com.marico.ncovreportsystem.pojo.TbDoctorExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

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