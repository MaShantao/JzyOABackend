package com.jzyoa.service;

import com.jzyoa.entity.PageResult;
import com.jzyoa.entity.Result;
import com.jzyoa.pojo.TbUser;

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
