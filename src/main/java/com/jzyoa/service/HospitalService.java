package com.jzyoa.service;

import java.util.List;

import com.jzyoa.entity.PageResult;
import com.jzyoa.entity.Result;
import com.jzyoa.pojo.TbHospital;

public interface HospitalService {

	PageResult list(TbHospital searchHospital, Integer pageNum, Integer pageSize);

	TbHospital getById(Integer hosId);

	Result update(TbHospital updateHospital);

	Result save(TbHospital addHospital);

	Result delete(Integer hosId);

	List<TbHospital> listAll(TbHospital searchHospital);

	TbHospital getByName(String hosName);

}
