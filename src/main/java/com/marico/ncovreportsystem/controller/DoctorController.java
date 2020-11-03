package com.marico.ncovreportsystem.controller;

import com.github.pagehelper.Page;

import com.github.pagehelper.PageHelper;
import com.marico.ncovreportsystem.entity.PageResult;
import com.marico.ncovreportsystem.entity.Result;
import com.marico.ncovreportsystem.pojo.TbDepartment;
import com.marico.ncovreportsystem.pojo.TbDoctor;
import com.marico.ncovreportsystem.pojo.TbDoctor;
import com.marico.ncovreportsystem.pojo.TbDoctorExample;
import com.marico.ncovreportsystem.service.DoctorService;
import com.marico.ncovreportsystem.service.HospitalService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;
    
    @Autowired
    private DepartmentController departmentController;
    
    @Autowired
    private HospitalService hospitalService;
    
    @RequestMapping("/save")
    public Result save(@RequestBody TbDoctor addDoctor){
        return doctorService.save(addDoctor);
    }
    
    @RequestMapping("/list")
    public PageResult list(@RequestBody TbDoctor searchDoctor, Integer pageNum, Integer pageSize){
    	PageResult pageResult = doctorService.list(searchDoctor,pageNum,pageSize);
    	List<TbDoctor> doctorList = pageResult.getRows();
    	for (TbDoctor doctor : doctorList) {
			doctor.setDepartment(departmentController.getById(doctor.getDeptId()));
		}
    	return pageResult;
    }
    @RequestMapping("/listAll")
    public List<TbDoctor> listAll(@RequestBody TbDoctor searchDoctor){
    	return doctorService.listAll(searchDoctor);
    }
    
    @RequestMapping("/listbyhosId")
    public PageResult listbyhosId(@RequestBody TbDoctor searchDoctor, Integer pageNum, Integer pageSize,Integer docId){
    	// 1.查询指定医院的所有科室
    	TbDepartment searchDepartment = searchDoctor.getDepartment();
    	searchDepartment.setHosId(docId);
    	List<TbDepartment> departmentList = departmentController.list(searchDepartment,0, 0).getRows();
    	// 2.查询所有科室的所有医生
    	List<TbDoctor> doctorList = new ArrayList<TbDoctor>();
    	for(TbDepartment department:departmentList) {
    		searchDoctor.setDeptId(department.getDeptId());
    		TbDoctor doctor = (TbDoctor) list(searchDoctor, 0, 1).getRows().get(0);
    		doctorList.add(doctor);
    	}
    	
    	return new PageResult(doctorList.size(),doctorList);
    }
    
    @RequestMapping("/getById")
    public TbDoctor getById(Integer docId){
    	TbDoctor doctor = doctorService.getById(docId);
    	doctor.setDepartment(departmentController.getById(doctor.getDeptId()));
        return doctor;
    }
    
    @RequestMapping("/update")
    public Result update(@RequestBody TbDoctor searchDoctor){
        return doctorService.update(searchDoctor);
    }
    
    @RequestMapping("/delete")
    public Result delete(Integer docId){
        return doctorService.delete(docId);
    }

	public List<TbDoctor> listAllByDeptId(Integer deptId) {
		TbDoctor searchDoctor = new TbDoctor();
		searchDoctor.setDeptId(deptId);
		return listAll(searchDoctor);
	}
}
