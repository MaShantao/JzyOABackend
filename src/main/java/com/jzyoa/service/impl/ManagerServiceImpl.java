package com.jzyoa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jzyoa.entity.PageResult;
import com.jzyoa.entity.Result;
import com.jzyoa.mapper.TbManagerMapper;
import com.jzyoa.pojo.TbManager;
import com.jzyoa.pojo.TbManagerExample;
import com.jzyoa.service.ManagerService;

@Service
public class ManagerServiceImpl implements ManagerService {

	@Autowired
	TbManagerMapper managerMapper;

	@Override
	public Result save(TbManager addManager) {
		return null;
	}

	@Override
	public PageResult list(TbManager searchManager, Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		TbManagerExample managerExample = new TbManagerExample();
		TbManagerExample.Criteria createCriteria = managerExample.createCriteria();
		if (searchManager != null) {
			if (searchManager.getManagerType() != null && searchManager.getManagerType() != 0) {
				createCriteria.andManagerTypeEqualTo(searchManager.getManagerType());
			}
		}
		Page<TbManager> pages = (Page<TbManager>) managerMapper.selectByExample(managerExample);
		return new PageResult(pages.getTotal(), pages.getResult());
	}

	@Override
	public TbManager getById(Integer managerId) {
		return managerMapper.selectByPrimaryKey(managerId);
	}

	@Override
	public Result update(TbManager updateManager) {
		return null;
	}

	@Override
	public Result delete(Integer hosId) {
		return null;
	}

	@Override
	public List<TbManager> listAll(TbManager searchManager) {
		TbManagerExample managerExample = new TbManagerExample();
		TbManagerExample.Criteria createCriteria = managerExample.createCriteria();
		if (searchManager != null) {
			if (searchManager.getManagerType() != null && searchManager.getManagerType() != 0) {
				createCriteria.andManagerTypeEqualTo(searchManager.getManagerType());
			}
		}
		return managerMapper.selectByExample(managerExample);
	}

}
