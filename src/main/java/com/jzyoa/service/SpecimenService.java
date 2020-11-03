package com.jzyoa.service;

import java.util.List;

import com.jzyoa.entity.PageResult;
import com.jzyoa.entity.Result;
import com.jzyoa.pojo.TbReport;
import com.jzyoa.pojo.TbSpecimen;

public interface SpecimenService {

	Result save(TbSpecimen addSpecimen);

	PageResult list(TbSpecimen searchSpecimen, Integer pageNum, Integer pageSize, Integer sortRule);

	TbSpecimen getById(Integer specimenId);

	Result update(TbSpecimen searchSpecimen);

	Result delete(Integer specimenId);

	List<TbSpecimen> listAll(TbSpecimen searchSpecimen);

	Result uploadFromCsvFile(String fileSaveRoute);

	int countBySearchEntity(List<TbReport> reportList, TbSpecimen searchSpecimen);

	PageResult testList(Integer pageNum, Integer pageSize);

}
