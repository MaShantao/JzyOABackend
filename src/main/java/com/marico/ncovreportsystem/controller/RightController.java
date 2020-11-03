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
@RequestMapping("/right")
public class RightController {
	
	@Autowired
	private RightService rightService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleRightService roleRightService;

	@RequestMapping("/listAll")
	public List<TbRight> listAll() {
		TbRight searchRight = new TbRight();
		searchRight.setParentId(0);
		searchRight.setLevel(1);
		// 查找所有的一级权限
		List<TbRight> level1RightList =  rightService.listAll(searchRight);
		List<TbRight> level2RightList = null;
		if(level1RightList.size()==0) return null;
		for (TbRight level1Right : level1RightList) {
			// 查找所有的二级权限
			searchRight.setParentId(level1Right.getRightId());
			searchRight.setLevel(2);
			level2RightList = rightService.listAll(searchRight);
			level1Right.setChildren(level2RightList);
			for (TbRight level2Right : level2RightList) {
				// 查找所有的三级权限
				searchRight.setParentId(level2Right.getRightId());
				searchRight.setLevel(3);
				level2Right.setChildren(rightService.listAll(searchRight));
			}
		}
		System.out.println(level1RightList);
		return level1RightList;
	}

	
	@RequestMapping("/listByLoginName")
	public Map<String,Map<String,Map<String,Boolean>>> listByLoginName(String loginName) {
		TbUser user = userService.getByLoginName(loginName);
		List<TbRoleRight> listAllByRoleId = roleRightService.listAllByRoleId(user.getRoleId());
		
		Map<String,Map<String,Map<String,Boolean>>> resultMap = new HashMap<String, Map<String,Map<String,Boolean>>>();
		
		// 查找所有的三级权限
		List<TbRoleRight> roleRightList = roleRightService.listAllByRoleId(user.getRoleId());
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
		
		for (TbRight level1RoleRight : level1RightMap.values()) {
			Map<String,Map<String,Boolean>> level2RoleRightMap = new HashMap<String, Map<String,Boolean>>();
			for(TbRight level2RoleRight : level1RoleRight.getChildren()) {
				Map<String,Boolean> level3RoleRightMap =  new HashMap<String, Boolean>();
				for(TbRight level3RoleRight : level2RoleRight.getChildren()) {
					level3RoleRightMap.put(level3RoleRight.getPath(), true);
				}
				level2RoleRightMap.put(level2RoleRight.getPath(), level3RoleRightMap);
			}
			resultMap.put(level1RoleRight.getPath(), level2RoleRightMap);
		}
		
		return resultMap;
	}
//	
	@RequestMapping("/getById")
	public TbRight getById(Integer rightId) {
		return rightService.getById(rightId);
	}
//	
//	@RequestMapping("/update")
//    public Result update(@RequestBody TbRole role){
//        return roleService.update(role);
//    }
//	
//	@RequestMapping("/delete")
//    public Result delete(Integer roleId){
//        return roleService.delete(roleId);
//    }
	
}
