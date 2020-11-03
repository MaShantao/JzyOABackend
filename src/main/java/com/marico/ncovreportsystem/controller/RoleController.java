package com.marico.ncovreportsystem.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jhlabs.image.LightFilter.Material;
import com.marico.ncovreportsystem.entity.PageResult;
import com.marico.ncovreportsystem.entity.Result;
import com.marico.ncovreportsystem.pojo.TbDictionary;
import com.marico.ncovreportsystem.pojo.TbHospital;
import com.marico.ncovreportsystem.pojo.TbRight;
import com.marico.ncovreportsystem.pojo.TbRole;
import com.marico.ncovreportsystem.pojo.TbRoleRight;
import com.marico.ncovreportsystem.pojo.TbUser;
import com.marico.ncovreportsystem.service.DictionaryService;
import com.marico.ncovreportsystem.service.RightService;
import com.marico.ncovreportsystem.service.RoleRightService;
import com.marico.ncovreportsystem.service.RoleService;
import com.marico.ncovreportsystem.service.UserService;

@RestController
@RequestMapping("/role")
public class RoleController {

	@Autowired
	private RoleService roleService;

	@Autowired
	private RightService rightService;

	@Autowired
	private RoleRightService roleRightService;

	@RequestMapping("/list")
	public PageResult list(@RequestBody TbRole searchRole, Integer pageNum, Integer pageSize) {
		PageResult pageResult = roleService.list(searchRole, pageNum, pageSize);
		List<TbRole> roleList = pageResult.getRows();

		for (TbRole role : roleList) {
			// 查找所有的三级权限
			List<TbRoleRight> roleRightList = roleRightService.listAllByRoleId(role.getRoleId());
			// 查找所有的二级权限
			Map<Integer, TbRight> level2RightMap = new HashMap<Integer, TbRight>();
			for (TbRoleRight roleRight : roleRightList) {
				TbRight level3Right = rightService.getById(roleRight.getRightId());
				if (!level2RightMap.containsKey(level3Right.getParentId())) {
					TbRight level2Right = rightService.getById(level3Right.getParentId());
					level2Right.setChildren(new ArrayList<TbRight>());
					level2RightMap.put(level3Right.getParentId(), level2Right);
				}
				level2RightMap.get(level3Right.getParentId()).getChildren().add(level3Right);
			}
			// 查找所有的一级权限
			Map<Integer, TbRight> level1RightMap = new HashMap<Integer, TbRight>();
			for (Map.Entry<Integer, TbRight> entry : level2RightMap.entrySet()) {
				TbRight level2Right = entry.getValue();
				if (!level1RightMap.containsKey(level2Right.getParentId())) {
					TbRight level1Right = rightService.getById(level2Right.getParentId());
					level1Right.setChildren(new ArrayList<TbRight>());
					level1RightMap.put(level2Right.getParentId(), level1Right);
				}
				level1RightMap.get(level2Right.getParentId()).getChildren().add(level2Right);
			}
			role.setRightList(new ArrayList<TbRight>());
			for (TbRight right : level1RightMap.values()) {
				role.getRightList().add(right);
			}
			System.out.println(role.getRightList());
		}
		return pageResult;
	}

	@RequestMapping("/save")
	public Result save(@RequestBody TbRole addRole) {
		addRole.setRoleStatus(1);
		return roleService.save(addRole);
	}
	
	@RequestMapping("/listAll")
	public List<TbRole> listAll(@RequestBody TbRole addRole) {
		return roleService.listAll(addRole);
	}
	
	@RequestMapping("/getById")
	public TbRole getById(Integer roleId) {
		return roleService.getById(roleId);
	}
	
	@RequestMapping("/update")
    public Result update(@RequestBody TbRole role){
        return roleService.update(role);
    }
	
	@RequestMapping("/delete")
    public Result delete(Integer roleId){
        return roleService.delete(roleId);
    }
	
}
