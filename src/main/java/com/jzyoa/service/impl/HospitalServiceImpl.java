package com.jzyoa.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jzyoa.entity.PageResult;
import com.jzyoa.entity.Result;
import com.jzyoa.mapper.TbHospitalMapper;
import com.jzyoa.pojo.TbHospital;
import com.jzyoa.pojo.TbHospitalExample;
import com.jzyoa.service.HospitalService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HospitalServiceImpl implements HospitalService {

	@Autowired
	private TbHospitalMapper hospitalMapper;

	@Override
	public PageResult list(TbHospital searchHospital, Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		TbHospitalExample hospitalExample = new TbHospitalExample();
		TbHospitalExample.Criteria createCriteria = hospitalExample.createCriteria();
		if (searchHospital != null) {
			if (searchHospital.getHosName() != null && !searchHospital.getHosName().equals("")) {
				createCriteria.andHosNameLike("%" + searchHospital.getHosName() + "%");
			}
			if (searchHospital.getHosAddress() != null && !searchHospital.getHosAddress().equals("")) {
				createCriteria.andHosAddressLike("%" + searchHospital.getHosAddress() + "%");
			}
		}
		Page<TbHospital> pages = (Page<TbHospital>) hospitalMapper.selectByExample(hospitalExample);
		return new PageResult(pages.getTotal(), pages.getResult());
	}

	@Override
	public TbHospital getById(Integer hosId) {
		return hospitalMapper.selectByPrimaryKey(hosId);
	}

	@Override
	public Result update(TbHospital updateHospital) {
		return hospitalMapper.updateByPrimaryKey(updateHospital) > 0 ? new Result(true, "更新成功")
				: new Result(true, "更新失败");
	}

	@Override
	public Result save(TbHospital addHospital) {
		return hospitalMapper.insert(addHospital) > 0 ? new Result(true, "添加成功") : new Result(true, "添加失败");
	}

	@Override
	public Result delete(Integer hosId) {
		return hospitalMapper.deleteByPrimaryKey(hosId) > 0 ? new Result(true, "删除成功") : new Result(true, "删除失败");
	}

	@Override
	public List<TbHospital> listAll(TbHospital searchHospital) {
		TbHospitalExample hospitalExample = new TbHospitalExample();
		TbHospitalExample.Criteria createCriteria = hospitalExample.createCriteria();
		if (searchHospital != null) {
			if (searchHospital.getHosName() != null && !searchHospital.getHosName().equals("")) {
				createCriteria.andHosNameLike("%" + searchHospital.getHosName() + "%");
			}
			if (searchHospital.getHosAddress() != null && !searchHospital.getHosAddress().equals("")) {
				createCriteria.andHosAddressLike("%" + searchHospital.getHosAddress() + "%");
			}
		}
		return hospitalMapper.selectByExample(hospitalExample);
	}

	@Override
	public TbHospital getByName(String hosName) {
		TbHospitalExample hospitalExample = new TbHospitalExample();
		TbHospitalExample.Criteria createCriteria = hospitalExample.createCriteria();
		createCriteria.andHosNameEqualTo(hosName);
		List<TbHospital> hosList = hospitalMapper.selectByExample(hospitalExample);
		return hosList != null && hosList.size() > 0 ? hosList.get(0) : null;
	}

}
