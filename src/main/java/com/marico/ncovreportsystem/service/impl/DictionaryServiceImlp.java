package com.marico.ncovreportsystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.marico.ncovreportsystem.entity.PageResult;
import com.marico.ncovreportsystem.mapper.TbDepartmentMapper;
import com.marico.ncovreportsystem.mapper.TbDictionaryMapper;
import com.marico.ncovreportsystem.pojo.TbDepartment;
import com.marico.ncovreportsystem.pojo.TbDepartmentExample;
import com.marico.ncovreportsystem.pojo.TbDictionary;
import com.marico.ncovreportsystem.pojo.TbDictionaryExample;
import com.marico.ncovreportsystem.service.DictionaryService;

@Service
public class DictionaryServiceImlp implements DictionaryService {

	@Autowired
	TbDictionaryMapper dictonaryMapper;
	
	@Override
	public List<TbDictionary> list(TbDictionary dictionary) {
        TbDictionaryExample dictonaryExample = new TbDictionaryExample();
        TbDictionaryExample.Criteria createCriteria = dictonaryExample.createCriteria();
        if(dictionary!=null) {
            if(dictionary.getDictName()!=null&&!dictionary.getDictName().equals("")) {
                createCriteria.andDictNameEqualTo(dictionary.getDictName());
            }
        }
        return dictonaryMapper.selectByExample(dictonaryExample);
	}

	@Override
	public void update(TbDictionary dictionary) {
		
	}

	@Override
	public TbDictionary getById(Integer dictId) {
		return dictonaryMapper.selectByPrimaryKey(dictId);
	}

	@Override
	public TbDictionary getBySearchEntity(TbDictionary searchEntity) {
		 TbDictionaryExample dictonaryExample = new TbDictionaryExample();
	        TbDictionaryExample.Criteria createCriteria = dictonaryExample.createCriteria();
	        if(searchEntity!=null) {
	        	if(searchEntity.getDictId()!=null) {
	        		createCriteria.andDictIdEqualTo(searchEntity.getDictId());
	        	}
	            if(searchEntity.getDictName()!=null) {
	                createCriteria.andDictNameEqualTo(searchEntity.getDictName());
	            }
	            if(searchEntity.getDictValue()!=null) {
	            	createCriteria.andDictValueEqualTo(searchEntity.getDictValue());
	            }
	            if(searchEntity.getDictMark()!=null) {
	            	createCriteria.andDictMarkEqualTo(searchEntity.getDictMark());
	            }
	        }
	        List<TbDictionary> dictionaryList = dictonaryMapper.selectByExample(dictonaryExample);
	        return dictionaryList!=null&&dictionaryList.size()>0?dictionaryList.get(0):null;
	}

	@Override
	public List<TbDictionary> listByDictName(String dictName) {
		TbDictionaryExample dictonaryExample = new TbDictionaryExample();
        TbDictionaryExample.Criteria createCriteria = dictonaryExample.createCriteria();
        createCriteria.andDictNameEqualTo(dictName);
		return dictonaryMapper.selectByExample(dictonaryExample);
	}

	@Override
	public List<TbDictionary> vagueListByDictName(String dictName) {
		TbDictionaryExample dictonaryExample = new TbDictionaryExample();
        TbDictionaryExample.Criteria createCriteria = dictonaryExample.createCriteria();
        createCriteria.andDictNameLike("%" + dictName + "%");
		return dictonaryMapper.selectByExample(dictonaryExample);
	}

}
