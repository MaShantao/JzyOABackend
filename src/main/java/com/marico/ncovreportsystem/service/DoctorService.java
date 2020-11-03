package com.marico.ncovreportsystem.service;

import java.util.List;

import com.marico.ncovreportsystem.entity.PageResult;
import com.marico.ncovreportsystem.entity.Result;
import com.marico.ncovreportsystem.pojo.TbDoctor;

public interface DoctorService {
	 	PageResult list(TbDoctor searchDoctor, Integer pageNum, Integer pageSize);
	    TbDoctor getById(Integer docId);
		Result update(TbDoctor updateDoctor);
		Result save(TbDoctor addDoctor);
		Result delete(Integer docId);
		List<TbDoctor> listAll(TbDoctor searchDoctor);
		TbDoctor getBySearchEntity(TbDoctor searchDoctor);
}
