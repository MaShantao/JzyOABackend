package com.marico.ncovreportsystem.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jhlabs.image.LightFilter.Material;
import com.marico.ncovreportsystem.entity.Result;
import com.marico.ncovreportsystem.mapper.TbDictionaryMapper;
import com.marico.ncovreportsystem.pojo.TbDictionary;
import com.marico.ncovreportsystem.service.DictionaryService;

@RestController
@RequestMapping("/dictionary")
public class DictionaryController {
	
	@Autowired
	private DictionaryService dictionaryService;
	
	
	
	
	@RequestMapping("/list")
	public List<TbDictionary> list(@RequestBody TbDictionary dictionary){
		return dictionaryService.list(dictionary);
	}
	
	@RequestMapping("/update")
	public Result update(@RequestBody TbDictionary dictionary){
		 try {
			dictionaryService.update(dictionary);
			return new Result(true, "更新成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new Result(false, "更新失败");
		}
	}
	
	
	
}
