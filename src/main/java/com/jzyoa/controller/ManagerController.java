package com.jzyoa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jzyoa.entity.PageResult;
import com.jzyoa.entity.Result;
import com.jzyoa.pojo.TbManager;
import com.jzyoa.service.ManagerService;

@RestController
@RequestMapping("/manager")
public class ManagerController {
	
	@Autowired
	private ManagerService managerService;
	
	@RequestMapping("/save")
    public Result save(@RequestBody TbManager addManager){
        return managerService.save(addManager);
    }
    
    @RequestMapping("/list")
    public PageResult list(@RequestBody TbManager searchManager, Integer pageNum, Integer pageSize){
    	return managerService.list(searchManager,pageNum,pageSize);
    }
    
    @RequestMapping("/listAll")
    public List<TbManager> listAll(@RequestBody TbManager searchManager){
    	return managerService.listAll(searchManager);
    }
    
    @RequestMapping("/getById")
    public TbManager getById(Integer hosId){
        return managerService.getById(hosId);
    }
    
    @RequestMapping("/update")
    public Result update(@RequestBody TbManager updateManager){
        return managerService.update(updateManager);
    }
    
    @RequestMapping("/delete")
    public Result delete(Integer hosId){
        return managerService.delete(hosId);
    }
	
}
