package com.jzyoa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jzyoa.entity.PageResult;
import com.jzyoa.mapper.TbDepartmentMapper;
import com.jzyoa.mapper.TbDictionaryMapper;
import com.jzyoa.pojo.TbDepartment;
import com.jzyoa.pojo.TbDepartmentExample;
import com.jzyoa.pojo.TbDictionary;
import com.jzyoa.pojo.TbDictionaryExample;
import com.jzyoa.service.DictionaryService;

@Service
public class DictionaryServiceImlp implements DictionaryService {

	@Autowired
	TbDictionaryMapper dictonaryMapper;

	@Override
	public List<TbDictionary> list(TbDictionary dictionary) {
		TbDictionaryExample dictonaryExample = new TbDictionaryExample();
		TbDictionaryExample.Criteria createCriteria = dictonaryExample.createCriteria();
		if (dictionary != null) {
			if (dictionary.getDictName() != null && !dictionary.getDictName().equals("")) {
				createCriteria.andDictNameEqualTo(dictionary.getDictName());
			}
		}
		return dictonaryMapper.selectByExample(dictonaryExample);
	}

	@Override
	public void update(TbDictionary dictionary) {
		// 暂时用不到就没写
	}

	@Override
	public TbDictionary getById(Integer dictId) {
		return dictonaryMapper.selectByPrimaryKey(dictId);
	}

	@Override
	public TbDictionary getBySearchEntity(TbDictionary searchEntity) {
		TbDictionaryExample dictonaryExample = new TbDictionaryExample();
		TbDictionaryExample.Criteria createCriteria = dictonaryExample.createCriteria();
		if (searchEntity != null) {
			if (searchEntity.getDictId() != null) {
				createCriteria.andDictIdEqualTo(searchEntity.getDictId());
			}
			if (searchEntity.getDictName() != null) {
				createCriteria.andDictNameEqualTo(searchEntity.getDictName());
			}
			if (searchEntity.getDictValue() != null) {
				createCriteria.andDictValueEqualTo(searchEntity.getDictValue());
			}
			if (searchEntity.getDictMark() != null) {
				createCriteria.andDictMarkEqualTo(searchEntity.getDictMark());
			}
		}
		List<TbDictionary> dictionaryList = dictonaryMapper.selectByExample(dictonaryExample);
		return dictionaryList != null && dictionaryList.size() > 0 ? dictionaryList.get(0) : null;
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
