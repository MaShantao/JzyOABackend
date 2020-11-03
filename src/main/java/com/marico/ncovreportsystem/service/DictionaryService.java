package com.marico.ncovreportsystem.service;

import java.util.List;

import com.marico.ncovreportsystem.pojo.TbDictionary;

public interface DictionaryService {

	List<TbDictionary> list(TbDictionary dictionary);
	
	List<TbDictionary> listByDictName(String dictName);
	
	List<TbDictionary> vagueListByDictName(String dictName);
	
	

	void update(TbDictionary dictionary);

	TbDictionary getById(Integer dictId);
	
	
	TbDictionary getBySearchEntity(TbDictionary searchEntity);
	
}
