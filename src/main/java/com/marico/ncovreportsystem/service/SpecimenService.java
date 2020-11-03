package com.marico.ncovreportsystem.service;

import java.util.List;

import com.marico.ncovreportsystem.entity.PageResult;
import com.marico.ncovreportsystem.entity.Result;
import com.marico.ncovreportsystem.pojo.TbReport;
import com.marico.ncovreportsystem.pojo.TbSpecimen;

public interface SpecimenService {

	Result save(TbSpecimen addSpecimen);

	PageResult list(TbSpecimen searchSpecimen, Integer pageNum, Integer pageSize, Integer sortRule);

	TbSpecimen getById(Integer specimenId);

	Result update(TbSpecimen searchSpecimen);

	Result delete(Integer specimenId);

	List<TbSpecimen> listAll(TbSpecimen searchSpecimen);

	Result uploadFromCsvFile(String fileSaveRoute);
	
	int countBySearchEntity(List<TbReport> reportList,TbSpecimen searchSpecimen);

	PageResult testList(Integer pageNum, Integer pageSize);

	
}
