package com.jzyoa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jzyoa.entity.PageResult;
import com.jzyoa.entity.Result;
import com.jzyoa.mapper.TbRoleMapper;
import com.jzyoa.pojo.TbRole;
import com.jzyoa.pojo.TbRoleExample;
import com.jzyoa.pojo.TbRoleExample.Criteria;
import com.jzyoa.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	TbRoleMapper roleMapper;

	@Override
	public PageResult list(TbRole role, Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		TbRoleExample roleExample = new TbRoleExample();
		Criteria createCriteria = roleExample.createCriteria();
		if (role != null) {
			if (role.getRoleName() != null && !"".equals(role.getRoleName())) {
				createCriteria.andRoleNameLike("%" + role.getRoleName() + "%");
			}
			if (role.getRoleStatus() != null && !role.getRoleStatus().equals(0)) {
				createCriteria.andRoleStatusEqualTo(role.getRoleStatus());
			}
		}
		Page<TbRole> pages = (Page<TbRole>) roleMapper.selectByExample(roleExample);
		return new PageResult(pages.getTotal(), pages.getResult());
	}

	@Override
	public Result save(TbRole addRole) {
		return roleMapper.insert(addRole) > 0 ? new Result(true, "角色保存成功") : new Result(false, "角色保存失败");
	}

	@Override
	public TbRole getById(Integer roleId) {
		return roleMapper.selectByPrimaryKey(roleId);
	}

	@Override
	public Result update(TbRole role) {
		return roleMapper.updateByPrimaryKey(role) > 0 ? new Result(true, "更新角色成功") : new Result(false, "更新角色失败");
	}

	@Override
	public Result delete(Integer roleId) {
		TbRole role = roleMapper.selectByPrimaryKey(roleId);
		role.setRoleStatus(2);
		return roleMapper.updateByPrimaryKey(role) > 0 ? new Result(true, "删除角色成功") : new Result(false, "删除角色失败");
	}

	@Override
	public List<TbRole> listAll(TbRole searchRole) {
		TbRoleExample roleExample = new TbRoleExample();
		Criteria createCriteria = roleExample.createCriteria();
		if (searchRole != null) {
			if (searchRole.getRoleName() != null && !"".equals(searchRole.getRoleName())) {
				createCriteria.andRoleNameLike("%" + searchRole.getRoleName() + "%");
			}
			if (searchRole.getRoleStatus() != null && !searchRole.getRoleStatus().equals(0)) {
				createCriteria.andRoleStatusEqualTo(searchRole.getRoleStatus());
			}
		}
		return roleMapper.selectByExample(roleExample);
	}

}
