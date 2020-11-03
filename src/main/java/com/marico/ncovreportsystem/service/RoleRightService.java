package com.marico.ncovreportsystem.service;

import java.util.List;

import com.marico.ncovreportsystem.entity.Result;
import com.marico.ncovreportsystem.pojo.TbRoleRight;

public interface RoleRightService {

	List<TbRoleRight> listAllByRoleId(Integer roleId);
	
	boolean deleteByRoleId(Integer roleId);
	
	Result batchSave(Integer roleId, List<Integer> rightList);

	int delete(Integer roleId, Integer rightId);

}
