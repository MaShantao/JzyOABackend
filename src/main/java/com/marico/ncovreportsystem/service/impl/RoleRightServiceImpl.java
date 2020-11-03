package com.marico.ncovreportsystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marico.ncovreportsystem.entity.Result;
import com.marico.ncovreportsystem.mapper.TbRoleRightMapper;
import com.marico.ncovreportsystem.pojo.TbRoleRight;
import com.marico.ncovreportsystem.pojo.TbRoleRightExample;
import com.marico.ncovreportsystem.pojo.TbRoleRightExample.Criteria;
import com.marico.ncovreportsystem.service.RoleRightService;


@Service
public class RoleRightServiceImpl implements RoleRightService {

	
	@Autowired
	TbRoleRightMapper roleRightMapper;
	
	@Override
	public List<TbRoleRight> listAllByRoleId(Integer roleId) {
		TbRoleRightExample roleRightExample = new TbRoleRightExample();
		Criteria createCriteria = roleRightExample.createCriteria();
		if(roleId!=null&&!roleId.equals(0)) {
			createCriteria.andRoleIdEqualTo(roleId);
		}
		return roleRightMapper.selectByExample(roleRightExample);
	}
	
	
	@Override
	public Result batchSave(Integer roleId, List<Integer> rightList) {
		if(roleId==null||rightList==null||rightList.size()==0) return new Result(false, "角色权限保存失败，数据格式出错");
		// 先删除所有指定roleId的角色权限记录
		deleteByRoleId(roleId);
		// 在批量保存
		for (Integer rightId : rightList) {
			roleRightMapper.insert(new TbRoleRight(null, roleId, rightId));
		}
		return new Result(true, "角色权限保存成功");
	}


	@Override
	public boolean deleteByRoleId(Integer roleId) {
		TbRoleRightExample roleRightExample = new TbRoleRightExample();
		Criteria createCriteria = roleRightExample.createCriteria();
		if(roleId!=null&&!roleId.equals(0)) {
			createCriteria.andRoleIdEqualTo(roleId);
		}
		return roleRightMapper.deleteByExample(roleRightExample)>0?true:false;
	}


	@Override
	public int delete(Integer roleId, Integer rightId) {
		TbRoleRightExample roleRightExample = new TbRoleRightExample();
		Criteria createCriteria = roleRightExample.createCriteria();
		if(roleId!=null&&rightId!=null) {
			createCriteria.andRoleIdEqualTo(roleId);
			createCriteria.andRightIdEqualTo(rightId);
		}
		return roleRightMapper.deleteByExample(roleRightExample);
	}

}
