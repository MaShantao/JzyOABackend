package com.jzyoa.service;

import java.util.List;

import com.jzyoa.entity.PageResult;
import com.jzyoa.entity.Result;
import com.jzyoa.pojo.TbDoctor;

public interface DoctorService {
	PageResult list(TbDoctor searchDoctor, Integer pageNum, Integer pageSize);

	TbDoctor getById(Integer docId);

	Result update(TbDoctor updateDoctor);

	Result save(TbDoctor addDoctor);

	Result delete(Integer docId);

	List<TbDoctor> listAll(TbDoctor searchDoctor);

	TbDoctor getBySearchEntity(TbDoctor searchDoctor);
}
