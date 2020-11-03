package com.marico.ncovreportsystem.service;

import java.util.List;

import com.marico.ncovreportsystem.entity.PageResult;
import com.marico.ncovreportsystem.entity.Result;
import com.marico.ncovreportsystem.pojo.TbRole;

public interface RoleService {

	PageResult list(TbRole role, Integer pageNum, Integer pageSize);

	Result save(TbRole addRole);
	
	TbRole getById(Integer roleId);

	Result update(TbRole role);

	Result delete(Integer roleId);

	List<TbRole> listAll(TbRole searchRole);
}
