package com.jzyoa.controller;

import com.github.pagehelper.Page;
import java.util.List;

import com.github.pagehelper.PageHelper;
import com.jzyoa.entity.PageResult;
import com.jzyoa.entity.Result;
import com.jzyoa.pojo.TbDepartment;
import com.jzyoa.pojo.TbDepartmentExample;
import com.jzyoa.service.DepartmentService;
import com.jzyoa.service.HospitalService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private HospitalService hospitalService;
    @Autowired
    private DoctorController doctorController;
    

    @RequestMapping("/save")
    public Result save(@RequestBody TbDepartment addDepartment){
        return departmentService.save(addDepartment);
    }
    
    @RequestMapping("/list")
    public PageResult list(@RequestBody TbDepartment searchDepartment, Integer pageNum, Integer pageSize){
    	PageResult pageResult = departmentService.list(searchDepartment,pageNum,pageSize);
    	List<TbDepartment> departmentList = pageResult.getRows();	
    	for (TbDepartment department : departmentList) {
    		department.setHospital(hospitalService.getById(department.getHosId()));
		}
    	return pageResult;
    }
    
    @RequestMapping("/listAll")
    public List<TbDepartment> listAll(@RequestBody TbDepartment searchDepartment){
    	return departmentService.listAll(searchDepartment);
    }
    
    @RequestMapping("/getById")
    public TbDepartment getById(Integer deptId){
    	TbDepartment department = departmentService.getById(deptId);
    	department.setHospital(hospitalService.getById(department.getHosId()));
        return department;
    }
    
    @RequestMapping("/update")
    public Result update(@RequestBody TbDepartment searchDepartment){
        return departmentService.update(searchDepartment);
    }
    
    @RequestMapping("/delete")
    public Result delete(Integer deptId){
        return departmentService.delete(deptId);
    }
    
    @RequestMapping("/listByHosId")
	public List<TbDepartment> listByHosId(Integer hosId) {
    	 List<TbDepartment> departmentList = departmentService.listByHosId(hosId);
    	 for (TbDepartment department : departmentList) {
    		 department.setDoctorList(doctorController.listAllByDeptId(department.getDeptId()));
		}
    	return departmentList;
	}
}
