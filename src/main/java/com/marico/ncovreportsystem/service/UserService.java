package com.marico.ncovreportsystem.service;

import com.marico.ncovreportsystem.entity.PageResult;
import com.marico.ncovreportsystem.entity.Result;
import com.marico.ncovreportsystem.pojo.TbUser;

public interface UserService {

	Result checkLogin(TbUser user);

	PageResult list(TbUser user, Integer pageNum, Integer pageSize);

	TbUser getByLoginName(String loginName);

	Result save(TbUser addUser);

	boolean checkLoginNameExist(String loginName);

	Result update(TbUser addUser);

	TbUser getByUserId(Integer userId);

	Result delete(Integer userId);

	Result cancelDelete(Integer userId);
	
}
