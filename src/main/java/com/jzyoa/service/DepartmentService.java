package com.jzyoa.service;

import java.util.List;

import com.jzyoa.entity.PageResult;
import com.jzyoa.entity.Result;
import com.jzyoa.pojo.TbDepartment;
import com.jzyoa.pojo.TbReport;

public interface DepartmentService {

	Result save(TbDepartment addDepartment);

	PageResult list(TbDepartment searchDepartment, Integer pageNum, Integer pageSize);

	TbDepartment getById(Integer deptId);

	Result update(TbDepartment updateDepartment);

	Result delete(Integer deptId);

	List<TbDepartment> listAll(TbDepartment searchDepartment);

	List<TbDepartment> listByHosId(Integer hosId);
	
	TbDepartment getBySearchEntity(TbDepartment searchDepartment);
	
}
