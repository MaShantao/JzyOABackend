package com.jzyoa.service;

import java.util.List;

import com.jzyoa.entity.PageResult;
import com.jzyoa.entity.Result;
import com.jzyoa.pojo.TbRole;

public interface RoleService {

	PageResult list(TbRole role, Integer pageNum, Integer pageSize);

	Result save(TbRole addRole);
	
	TbRole getById(Integer roleId);

	Result update(TbRole role);

	Result delete(Integer roleId);

	List<TbRole> listAll(TbRole searchRole);
}
