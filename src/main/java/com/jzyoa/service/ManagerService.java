package com.jzyoa.service;

import java.util.List;

import com.jzyoa.entity.PageResult;
import com.jzyoa.entity.Result;
import com.jzyoa.pojo.TbManager;

public interface ManagerService {

	Result save(TbManager addManager);

	PageResult list(TbManager searchManager, Integer pageNum, Integer pageSize);

	TbManager getById(Integer hosId);

	Result update(TbManager updateManager);

	Result delete(Integer hosId);

	List<TbManager> listAll(TbManager searchManager);
}
