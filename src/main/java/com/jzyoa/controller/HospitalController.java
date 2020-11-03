package com.jzyoa.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jzyoa.entity.PageResult;
import com.jzyoa.entity.Result;
import com.jzyoa.pojo.TbHospital;
import com.jzyoa.service.HospitalService;

@RestController
@RequestMapping("/hospital")
public class HospitalController {

    @Autowired
    private HospitalService hospitalService;
    
    @Autowired
    private DepartmentController departmentController;
    
    @RequestMapping("/save")
    public Result save(@RequestBody TbHospital addHospital){
        return hospitalService.save(addHospital);
    }
    
    @RequestMapping("/list")
    public PageResult list(@RequestBody TbHospital searchHospital, Integer pageNum, Integer pageSize){
    	PageResult pageResult =  hospitalService.list(searchHospital,pageNum,pageSize);
    	List<TbHospital> hospitalList = pageResult.getRows();
    	for (TbHospital hospital : hospitalList) {
    		hospital.setDepartmentList(departmentController.listByHosId(hospital.getHosId()));
		}
    	return pageResult;
    }
    
    
    @RequestMapping("/listAll")
    public List<TbHospital> listAll(@RequestBody TbHospital searchHospital){
    	return hospitalService.listAll(searchHospital);
    }
    
    @RequestMapping("/getById")
    public TbHospital getById(Integer hosId){
        return hospitalService.getById(hosId);
    }
    
    @RequestMapping("/update")
    public Result update(@RequestBody TbHospital updateHospital){
        return hospitalService.update(updateHospital);
    }
    
    @RequestMapping("/delete")
    public Result delete(Integer hosId){
        return hospitalService.delete(hosId);
    }
}
