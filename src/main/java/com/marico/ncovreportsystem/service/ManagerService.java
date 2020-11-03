package com.marico.ncovreportsystem.service;

import java.util.List;

import com.marico.ncovreportsystem.entity.PageResult;
import com.marico.ncovreportsystem.entity.Result;
import com.marico.ncovreportsystem.pojo.TbManager;

public interface ManagerService {

	Result save(TbManager addManager);

	PageResult list(TbManager searchManager, Integer pageNum, Integer pageSize);

	TbManager getById(Integer hosId);

	Result update(TbManager updateManager);

	Result delete(Integer hosId);

	List<TbManager> listAll(TbManager searchManager);
}
