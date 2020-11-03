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
import org.springframework.web.bind.annotation.RequestParam;
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
@RequestMapping("/roleright")
public class RoleRightController {

	@Autowired
	private RoleRightService roleRightService;

	@Autowired
	private RightService rightService;
	
//	@RequestMapping("/list")
//	public PageResult list(@RequestBody TbRole searchRole, Integer pageNum, Integer pageSize) {
//		PageResult pageResult = roleService.list(searchRole, pageNum, pageSize);
//		List<TbRole> roleList = pageResult.getRows();
//
//		for (TbRole role : roleList) {
//			// 查找所有的三级权限
//			List<TbRoleRight> roleRightList = roleRightService.listAllByRoleId(role.getRoleId());
//			// 查找所有的二级权限
//			Map<Integer, TbRight> level2RightMap = new HashMap<Integer, TbRight>();
//			for (TbRoleRight roleRight : roleRightList) {
//				TbRight level3Right = rightService.getById(roleRight.getRightId());
//				if (!level2RightMap.containsKey(level3Right.getParentId())) {
//					TbRight level2Right = rightService.getById(level3Right.getParentId());
//					level2Right.setChildren(new ArrayList<TbRight>());
//					level2RightMap.put(level3Right.getParentId(), level2Right);
//				}
//				level2RightMap.get(level3Right.getParentId()).getChildren().add(level3Right);
//			}
//			// 查找所有的一级权限
//			Map<Integer, TbRight> level1RightMap = new HashMap<Integer, TbRight>();
//			for (Map.Entry<Integer, TbRight> entry : level2RightMap.entrySet()) {
//				TbRight level2Right = entry.getValue();
//				if (!level1RightMap.containsKey(level2Right.getParentId())) {
//					TbRight level1Right = rightService.getById(level2Right.getParentId());
//					level1Right.setChildren(new ArrayList<TbRight>());
//					level1RightMap.put(level2Right.getParentId(), level1Right);
//				}
//				level1RightMap.get(level2Right.getParentId()).getChildren().add(level2Right);
//			}
//			role.setRightList(new ArrayList<TbRight>());
//			for (TbRight right : level1RightMap.values()) {
//				role.getRightList().add(right);
//			}
//			System.out.println(role.getRightList());
//		}
//		return pageResult;
//	}

	@RequestMapping("/batchSave")
	public Result batchSave(Integer roleId, String rightListString) {
		String[] split = rightListString.split(",");
		List<Integer> rightList = new ArrayList<Integer>();
		for (String string : split) {
			rightList.add(Integer.parseInt(string));
		}
		return roleRightService.batchSave(roleId,rightList);
	}
	
	
	
	@RequestMapping("/delete")
	public Result delete(@RequestBody TbRight deleteRight,Integer roleId) {
		int count = 0;
		///假设是第一权限
		if(deleteRight.getChildren()!=null) {
			for (TbRight level2Right : deleteRight.getChildren()) {
				if(level2Right.getChildren()!=null) {
					///遍历二级权限
					for (TbRight level3Right : level2Right.getChildren()) {
						///遍历三级权限
						count+= roleRightService.delete(roleId,level3Right.getRightId());
					}
				}
				if(level2Right.getLevel() == 3 )count+= roleRightService.delete(roleId,level2Right.getRightId());
			}
		}
		if(deleteRight.getLevel() == 3 ) count+= roleRightService.delete(roleId,deleteRight.getRightId());
		return new Result(true, "成功删除"+count+"条权限");
	}
	
	@RequestMapping("/getByRoleId")
	public List<TbRight> getByRoleId(Integer roleId) {
		// 查找所有的三级权限
		List<TbRoleRight> roleRightList = roleRightService.listAllByRoleId(roleId);
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
		List<TbRight> rightList = new ArrayList<TbRight>();
		for (TbRight right : level1RightMap.values()) {
			rightList.add(right);
		}
		return rightList;
	}
	
}
