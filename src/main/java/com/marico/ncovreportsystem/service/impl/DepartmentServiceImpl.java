package com.marico.ncovreportsystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.marico.ncovreportsystem.entity.PageResult;
import com.marico.ncovreportsystem.entity.Result;
import com.marico.ncovreportsystem.mapper.TbDepartmentMapper;
import com.marico.ncovreportsystem.pojo.TbDepartment;
import com.marico.ncovreportsystem.pojo.TbDepartmentExample;
import com.marico.ncovreportsystem.pojo.TbHospital;
import com.marico.ncovreportsystem.pojo.TbHospitalExample;
import com.marico.ncovreportsystem.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService{

	@Autowired
	private TbDepartmentMapper departmentMapper;
	
	
	@Override
	public Result save(TbDepartment addDepartment) {
		// TODO Auto-generated method stub
		return departmentMapper.insert(addDepartment)>0?new Result(true, "保存成功"):new Result(false, "保存失败");
	}

	@Override
	public PageResult list(TbDepartment searchDepartment, Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum,pageSize);
        TbDepartmentExample departmentExample = new TbDepartmentExample();
        TbDepartmentExample.Criteria createCriteria = departmentExample.createCriteria();
        if(searchDepartment!=null) {
            if(searchDepartment.getDeptName()!=null&&!searchDepartment.getDeptName().equals("")) {
                createCriteria.andDeptNameLike("%"+searchDepartment.getDeptName()+"%");
            }
            if(searchDepartment.getHosId()!=null&&searchDepartment.getHosId()!=0) {
                createCriteria.andHosIdEqualTo(searchDepartment.getHosId());
            }
        }
        Page<TbDepartment> pages = (Page<TbDepartment>) departmentMapper.selectByExample(departmentExample);
        return new PageResult(pages.getTotal(),pages.getResult());
	}

	@Override
	public TbDepartment getById(Integer deptId) {
		return departmentMapper.selectByPrimaryKey(deptId);
	}

	@Override
	public Result update(TbDepartment updateDepartment) {
		return departmentMapper.updateByPrimaryKey(updateDepartment)>0?new Result(true, "更新成功"):new Result(false, "更新失败");
	}

	@Override
	public Result delete(Integer deptId) {
		return departmentMapper.deleteByPrimaryKey(deptId)>0?new Result(true, "删除成功"):new Result(false, "删除失败");
	}

	@Override
	public List<TbDepartment> listAll(TbDepartment searchDepartment) {
		TbDepartmentExample departmentExample = new TbDepartmentExample();
        TbDepartmentExample.Criteria createCriteria = departmentExample.createCriteria();
        if(searchDepartment!=null) {
            if(searchDepartment.getDeptName()!=null&&!searchDepartment.getDeptName().equals("")) {
                createCriteria.andDeptNameLike("%"+searchDepartment.getDeptName()+"%");
            }
            if(searchDepartment.getHosId()!=null&&searchDepartment.getHosId()!=0) {
                createCriteria.andHosIdEqualTo(searchDepartment.getHosId());
            }
        }
		return departmentMapper.selectByExample(departmentExample);
	}
	
	@Override
	public List<TbDepartment> listByHosId(Integer hosId) {
		TbDepartmentExample departmentExample = new TbDepartmentExample();
		TbDepartmentExample.Criteria createCriteria = departmentExample.createCriteria();
		if(hosId!=null&&!hosId.equals(0)) {
			createCriteria.andHosIdEqualTo(hosId);
		}
		return departmentMapper.selectByExample(departmentExample);
	}

	@Override
	public TbDepartment getBySearchEntity(TbDepartment searchDepartment) {
		TbDepartmentExample departmentExample = new TbDepartmentExample();
        TbDepartmentExample.Criteria createCriteria = departmentExample.createCriteria();
        if(searchDepartment!=null) {
        	if(searchDepartment.getDeptId()!=null) {
        		createCriteria.andDeptIdEqualTo(searchDepartment.getDeptId());
        	}
            if(searchDepartment.getDeptName()!=null) {
                createCriteria.andDeptNameEqualTo(searchDepartment.getDeptName());
            }
            if(searchDepartment.getHosId()!=null) {
                createCriteria.andHosIdEqualTo(searchDepartment.getHosId());
            }
        }
        List<TbDepartment> departmentList = departmentMapper.selectByExample(departmentExample);
		return departmentList!=null&&departmentList.size()>0?departmentList.get(0):null;
	}
}
