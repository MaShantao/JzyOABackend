package com.jzyoa.service;

import java.util.List;

import com.jzyoa.entity.Result;
import com.jzyoa.pojo.TbRoleRight;

public interface RoleRightService {

	List<TbRoleRight> listAllByRoleId(Integer roleId);
	
	boolean deleteByRoleId(Integer roleId);
	
	Result batchSave(Integer roleId, List<Integer> rightList);

	int delete(Integer roleId, Integer rightId);

}
