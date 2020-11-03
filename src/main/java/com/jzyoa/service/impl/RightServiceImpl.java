package com.jzyoa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jzyoa.mapper.TbRightMapper;
import com.jzyoa.pojo.TbRight;
import com.jzyoa.pojo.TbRightExample;
import com.jzyoa.pojo.TbRightExample.Criteria;
import com.jzyoa.service.RightService;

@Service
public class RightServiceImpl implements RightService {
	
	
	@Autowired
	TbRightMapper rightMapper;
	
	@Override
	public TbRight getById(Integer rightId) {
		return rightMapper.selectByPrimaryKey(rightId);
	}

	@Override
	public List<TbRight> listAll(TbRight right) {
		TbRightExample rightExample =  new  TbRightExample();
		Criteria createCriteria = rightExample.createCriteria();
		if(right!=null) {
			if(right.getParentId()!=null) {
				createCriteria.andParentIdEqualTo(right.getParentId());
			}
			if(right.getPath()!=null&&!"".equals(right.getPath())) {
				createCriteria.andPathEqualTo(right.getPath());
			}
			if(right.getLevel()!=null) {
				createCriteria.andLevelEqualTo(right.getLevel());
			}
		}
		return rightMapper.selectByExample(rightExample);
	}

}
