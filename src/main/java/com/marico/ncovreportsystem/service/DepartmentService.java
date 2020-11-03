package com.marico.ncovreportsystem.service;

import java.util.List;

import com.marico.ncovreportsystem.entity.PageResult;
import com.marico.ncovreportsystem.entity.Result;
import com.marico.ncovreportsystem.pojo.TbDepartment;
import com.marico.ncovreportsystem.pojo.TbReport;

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
