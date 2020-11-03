package com.marico.ncovreportsystem.service;

import java.util.List;

import com.marico.ncovreportsystem.entity.PageResult;
import com.marico.ncovreportsystem.entity.Result;
import com.marico.ncovreportsystem.pojo.TbHospital;

public interface HospitalService {

    PageResult list(TbHospital searchHospital, Integer pageNum, Integer pageSize);
    TbHospital getById(Integer hosId);
	Result update(TbHospital updateHospital);
	Result save(TbHospital addHospital);
	Result delete(Integer hosId);
	List<TbHospital> listAll(TbHospital searchHospital);
	TbHospital getByName(String hosName);
	
}
