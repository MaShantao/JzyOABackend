package com.jzyoa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jzyoa.entity.PageResult;
import com.jzyoa.entity.Result;
import com.jzyoa.mapper.TbDepartmentMapper;
import com.jzyoa.mapper.TbDoctorMapper;
import com.jzyoa.pojo.TbDoctor;
import com.jzyoa.pojo.TbDoctorExample;
import com.jzyoa.pojo.TbHospital;
import com.jzyoa.service.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	TbDoctorMapper doctorMapper;

	@Override
	public PageResult list(TbDoctor searchDoctor, Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		TbDoctorExample doctorExample = new TbDoctorExample();
		TbDoctorExample.Criteria createCriteria = doctorExample.createCriteria();
		if (searchDoctor != null) {
			if (searchDoctor.getDocName() != null && !searchDoctor.getDocName().equals("")) {
				createCriteria.andDocNameLike("%" + searchDoctor.getDocName() + "%");
			}
			if (searchDoctor.getDeptId() != null && searchDoctor.getDeptId() != 0) {
				createCriteria.andDeptIdEqualTo(searchDoctor.getDeptId());
			}
		}
		Page<TbDoctor> pages = (Page<TbDoctor>) doctorMapper.selectByExample(doctorExample);
		return new PageResult(pages.getTotal(), pages.getResult());
	}

	@Override
	public TbDoctor getById(Integer docId) {
		return doctorMapper.selectByPrimaryKey(docId);
	}

	@Override
	public Result update(TbDoctor updateDoctor) {
		return doctorMapper.updateByPrimaryKey(updateDoctor) > 0 ? new Result(true, "更新成功") : new Result(false, "更新失败");
	}

	@Override
	public Result save(TbDoctor addDoctor) {
		return doctorMapper.insert(addDoctor) > 0 ? new Result(true, "添加成功") : new Result(false, "添加失败");
	}

	@Override
	public Result delete(Integer docId) {
		return doctorMapper.deleteByPrimaryKey(docId) > 0 ? new Result(true, "添加成功") : new Result(false, "添加失败");
	}

	@Override
	public List<TbDoctor> listAll(TbDoctor searchDoctor) {
		TbDoctorExample doctorExample = new TbDoctorExample();
		TbDoctorExample.Criteria createCriteria = doctorExample.createCriteria();
		if (searchDoctor != null) {
			if (searchDoctor.getDocName() != null) {
				createCriteria.andDocNameLike("%" + searchDoctor.getDocName() + "%");
			}
			if (searchDoctor.getDeptId() != null && searchDoctor.getDeptId() != 0) {
				createCriteria.andDeptIdEqualTo(searchDoctor.getDeptId());
			}
		}
		return doctorMapper.selectByExample(doctorExample);
	}

	@Override
	public TbDoctor getBySearchEntity(TbDoctor searchDoctor) {
		TbDoctorExample doctorExample = new TbDoctorExample();
		TbDoctorExample.Criteria createCriteria = doctorExample.createCriteria();
		if (searchDoctor != null) {
			if (searchDoctor.getDocId() != null) {
				createCriteria.andDocIdEqualTo(searchDoctor.getDocId());
			}
			if (searchDoctor.getDocName() != null) {
				createCriteria.andDocNameEqualTo(searchDoctor.getDocName());
			}
			if (searchDoctor.getDeptId() != null) {
				createCriteria.andDeptIdEqualTo(searchDoctor.getDeptId());
			}
		}
		List<TbDoctor> doctorList = doctorMapper.selectByExample(doctorExample);
		return doctorList != null && doctorList.size() > 0 ? doctorList.get(0) : null;
	}
}
